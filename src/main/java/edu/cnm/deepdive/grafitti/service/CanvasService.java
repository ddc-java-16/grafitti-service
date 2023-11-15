package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
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
  public Optional<Canvas> create(UUID user_key, String canvasName) {
    return repository
        .findById(user_key)
        .map((c) -> {
          Canvas canvas = new Canvas();
          canvas.setName(canvasName);
          return  repository.save(canvas);
        });

  }

  @Override
  public Optional<Canvas> get(UUID user_key) {
    return repository
        .findByKey(user_key);
  }

  @Override
  public void delete(UUID canvas_key) {
    repository.delete(canvas_key);
  }

  @Override
  public List<Canvas> getAll(UUID user_key){
    return repository.findAllByKey(user_key);
  }
}
