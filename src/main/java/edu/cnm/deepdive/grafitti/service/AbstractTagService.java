package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface AbstractTagService {

  Tag save(User user, UUID canvasKey, Tag tag);

  Tag get (UUID canvasKey, UUID tagKey);

  List<Tag> get (UUID canvasKey);

}
