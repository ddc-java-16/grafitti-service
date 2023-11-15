package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.TagRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TagService implements AbstractTagService{

  private final TagRepository repository;
  public TagService(TagRepository repository) {
    this.repository = repository;
  }

  @Override
  public Tag create(Canvas canvas, MultipartFile bitmap) {
    return  repository
        .findById(canvas.getKey())
        .map((c) -> {
          // Store bitmap using StorageService, and get the storageKey returned it
          Tag tag = new Tag();
          tag.setCreated(Instant.now());
          tag.setCanvas(canvas);
          //tag.setBitmap(bitmap); // FIXME: 11/15/23
          return repository.save(tag);
        })
        .orElseThrow();
  }


  @Override
  public Optional<Tag> get(UUID canvas_key) {
    return repository
        .findByCanvas(canvas_key);
  }

  @Override
  public Optional<Tag> get(UUID user_id, UUID canvas_key) {
    return repository
        .findByUserAndCanvas(user_id, canvas_key);
  }
}
