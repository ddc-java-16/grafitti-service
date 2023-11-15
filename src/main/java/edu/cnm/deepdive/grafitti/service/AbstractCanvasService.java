package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AbstractCanvasService {

  Optional<Canvas> create(UUID user_key, String canvasName);

  Optional<Canvas> get (UUID user_key);

  List<Canvas> getAll (UUID user_key);

  void delete(UUID canvas_key);

}
