package org.acme.geometry;

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

}
