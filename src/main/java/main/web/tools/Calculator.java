package main.web.tools;

import main.web.entities.Point;

public class Calculator {

    public static void isInArea(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();
        if(x>0 && y<0){
            point.setInArea(false);
            return;
        }
        if(x<=0 && y>=0){
            point.setInArea(y <= x + r/2);
            return;
        }
        if(x>=0 && y>=0){
            point.setInArea(Math.pow(x, 2) + Math.pow(y,2) <= Math.pow(r/2, 2));
            return;
        }
        if(x<=0 && y<=0){
            point.setInArea(x>-r/2 && y>-r);
            return;
        }
        point.setInArea(false);
    }
}