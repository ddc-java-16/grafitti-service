package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.service.AbstractTagService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canvases/{canvasKey}/tags")
public class TagController {

  private final AbstractTagService tagService;
  private final AbstractUserService userService;

  @Autowired
  public TagController(AbstractTagService tagService, AbstractUserService userService) {
    this.tagService = tagService;
    this.userService = userService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Tag> get(@PathVariable UUID canvasKey) {
    return tagService.get(canvasKey);
  }

  @GetMapping(value = "/{tagKey}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Tag get(@PathVariable UUID canvasKey, @PathVariable UUID tagKey) {
    return tagService.get(canvasKey, tagKey);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Tag> post(@PathVariable UUID canvasKey, @RequestBody Tag tag) {
    Tag body = tagService.save(userService.getCurrentUser(), canvasKey, tag);
    URI location = WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(getClass())
                .get(canvasKey, body.getKey())
        )
        .toUri();
    return ResponseEntity.created(location)
        .body(body);

  }

}
