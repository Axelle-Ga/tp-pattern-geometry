package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
    
    @Override
    public Geometry clone(){
        return this;
    };

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
}
