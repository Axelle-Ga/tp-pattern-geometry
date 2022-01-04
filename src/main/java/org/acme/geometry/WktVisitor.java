package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder buffer;

    WktVisitor(){
        buffer = new StringBuilder();
    }

    public void visit(Point point){        
        buffer.append(point.getType().toUpperCase());
        if (point.isEmpty()) {
            buffer.append(" EMPTY");
        }
        else{
                buffer.append("(");
                buffer.append(point.getCoordinate().getX());
                buffer.append(" ");
                buffer.append(point.getCoordinate().getY());
                buffer.append(")");
        }          
    }

    public void visit(LineString lineString){
        buffer.append(lineString.getType().toUpperCase());
        if (lineString.isEmpty()) {
            buffer.append(" EMPTY");
        }
        else {
            buffer.append("(");
            for (int i = 0; i < lineString.getNumPoints()-1; i++) {
                Point point = lineString.getPointN(i);
                buffer.append(point.getCoordinate().getX());
                buffer.append(" ");
                buffer.append(point.getCoordinate().getY());
                buffer.append(",");
            }
            buffer.append(lineString.getPointN(lineString.getNumPoints()-1).getCoordinate().getX());
            buffer.append(" ");
            buffer.append(lineString.getPointN(lineString.getNumPoints()-1).getCoordinate().getY());
            buffer.append(")");
        }
                
    }

    public String getResult(){
        return buffer.toString();
    }
}
