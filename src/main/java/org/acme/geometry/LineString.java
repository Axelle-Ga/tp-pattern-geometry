package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry{

    private List<Point> points;

    LineString(){
        points = new ArrayList<>();
    }

    LineString(List<Point> points){
        if (points == null){
            points = new ArrayList<>();
        }else{
        this.points = points;
        }
    }

    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }

    @Override
    public String getType(){
        return "LineString";
    }

    @Override
    public Boolean isEmpty(){
        if (getNumPoints()==0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void translate(double dx, double dy){
        for (Point point : points) {
           point.translate(dx, dy); 
        }
    }

    @Override
    public LineString clone(){
        List<Point> pointsCopy = new ArrayList<>();
        for (Point point : points) {
            pointsCopy.add(point.clone());
        }
        return new LineString(pointsCopy);
    }
}
