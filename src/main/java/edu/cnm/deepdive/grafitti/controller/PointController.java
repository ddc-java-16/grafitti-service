package edu.cnm.deepdive.grafitti.controller;

import edu.cnm.deepdive.grafitti.model.entity.Point;
import edu.cnm.deepdive.grafitti.service.AbstractPointService;
import edu.cnm.deepdive.grafitti.service.AbstractUserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canvases/{canvasKey}/points")
public class PointController {
  private final AbstractPointService pointService;
  private final AbstractUserService userService;

  @Autowired
  public PointController(AbstractPointService pointService, AbstractUserService userService) {
    this.pointService = pointService;
    this.userService = userService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Point> get(@PathVariable UUID canvasKey) {
    return pointService.get(canvasKey);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Point post(@PathVariable UUID canvasKey, @RequestBody Point point){
    return pointService.save(userService.getCurrentUser(), canvasKey, point);
  }

}
