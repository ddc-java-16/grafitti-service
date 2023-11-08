package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
public class Canvas {
  @Id
  @GeneratedValue
  @Column(name = "canvas_id", updatable = false)
  private int id;


  @NonNull
  @Column(name = "user_id", nullable = false, updatable = false)
  @JsonIgnore
  private int user_id;

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
  @Column(name = "bitmap")
  private String bitmap;

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
  public String getBitmap() {
    return bitmap;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public void setBitmap(@NonNull String bitmap) {
    this.bitmap = bitmap;
  }
}
