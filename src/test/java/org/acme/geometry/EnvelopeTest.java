package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

    public static final double EPSILON = 1.0e-15;
    public static final Envelope envEmpty = new Envelope();
    public static final Envelope env = new Envelope(new Coordinate(0.0, 1.0), new Coordinate(2.0, 3.0));

    @Test
	public void testDefaultConstructor(){
        Assert.assertEquals(Double.NaN, envEmpty.getXmax(), EPSILON);
        Assert.assertEquals(Double.NaN, envEmpty.getXmin(), EPSILON);
        Assert.assertEquals(Double.NaN, envEmpty.getYmax(), EPSILON);
        Assert.assertEquals(Double.NaN, envEmpty.getYmin(), EPSILON);
	}

    @Test
	public void testConstructor(){
        Assert.assertEquals(2.0, env.getXmax(), EPSILON);
        Assert.assertEquals(0.0, env.getXmin(), EPSILON);
        Assert.assertEquals(3.0, env.getYmax(), EPSILON);
        Assert.assertEquals(1.0, env.getYmin(), EPSILON);
	}

    @Test
	public void testIsEmpty(){
		Assert.assertTrue(envEmpty.isEmpty());
        Assert.assertFalse(env.isEmpty());
	}

    @Test
	public void testGetXmax(){
		//TODO
	}

    @Test
	public void testGetXmin(){
		//TODO
	}

    @Test
	public void testGetYmax(){
		//TODO
	}

    @Test
	public void testGetYmin(){
		//TODO
	}
}
