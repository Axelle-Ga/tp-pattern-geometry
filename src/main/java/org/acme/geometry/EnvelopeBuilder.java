package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor {
    
    private List<Double> xVals;
    private List<Double> yVals;

    EnvelopeBuilder(){
        xVals = new ArrayList<>();
        yVals = new ArrayList<>();
    }

    public void visit(Point point){
        this.insert(point.getCoordinate());
    }
    
    public void visit(LineString lineString){
        for (int i =0; i<lineString.getNumPoints(); i++) {
            if (!lineString.getPointN(i).isEmpty()) {
                this.insert(lineString.getPointN(i).getCoordinate());
            } 
        }
    }

    public double getXvalsN(int i){
        return xVals.get(i);
    }

    public double getYvalsN(int i){
        return yVals.get(i);
    }
    
    public int getCoordSize(){
        assert xVals.size() == yVals.size();
        return yVals.size();
    }

    public void insert(Coordinate coordinate){
        xVals.add(coordinate.getX());
        yVals.add(coordinate.getY());
    }

    public Envelope build(){
        if(getCoordSize() > 0){
            double xmin = Collections.min(xVals);
            double xmax = Collections.max(xVals);
            double ymin = Collections.min(yVals);
            double ymax = Collections.max(yVals);
            return new Envelope(new Coordinate(xmin, ymin), new Coordinate(xmax, ymax));
        }
        else return new Envelope();
        
    }

}
