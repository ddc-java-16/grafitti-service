package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class Canvas {
  @Id
  @GeneratedValue
  @Column(name = "canvas_id", updatable = false)
  private int id;

  @NonNull
  @Column(name = "external_key", updatable = false, nullable = false, unique = true, columnDefinition = "UUID")
  @JsonProperty(namespace = "id", access = Access.READ_ONLY)
  private UUID key;

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
  @Column(name = "user_name")
  private String name;

  @NonNull
  @OneToMany(mappedBy = "canvas", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonProperty(access = Access.READ_ONLY)
  private final List<Tag> tags = new LinkedList<>();

  public int getId() {
    return id;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  @NonNull
  public String getName() {
    return name;
  }

  @NonNull
  public UUID getKey() {
    return key;
  }

  public void setUser(@NonNull User user) {
    this.user = user;
  }

  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public List<Tag> getTags() {
    return tags;
  }

  @PrePersist
  private void generateKey(){
    key = UUID.randomUUID();
  }
}
