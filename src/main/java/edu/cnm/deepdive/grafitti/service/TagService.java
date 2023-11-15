package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.dao.TagRepository;
import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TagService implements AbstractTagService{

  private final TagRepository tagRepository;
  private final CanvasRepository canvasRepository;
  public TagService(TagRepository tagRepository, CanvasRepository canvasRepository) {
    this.tagRepository = tagRepository;
    this.canvasRepository = canvasRepository;
  }

  @Override
  public Tag create(User user, UUID canvasKey, MultipartFile bitmap) {
    return  tagRepository
        .findById(canvasKey)
        .map((c) -> {
          // Store bitmap using StorageService, and get the storageKey returned it
          Tag tag = new Tag();
          tag.setCreated(Instant.now());
          //tag.setBitmap(bitmap); // FIXME: 11/15/23
          return tagRepository.save(tag);
        })
        .orElseThrow();
  }


  @Override
  public List<Tag> get(UUID canvasKey) {
    return canvasRepository
        .findByKey(canvasKey)
        .map(tagRepository::findByCanvas)
        .orElseThrow();
    }

  @Override
  public List<Tag> getByUserAndCanvas(User user, UUID canvasKey) {
    return canvasRepository
        .findByKey(canvasKey)
        .map((canvas) -> tagRepository.findByUserAndCanvas(user, canvas))
        .orElseThrow();
  }
}
