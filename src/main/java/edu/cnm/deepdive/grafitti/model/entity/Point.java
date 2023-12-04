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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "point")
@JsonInclude(Include.NON_NULL)
public class Point {
  @Id
  @NonNull
  @GeneratedValue
  @Column(name = "point_id", nullable = false, updatable = false)
  @JsonIgnore
  private Long id;


  @Column(nullable = false, updatable = false)
  private int x;

  @Column(nullable = false, updatable = false)
  private int y;


  @NonNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tag_id", nullable = false, updatable = false)
  @JsonIgnore
  private Tag tag;

  @NonNull
  public Long getId() {
    return id;
  }



  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @NonNull
  public Tag getTag() {
    return tag;
  }

  public void setTag(@NonNull Tag tag) {
    this.tag = tag;
  }
}
