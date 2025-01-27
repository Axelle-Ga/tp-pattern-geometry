package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry{

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
        return "LINESTRING";
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
        triggerChange();
    }

    @Override
    public LineString clone(){
        List<Point> pointsCopy = new ArrayList<>();
        for (Point point : points) {
            pointsCopy.add(point.clone());
        }
        return new LineString(pointsCopy);
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}
