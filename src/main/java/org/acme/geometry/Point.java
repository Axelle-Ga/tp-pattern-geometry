package org.acme.geometry;

public class Point implements Geometry {

    private Coordinate coordinate;

    Point(){
        this.coordinate = new Coordinate();
    }

    Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

}
