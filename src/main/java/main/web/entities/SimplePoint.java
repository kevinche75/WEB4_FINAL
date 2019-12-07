package main.web.entities;

import lombok.Data;

@Data
public class SimplePoint {

    private double x;
    private double y;
    private double r;
    private boolean isInArea;

    public SimplePoint(double x, double y, double r, boolean isInArea) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
    }
}
