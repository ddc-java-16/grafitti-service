package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.service.AbstractCanvasService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
  public Canvas create(@RequestBody Canvas canvas) {
    return canvasService.create(userService.getCurrentUser(), canvas);
  }

  @GetMapping(value = "/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Canvas get(@PathVariable("key") UUID canvasKey) {
    return canvasService.get(canvasKey).orElseThrow();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Canvas> getAll(){
    return canvasService.getAll(userService.getCurrentUser());
  }

  @DeleteMapping(value = "/{key}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("key") UUID canvasKey){
     canvasService.delete(userService.getCurrentUser(), canvasKey);
  }
}
