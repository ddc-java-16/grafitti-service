package edu.cnm.deepdive.grafitti.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
import jakarta.persistence.OrderBy;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
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

  @NonNull
  @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @OrderBy("id ASC")
  private final List<Point> points = new LinkedList<>();

  @NonNull
  @Column(nullable = false, updatable = false)
  private int color;

  @NonNull
  @Column(nullable = false, updatable = false)
  private int stroke;

  @NonNull
  @Column(nullable = false, updatable = false)
  private int brushStyle;

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

  public void setColor(int color) {
    this.color = color;
  }

  public int getColor() {
    return color;
  }

  public int getStroke() {
    return stroke;
  }

  public void setStroke(int stroke) {
    this.stroke = stroke;
  }

  public int getBrushStyle() {
    return brushStyle;
  }

  public void setBrushStyle(int brushStyle) {
    this.brushStyle = brushStyle;
  }

  @NonNull
  public Instant getCreated() {
    return created;
  }

  @NonNull
  public List<Point> getPoints() {
    return points;
  }

  @PrePersist
  private void generateKey() {
    key = UUID.randomUUID();
  }


}
