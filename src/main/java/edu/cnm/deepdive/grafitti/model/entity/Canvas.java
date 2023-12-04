package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonView;
import edu.cnm.deepdive.grafitti.view.CanvasViews;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
@JsonView(CanvasViews.Summary.class)
public class Canvas {

  @Id
  @GeneratedValue
  @Column(name = "canvas_id", updatable = false)
  @JsonIgnore
  private int id;

  @NonNull
  @Column(name = "external_key", updatable = false, nullable = false, unique = true, columnDefinition = "UUID")
  @JsonProperty(value = "id", access = Access.READ_ONLY)
  private UUID key;
  @NonNull
  @Column(nullable = false, updatable = false, unique = true)
  private String name;

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

  @NonNull
  @OneToMany(mappedBy = "canvas", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderBy("created ASC")
  @JsonProperty(access = Access.READ_ONLY)
  @JsonView(CanvasViews.Detailed.class)
  private final List<Tag> tags = new LinkedList<>();


  public int getId() {
    return id;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  @NonNull
  public UUID getKey() {
    return key;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public User getUser() {
    return user;
  }

  public void setUser(@NonNull User user) {
    this.user = user;
  }

  @NonNull
  public List<Tag> getTags() {
    return tags;
  }


  @PrePersist
  private void generateKey() {
    key = UUID.randomUUID();
  }

}
