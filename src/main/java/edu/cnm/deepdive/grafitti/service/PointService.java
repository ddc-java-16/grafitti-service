package edu.cnm.deepdive.grafitti.service;

import edu.cnm.deepdive.grafitti.model.dao.CanvasRepository;
import edu.cnm.deepdive.grafitti.model.dao.PointRepository;
import edu.cnm.deepdive.grafitti.model.entity.Canvas;
import edu.cnm.deepdive.grafitti.model.entity.Point;
import edu.cnm.deepdive.grafitti.model.entity.User;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PointService implements AbstractPointService{

  private final PointRepository pointRepository;
  private final CanvasRepository canvasRepository;
  public PointService(PointRepository pointRepository, CanvasRepository canvasRepository) {
    this.pointRepository = pointRepository;
    this.canvasRepository = canvasRepository;
  }

  @Override
  public Point save(User user, UUID canvasKey, Point point) {
    // TODO: 11/28/23 incorporate user !
    return canvasRepository.findByKey(canvasKey)
        .map((canvas) -> {
          point.setCanvas(canvas);
          return pointRepository.save(point);
        })
        .orElseThrow();

  }


  @Override
  public List<Point> get(UUID canvasKey) {
    return canvasRepository
        .findByKey(canvasKey)
        .map(pointRepository::findByCanvasOrderByCreatedAsc)
        .orElseThrow();
  }


}
