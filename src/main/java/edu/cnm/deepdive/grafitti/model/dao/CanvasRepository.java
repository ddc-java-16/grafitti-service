package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CanvasRepository extends JpaRepository<Canvas, UUID> {

  Optional<Canvas> findByKey(UUID canvasKey);

  List<Canvas> findAllByUser(User user);

  void delete(UUID canvasKey);

  Optional<Canvas> findByUserAndKey(User user, UUID canvasKey);
}
