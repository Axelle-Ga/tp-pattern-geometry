package org.acme.geometry;

public class Coordinate {

    private double x;
    private double y;

    Coordinate(){
        this.x = Double.NaN;
        this.y = Double.NaN;
    }

    Coordinate(double x, double y){
        this.x = x;
        this.y = y;
        
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Boolean isEmpty(){
        return Double.isNaN(x) || Double.isNaN(y);
    }
}
