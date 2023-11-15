package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;


public interface AbstractTagService {

  Tag create(User user, UUID canvasKey, MultipartFile bitmap);

  List<Tag> get (UUID canvasKey);

  List<Tag> getByUserAndCanvas (User user, UUID canvasKey);

}
