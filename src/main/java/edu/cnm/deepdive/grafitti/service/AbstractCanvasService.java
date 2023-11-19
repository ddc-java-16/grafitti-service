package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AbstractCanvasService {

 Canvas create(User user, Canvas canvas);

  Optional<Canvas> get (UUID canvasKey);

 void delete(User user, UUID canvasKey);

 List<Canvas> getAll (User user);

}
