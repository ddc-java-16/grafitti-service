package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CanvasService implements AbstractCanvasService{


  private final CanvasRepository repository;

  public CanvasService(CanvasRepository repository) {
    this.repository = repository;
  }

  @Override
  public Canvas save(User user, Canvas canvas) {
    canvas.setUser(user);
    return repository.save(canvas);
  }

  @Override
  public Canvas get(UUID canvasKey) {
    return repository
        .findByKey(canvasKey)
        .orElseThrow();
  }

  @Override
  public void delete(User user, UUID canvasKey) {
    repository.findByKeyAndUser(canvasKey, user)
        .map((canvas) -> {
         repository.delete(canvas);
          return true;
        })
        .orElseThrow();
  }

  @Override
  public List<Canvas> getAll(User user){
    return repository.findAllByUser(user);
  }
}
