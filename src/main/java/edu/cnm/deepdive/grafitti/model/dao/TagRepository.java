package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.Tag;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, UUID> {
  Optional<Tag> findByUserAndCanvas(UUID user_key, UUID canvas_key);
  Optional<Tag> findByCanvas(UUID canvas_key);

}
