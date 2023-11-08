package edu.cnm.deepdive.grafitti.model.dao;


import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CanvasRepository extends JpaRepository<User, Long> {

  Optional<User> findByKey(UUID key);
  Optional<User> findByOauthKey(String oauthKey);


}
