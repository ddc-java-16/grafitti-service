package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.entity.Tag;
import edu.cnm.deepdive.grafitti.model.entity.User;
import org.springframework.web.multipart.MultipartFile;
import edu.cnm.deepdive.grafitti.service.StorageService.MediaTypeException;
import edu.cnm.deepdive.grafitti.service.StorageService.StorageException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

public interface AbstractTagService {

  Tag create(User user, UUID canvasKey, MultipartFile bitmap);

  List<Tag> get (UUID canvasKey);

  List<Tag> getByUserAndCanvas (User user, UUID canvasKey);

  String store(MultipartFile file) throws StorageService.StorageException, StorageService.MediaTypeException;

  Resource retrieve(String key) throws StorageService.StorageException;

  boolean delete(String key)  throws StorageService.StorageException, UnsupportedOperationException, SecurityException;


  class MediaTypeException extends RuntimeException{

    public MediaTypeException() {
    }

    public MediaTypeException(String message) {
      super(message);
    }

    public MediaTypeException(String message, Throwable cause) {
      super(message, cause);
    }

    public MediaTypeException(Throwable cause) {
      super(cause);
    }
  }

  class StorageException extends RuntimeException{

    public StorageException() {
    }

    public StorageException(String message) {
      super(message);
    }

    public StorageException(String message, Throwable cause) {
      super(message, cause);
    }

    public StorageException(Throwable cause) {
      super(cause);
    }
  }

}
