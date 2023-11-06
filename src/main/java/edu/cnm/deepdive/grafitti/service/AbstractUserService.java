package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.Entity.User;
import java.util.Optional;
import java.util.UUID;

public interface AbstractUserService {

  User getOrCreate(String oauthKey, String displayName);
  User getCurrentUser();
  User updateUser(User recieved);
  Optional<User> get (UUID key, User requester);


}
