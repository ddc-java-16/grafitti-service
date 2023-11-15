package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import edu.cnm.deepdive.grafitti.service.AbstractTagService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TagController {

  private final AbstractTagService tagService;

  @Autowired
  public TagController(AbstractTagService tagService) {
    this.tagService = tagService;
  }
  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Tag> get(UUID user_id, UUID canvas_id) {
    return tagService.get(canvas_id, user_id);
  }
  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Tag> get(UUID canvas_id) {
    return tagService.get(canvas_id);
  }

  @PostMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Tag create(UUID canvas_key, MultipartFile bitmap){
    return tagService.create(canvas_key, bitmap);
  }

}
