package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface AbstractTagService {

  Tag create(UUID canvas_key, MultipartFile bitmap);

  Optional<Tag> get (UUID canvas_key);

  Optional<Tag> get (UUID user_id, UUID canvas_id);

}
