package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;


public interface AbstractTagService {

  Tag create(User user, UUID canvasKey, MultipartFile bitmap);

  Optional<Tag> get (UUID canvasKey, UUID tagKey);

  Optional<Tag> get (UUID user_id, UUID canvas_id);

}
