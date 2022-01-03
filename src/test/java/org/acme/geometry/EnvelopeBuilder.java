package org.acme.geometry;

import java.util.List;

public class EnvelopeBuilder {
    
    private List<Coordinate> listCoord;

    public void insert(Coordinate coordinate){
        listCoord.add(coordinate);
    }

    public Envelope build(){
        assert listCoord.size() > 0;
    }
}
