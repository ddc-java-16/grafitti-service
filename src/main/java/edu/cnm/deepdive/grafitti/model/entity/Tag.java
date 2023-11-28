package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "tags")
@JsonInclude(Include.NON_NULL)
public class Tag {

  @Id
  @NonNull
  @GeneratedValue
  @Column(name = "tag_id", nullable = false, updatable = false)
  @JsonIgnore
  private long id;

  @NonNull
  @Column(name = "external_key", updatable = false, nullable = false, unique = true, columnDefinition = "UUID")
  @JsonProperty(namespace = "id", access = Access.READ_ONLY)
  private UUID key;


  @NonNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "canvas_id", nullable = false, updatable = false)
  @JsonIgnore
  private Canvas canvas;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false, updatable = false)
  @JsonIgnore
  private User user;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @JsonProperty(access = Access.READ_ONLY)
  private Instant created;

  public long getId() {
    return id;
  }

  @NonNull
  public UUID getKey() {
    return key;
  }

  @NonNull
  public Canvas getCanvas() {
    return canvas;
  }

  public void setCanvas(@NonNull Canvas canvas) {
    this.canvas = canvas;
  }

  @NonNull
  public User getUser() {
    return user;
  }

  public void setUser(@NonNull User user) {
    this.user = user;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }
  @PrePersist
  private void generateKey(){
    key = UUID.randomUUID();
  }

}
