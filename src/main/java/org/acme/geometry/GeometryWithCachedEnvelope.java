package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
    
    private Geometry original;
    private Envelope cachedEnvelope;

    GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = null;
    }

    @Override
    public String getType() {
        return original.getType();
    }

    @Override
    public Boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        original.translate(dx, dy);
    }

    @Override
    public Geometry clone() {
        return new GeometryWithCachedEnvelope(original.clone());
    }

    @Override
    public Envelope getEnvelope() {
        if (cachedEnvelope == null){
            EnvelopeBuilder visitor = new EnvelopeBuilder();
            this.accept(visitor);
            this.cachedEnvelope = visitor.build();
        }
        return cachedEnvelope;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        original.accept(visitor);
    }

    @Override
    public void onChange(Geometry geometry){
        original = geometry;
        EnvelopeBuilder visitor = new EnvelopeBuilder();
        this.accept(visitor);
        this.cachedEnvelope = visitor.build();
    }

    @Override
    public void addListener(GeometryListener listener){
        original.addListener(listener);
    }
}
