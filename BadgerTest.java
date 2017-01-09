package edu.iastate.cs228.hw1;
import java.io.File;
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
public class BadgerTest {
	
	//Test for condition a and also test whether the age increases every time we call next(). 
	@Test
	public void BadgerTestA() throws FileNotFoundException
	{
		String fileName="BadgerTestA.txt";
		World w =new World(fileName);
		World wNew=new World(3);
		Living life= w.grid[1][1];
		for (int a=0;a<5;a++) // integer a stands for age.
		{
			life=life.next(wNew);
			
			
			
		}
		
		
		assertTrue("Condition (a) or age is incorrect",life.who()==State.EMPTY);
	}
	//Test for condition b.
	@Test
	public void BadgerTestB() throws FileNotFoundException
	{
		String fileName="BadgerTestB.txt";
		World w =new World(fileName);
		World wNew=new World(3);
		
		w.grid[1][1].next(w);
		Living life= w.grid[1][1].next(wNew);
		assertTrue("Condition (b) is incorrect", life.who()==State.FOX);
	}
	//Test for condition c
	@Test
	public void BadgerTestC() throws FileNotFoundException
	{
		String fileName="BadgerTestC.txt";
		World w =new World(fileName);
		World wNew=new World(3);
		
		w.grid[1][1].next(w);
		Living life= w.grid[1][1].next(wNew);
		assertTrue("Condition (c) is incorrect", life.who()==State.EMPTY);
	}
	//Test for condition d
	@Test
	public void BadgerTestD() throws FileNotFoundException
	{
		String fileName="BadgerTestD.txt";
		World w =new World(fileName);
		World wNew=new World(3);
		
		w.grid[1][1].next(w);
		Living life= w.grid[1][1].next(wNew);
		assertTrue("Condition (d) is incorrect", life.who()==State.BADGER);
	}

}
