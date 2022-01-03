package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

    public static final double EPSILON = 1.0e-15;

    public static final Point pt1 = new Point(new Coordinate());
    public static final Point pt2 = new Point(new Coordinate(1.2, 3.5));
    
    

    @Test
	public void testDefaultConstructor(){

        LineString l = new LineString();

		Assert.assertEquals(0, l.getNumPoints(), EPSILON);
	}

    @Test
	public void testConstructor(){
        List<Point> points = new ArrayList<>();
        points.add(pt1);
        points.add(pt2);

        LineString l = new LineString(points);

		Assert.assertEquals(2, l.getNumPoints(), EPSILON);
        Assert.assertEquals(Double.NaN, l.getPointN(0).getCoordinate().getX(), EPSILON);
	}

    @Test
	public void testIsEmpty(){
        List<Point> points = new ArrayList<>();
        points.add(pt1);
        points.add(pt2);

        LineString l = new LineString(points);
        LineString lEmpty = new LineString();

		Assert.assertTrue(lEmpty.isEmpty());
		Assert.assertFalse(l.isEmpty());
	}
}
