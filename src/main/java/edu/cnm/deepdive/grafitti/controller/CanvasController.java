package edu.cnm.deepdive.grafitti.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.service.AbstractCanvasService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import edu.cnm.deepdive.grafitti.view.CanvasViews;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canvases")
public class CanvasController {

  private final AbstractCanvasService canvasService;
  private final AbstractUserService userService;

  @Autowired
  public CanvasController(AbstractCanvasService canvasService, AbstractUserService userService) {
    this.canvasService = canvasService;
    this.userService = userService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

  public ResponseEntity<Canvas> post(@RequestBody Canvas canvas) {
    Canvas body = canvasService.save(userService.getCurrentUser(), canvas);
    URI location = WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(getClass())
                .get(body.getKey())
        )
        .toUri();
    return ResponseEntity.created(location).body(body);

  }

  @GetMapping(value = "/{canvasKey}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Canvas get(@PathVariable UUID canvasKey) {
    return canvasService.get(canvasKey);
  }

//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
//  @JsonView(CanvasViews.Summary.class)
//  public List<Canvas> getAll() {
//    return canvasService.getAll(userService.getCurrentUser());
//  }


  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonView(CanvasViews.Summary.class)
  public List<Canvas> getItAll() {
    return canvasService.getItAll();
  }
  @DeleteMapping(value = "/{canvasKey}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID canvasKey) {
    canvasService.delete(userService.getCurrentUser(), canvasKey);
  }
}
