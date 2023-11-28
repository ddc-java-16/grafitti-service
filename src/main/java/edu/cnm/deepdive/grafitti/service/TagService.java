package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.dao.TagRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TagService implements AbstractTagService {

  private final TagRepository tagRepository;
  private final CanvasRepository canvasRepository;

  public TagService(TagRepository tagRepository, CanvasRepository canvasRepository) {
    this.tagRepository = tagRepository;
    this.canvasRepository = canvasRepository;
  }

  @Override
  public Tag save(User user, UUID canvasKey, Tag tag) {
    return canvasRepository
        .findByKey(canvasKey)
        .map((canvas) -> {
          tag.setCanvas(canvas);
          tag.setUser(user);
          return tagRepository.save(tag);
        })
        .orElseThrow();
  }


  @Override
  public Tag get(UUID canvasKey, UUID tagKey) {
    return canvasRepository
        .findByKey(canvasKey)
        .flatMap((canvas) -> tagRepository.findByCanvasAndKey(canvas, tagKey))
        .orElseThrow();
  }

  @Override
  public List<Tag> get(UUID canvasKey) {
    return canvasRepository
        .findByKey(canvasKey)
        .map(Canvas::getTags)
        .orElseThrow();
  }
}
