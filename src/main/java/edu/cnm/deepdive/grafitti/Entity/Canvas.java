package edu.cnm.deepdive.grafitti.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Canvas {
  @Id
  @GeneratedValue
  @Column(name = "canvas_id", updatable = false)
  private Long id;

  public Long getId() {
    return id;
  }
}
