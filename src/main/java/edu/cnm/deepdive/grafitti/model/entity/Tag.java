package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tags")
@JsonInclude(Include.NON_NULL)
public class Tag {

  @Id
  @NonNull
  @GeneratedValue
  @Column(name = "tag_id", nullable = false, updatable = false)
  @JsonIgnore
  private int id;


  @NonNull
  @Column(name = "canvas_id", nullable = false, updatable = false)
  @JsonIgnore
  private int canvasId;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @JsonProperty(access = Access.READ_ONLY)
  private Instant created;

  @NonNull
  @Column(name = "bitmap")
  private String bitmap;

  public int getId() {
    return id;
  }

  public int getCanvasId() {
    return canvasId;
  }

  public void setCanvasId(int canvasId) {
    this.canvasId = canvasId;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  public void setCreated(@NonNull Instant created) {
    this.created = created;
  }

  @NonNull
  public String getBitmap() {
    return bitmap;
  }

  public void setBitmap(@NonNull String bitmap) {
    this.bitmap = bitmap;
  }
}
