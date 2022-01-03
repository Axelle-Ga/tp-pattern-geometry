package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;
	public static final Coordinate coordEmpty = new Coordinate();
	public static final Coordinate coord = new Coordinate(3.1, 4.5);

	@Test
	public void testDefaultConstructor(){
		
		Assert.assertEquals(Double.NaN, coordEmpty.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, coordEmpty.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){

		Assert.assertTrue(coordEmpty.isEmpty());
		Assert.assertFalse(coord.isEmpty());
	}

}
