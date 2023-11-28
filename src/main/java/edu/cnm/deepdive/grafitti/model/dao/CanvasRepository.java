package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CanvasRepository extends JpaRepository<Canvas, UUID> {

  Optional<Canvas> findByKey(UUID externalKey);

  List<Canvas> findAllByUser(User user);

  Optional<Canvas> findByKeyAndUser(UUID externalKey, User user);

 //void delete(UUID canvas_key);
}
