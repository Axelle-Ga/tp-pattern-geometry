package org.acme.geometry;

import org.w3c.dom.views.AbstractView;

public class Point extends AbstractGeometry {

    private Coordinate coordinate;

    Point(){
        this.coordinate = new Coordinate();
    }

    Point(Coordinate coordinate){
        if ( coordinate == null ){
            this.coordinate = new Coordinate();
        }else{
            this.coordinate = coordinate;
        }
    }

    @Override
    public String getType() {
        return "POINT";
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    @Override 
    public Boolean isEmpty(){
        return getCoordinate().isEmpty();
    }

    @Override
    public void translate(double dx, double dy){
        double newX = dx + this.getCoordinate().getX();
        double newY = dy + this.getCoordinate().getY();
        Coordinate newCoord = new Coordinate(newX, newY);
        this.coordinate = newCoord;
        triggerChange();
    }

    @Override
    public Point clone(){
        return new Point(this.coordinate);
    }


    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }
}
