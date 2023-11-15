package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, UUID> {
  List<Tag> findByUserAndCanvas(User user, Canvas canvas);
  Optional<Tag> findByKey(UUID tagKey);
  List<Tag> findByCanvas(Canvas canvas);

}
