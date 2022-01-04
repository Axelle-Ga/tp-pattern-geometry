package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
    
    private List<GeometryListener> listeners;

    AbstractGeometry(){
        listeners = new ArrayList<>();
    }

    @Override
    abstract public Geometry clone();

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    }
    
    public Envelope getEnvelope(){
        EnvelopeBuilder visitor = new EnvelopeBuilder();
        this.accept(visitor);
        return visitor.build();
    }

    public void addListener(GeometryListener listener){
        listeners.add(listener);
    }

    protected void triggerChange(){
        for (GeometryListener geometryListener : listeners) {
            geometryListener.onChange(this);
        }
    }
}
