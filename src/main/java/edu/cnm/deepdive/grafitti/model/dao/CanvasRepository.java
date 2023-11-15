package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CanvasRepository extends JpaRepository<Canvas, UUID> {

  Optional<Canvas> findByKey(UUID user_key);

  List<Canvas> findAllByKey(UUID user_key);

  void delete(UUID canvas_key);
}
