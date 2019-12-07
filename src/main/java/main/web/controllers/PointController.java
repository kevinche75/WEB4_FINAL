package main.web.controllers;

import main.web.entities.Point;
import main.web.entities.SimplePoint;
import main.web.repo.PointRepository;
import main.web.repo.UserRepository;
import main.web.tools.Calculator;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class PointController {

    private final PointRepository pointRepository;
    private final UserRepository userRepository;

    PointController(PointRepository pointRepository, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/table")
    Collection<SimplePoint> allPoints(Principal user) {
        System.out.println("to get table of points of "+user.getName());
        Collection<SimplePoint> collection = new ArrayList<>();
        for (Point point:pointRepository.findByUser(userRepository.findByUsername(user.getName()))) {
            collection.add(point.convertToSimplePoint());
        }
        return collection;
    }

    @CrossOrigin
    @PostMapping("/table")
    SimplePoint newPoint(@RequestBody Point newPoint, Principal user) {
        Calculator.isInArea(newPoint);
        newPoint.setUser(userRepository.findByUsername(user.getName()));
        System.out.println("created new point: " +newPoint);
        return pointRepository.save(newPoint).convertToSimplePoint();
    }
}
