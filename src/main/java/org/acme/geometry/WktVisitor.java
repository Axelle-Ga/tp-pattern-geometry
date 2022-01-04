package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder buffer;

    public void visit(Point point){

    }

    public void visit(LineString lineString){

    }

    public String getResult(){
        return"";
    }
}
