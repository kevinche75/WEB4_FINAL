package main.web.repo;

import main.web.entities.Point;
import main.web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PointRepository extends JpaRepository<Point, Long> {

    Collection<Point> findByUser(User user);
}