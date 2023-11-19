package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import edu.cnm.deepdive.grafitti.service.AbstractTagService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/canvases/{canvasKey}/tags")
public class TagController {

  private final AbstractTagService tagService;

  @Autowired
  public TagController(AbstractTagService tagService) {
    this.tagService = tagService;
  }
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Tag> get(@PathVariable UUID canvasKey) {
    return tagService.getByUserAndCanvas(userService.getCurrentUser(), canvasKey);
  }
//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Tag> get(UUID canvasKey) {
//    return tagService.get(canvasKey);
//  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Tag create(User user, UUID canvasKey, MultipartFile bitmap){
    return tagService.create(user, canvasKey, bitmap);
  }

}
