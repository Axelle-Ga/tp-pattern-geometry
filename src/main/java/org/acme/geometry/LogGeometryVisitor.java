package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor{
    
    PrintStream printStream;

    LogGeometryVisitor(PrintStream printStream){
        this.printStream = printStream;
    }
    public void visit(Point point){
        double x = point.getCoordinate().getX();
        double y = point.getCoordinate().getY();
        printStream.println("Je suis un point avec x="+x+" et y="+y);
    }
    
    public void visit(LineString lineString){
        int n = lineString.getNumPoints();
        printStream.println("Je suis une polyligne avec "+n+" point(s)");
    }
}
