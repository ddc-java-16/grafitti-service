package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.Optional;
import java.util.UUID;

public class CanvasService implements AbstractCanvasService{


  private final CanvasRepository repository;

  public CanvasService(CanvasRepository repository) {
    this.repository = repository;
  }

  @Override
  public Canvas create(UUID user_key, String canvasName) {
    return repository
        .findById(user_key)
        .map((canvas) -> {
          canvas = new Canvas();
          canvas.setName(canvasName);
          canvas.setUser(User );
        })

  }

  @Override
  public Optional<Canvas> get(UUID user_key) {
    return Optional.empty();
  }

  @Override
  public void delete(UUID canvas_key) {

  }
}
