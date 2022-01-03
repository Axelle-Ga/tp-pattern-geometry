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

    @Test
	public void testTranslate(){
        Point pt3 = new Point(new Coordinate(1.1, 5.5));
        Point pt4 = new Point(new Coordinate(2.2, 2.5));
        List<Point> points = new ArrayList<>();
        points.add(pt3);
        points.add(pt4);
        LineString lineToTranslate = new LineString(points);
        lineToTranslate.translate(5.2, 1.0);

		Assert.assertEquals(6.3, lineToTranslate.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(6.5, lineToTranslate.getPointN(0).getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testClone(){
        List<Point> points = new ArrayList<>();
        points.add(pt1);
        points.add(pt2);

        LineString l = new LineString(points);
        
        LineString lineCopy = l.clone();

        l.translate(5.2, 1.0);


		Assert.assertEquals(1.2, lineCopy.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(3.5, lineCopy.getPointN(1).getCoordinate().getY(), EPSILON);
	}



}
