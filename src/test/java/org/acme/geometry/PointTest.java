package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    
    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c = new Coordinate(8.2, 4.5);
	public static final Point point = new Point(c);
    public static final Point pointEmpty = new Point();

    @Test
	public void testDefaultConstructor(){
		
		Assert.assertEquals(Double.NaN, pointEmpty.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, pointEmpty.getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testConstructor(){
        
		Assert.assertEquals(8.2, point.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.5, point.getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testIsEmpty(){
		Assert.assertTrue(pointEmpty.isEmpty());
		Assert.assertFalse(point.isEmpty());
	}

    @Test
	public void testTranslate(){

        Point pointToTranslate = new Point(c);
        pointToTranslate.translate(5.0, 1.0);

		Assert.assertEquals(13.2, pointToTranslate.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.5, pointToTranslate.getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testClone(){

        Point pointToClone = new Point(c);
        Point pointCloned = pointToClone.clone();
        pointToClone.translate(5.0, 1.0);

		Assert.assertEquals(8.2, pointCloned.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.5, pointCloned.getCoordinate().getY(), EPSILON);
	}

	@Test 
    public void testGetEnvelope(){
		Envelope envEmpty = pointEmpty.getEnvelope();
		Envelope env = point.getEnvelope();

		Assert.assertTrue(envEmpty.isEmpty());
		Assert.assertFalse(env.isEmpty());
		Assert.assertEquals(8.2, env.getXmax(), EPSILON);
        Assert.assertEquals(8.2, env.getXmin(), EPSILON);
        Assert.assertEquals(4.5, env.getYmax(), EPSILON);
        Assert.assertEquals(4.5, env.getYmin(), EPSILON);
	}

	@Test
	public void testAccept() throws UnsupportedEncodingException{
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		String result = os.toString("UTF8");
		Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0\n", result);
	}

	@Test
	public void testAcceptWktVisitor() throws UnsupportedEncodingException{
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		WktVisitor visitor = new WktVisitor();
		geometry.accept(visitor);
		Assert.assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}

	@Test
	public void testAcceptWktVisitorEmpty() throws UnsupportedEncodingException{
		Geometry geometry = new Point();
		WktVisitor visitor = new WktVisitor();
		geometry.accept(visitor);
		Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}

}
