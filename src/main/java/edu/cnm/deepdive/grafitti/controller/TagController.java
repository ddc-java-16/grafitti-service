package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import edu.cnm.deepdive.grafitti.service.AbstractTagService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

  private final AbstractTagService tagService;

  @Autowired
  public TagController(AbstractTagService tagService) {
    this.tagService = tagService;

  }
  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Tag get() {
    return tagService.getCurrentTag();
  }

}
