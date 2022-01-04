package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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

    @Test 
    public void testGetEnvelopeEmpty(){
        
        List<Point> points = new ArrayList<>();
        points.add(pt1);

        LineString l = new LineString(points);

        Envelope env = l.getEnvelope();

        Assert.assertTrue(env.isEmpty());
    }

    @Test 
    public void testGetEnvelope(){
        Point pt3 = new Point(new Coordinate(1.1, 5.5));
        Point pt4 = new Point(new Coordinate(1.5, 4.5));

        List<Point> points = new ArrayList<>();
        points.add(pt1);
        points.add(pt3);

        LineString l = new LineString(points);

        
        List<Point> points2 = new ArrayList<>();
        points2.add(pt3);
        points2.add(pt4);
        LineString l2 = new LineString(points2);

        Envelope env = l.getEnvelope();
        Envelope env2 = l2.getEnvelope();

        Assert.assertFalse(env2.isEmpty());
        Assert.assertEquals(1.5, env2.getXmax(), EPSILON);
        Assert.assertEquals(1.1, env2.getXmin(), EPSILON);
        Assert.assertEquals(5.5, env2.getYmax(), EPSILON);
        Assert.assertEquals(4.5, env2.getYmin(), EPSILON);

        Assert.assertFalse(env.isEmpty());
        Assert.assertEquals(1.1, env.getXmax(), EPSILON);
        Assert.assertEquals(1.1, env.getXmin(), EPSILON);
        Assert.assertEquals(5.5, env.getYmax(), EPSILON);
        Assert.assertEquals(5.5, env.getYmin(), EPSILON);
    }

    @Test
	public void testAccept() throws UnsupportedEncodingException {
		List<Point> points = new ArrayList<>();
        points.add(pt2);

        Geometry geometry = new LineString(points);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		String result = os.toString("UTF8");
		Assert.assertEquals("Je suis une polyligne avec 1 point(s)\n", result);
	}



}
