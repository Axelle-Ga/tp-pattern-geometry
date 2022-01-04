package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testWritePoint(){
        Geometry g = new Point(new Coordinate(3.0,4.0));
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
    }
    
    @Test
    public void testWriteEmptyPoint(){
        Geometry g = new Point();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT EMPTY", writer.write(g));
    }

    @Test
    public void testWriteLinestring(){
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(3.0,4.0)));
        points.add(new Point(new Coordinate(5.0,6.0)));
        Geometry g = new LineString(points);
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING(3.0 4.0,5.0 6.0)", writer.write(g));
    }
    
    @Test
    public void testWriteEmptyLinestring(){
        Geometry g = new LineString();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING EMPTY", writer.write(g));
    }
}
