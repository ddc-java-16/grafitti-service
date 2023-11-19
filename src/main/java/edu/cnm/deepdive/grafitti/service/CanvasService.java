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
  public Canvas create(User user, Canvas canvas) {
    canvas.setUser(user);
          return  repository.save(canvas);


  }

  @Override
  public Optional<Canvas> get(UUID user_key) {
    return repository
        .findByKey(user_key);
  }

  @Override
  public void delete(User user, UUID canvasKey) {
    repository.findByUserAndKey(user, canvasKey)
        .ifPresent(repository::delete);
  }

  @Override
  public List<Canvas> getAll(User user){
    return repository.findAllByUser(user);
  }
}
