package org.acme.geometry;

import static org.junit.Assert.assertSame;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testGetEnevelope(){
        Geometry g = new Point(new Coordinate(3.0,3.0));
        // décoration
        g = new GeometryWithCachedEnvelope(g);
        Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
        Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
        Assert.assertSame(a,b);
    }

    @Test
    public void testOnChange(){
        Geometry geom = new Point(new Coordinate(3.0,3.0));
        // décoration
        GeometryWithCachedEnvelope g = new GeometryWithCachedEnvelope(geom);
        geom.addListener(g);
        g.translate(1.0, 2.0);

        Assert.assertEquals(g.getEnvelope().getXmax(), geom.getEnvelope().getXmax(), EPSILON);
        Assert.assertEquals(g.getEnvelope().getXmin(), geom.getEnvelope().getXmin(), EPSILON);
        Assert.assertEquals(g.getEnvelope().getYmax(), geom.getEnvelope().getYmax(), EPSILON);
        Assert.assertEquals(g.getEnvelope().getYmin(), geom.getEnvelope().getYmin(), EPSILON);
    }
}
