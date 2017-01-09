package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail; 
/**
 * 
 * @author Jingshi Sun
 *
 */
public class LivingTest 

{
	//Test for census in normal case
	@Test
	public void censusTest() throws FileNotFoundException
	{
		int [] p=new int[5];
		String fileName="BadgerTestA.txt";
		World w=new  World(fileName);
		
		w.grid[1][1].census(p);
		assertEquals(2,p[0]);
		assertEquals(0, p[1]);
		assertEquals(0,p[2]);
		assertEquals(2,p[3]);
		assertEquals(5,p[4]);
			
	}
	//Test for census when this is in the boundary
	@Test
	public void censusBoundaryTest() throws FileNotFoundException
	{
		int [] p=new int[5];
		String fileName="BadgerTestC.txt";
		World w=new  World(fileName);
		
		w.grid[0][1].census(p);
		assertEquals(2,p[0]);
		assertEquals(0, p[1]);
		assertEquals(2,p[2]);
		assertEquals(0,p[3]);
		assertEquals(2,p[4]);
	}
	
	//Test for census when this is in the corner
	@Test
	public void censusCornerTest() throws FileNotFoundException
	{
		int [] p=new int[5];
		String fileName="RabbitTestA.txt";
		World w=new  World(fileName);
		
		w.grid[0][0].census(p);
		assertEquals(0,p[0]);
		assertEquals(0, p[1]);
		assertEquals(0,p[2]);
		assertEquals(3,p[3]);
		assertEquals(1,p[4]);
	}
	//Test for who()
	@Test
	public void whoTest() throws FileNotFoundException
	{
		
		String fileName="RabbitTestA.txt";
		World w=new  World(fileName);
		assertTrue("who() method is not correct",w.grid[0][0].who().equals(State.GRASS));
	}
	//Since next(World wNew) class has been tested many times in Living subclasses, I do not put it here.
	

}
