package org.acme.geometry;

public class WktWriter {
    WktWriter(){

    }

    public String write(Geometry geometry){
        String type = geometry.getType().toUpperCase();
        if (geometry.isEmpty()) {
            return type + " EMPTY";
        }
        else{
            if ( geometry instanceof Point ){
                Point point = (Point)geometry;
                return type + "(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY()+")";
            }else if ( geometry instanceof LineString ){
                LineString lineString = (LineString)geometry;
                String coord = "(";
                for (int i = 0; i < lineString.getNumPoints()-1; i++) {
                    Point point = lineString.getPointN(i);
                    coord+=point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ",";
                }
                coord+=lineString.getPointN(lineString.getNumPoints()-1).getCoordinate().getX() + " " + lineString.getPointN(lineString.getNumPoints()-1).getCoordinate().getY() + ")";
                return type + coord;
            }else{
                throw new RuntimeException("geometry type not supported");
            }
        }
        
    }
}
