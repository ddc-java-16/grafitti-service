package edu.cnm.deepdive.grafitti.model.dao;

import edu.cnm.deepdive.grafitti.entity.Tag;
import edu.cnm.deepdive.grafitti.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {
  Optional<Tag> findByUserAndCanvas();
  Optional<Tag> findByCanvas();
  Optional<Tag> findByOauthKey(String oauthKey);


}
