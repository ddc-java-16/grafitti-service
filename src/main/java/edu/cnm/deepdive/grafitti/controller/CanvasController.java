package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.service.AbstractCanvasService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CanvasController {

  private final AbstractCanvasService canvasService;

  @Autowired
  public CanvasController(AbstractCanvasService canvasService) {
    this.canvasService = canvasService;
  }

  @PostMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Canvas> create(UUID user_key, String canvasName) {
    return canvasService.create(user_key, canvasName);
  }

  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Canvas> get(UUID user_key) {
    return canvasService.get(user_key);
  }

  @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Canvas> getAll(UUID user_key){
    return canvasService.getAll(user_key);
  }

  @DeleteMapping(value = "/me")
  public void delete(UUID canvas_id){
     canvasService.delete(canvas_id);
  }
}
