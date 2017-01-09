package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Jingshi Sun
 *
 */
public class RabbitTest {
	//Test for condition a and also tests whether ages increases every time we call next().
		@Test
		public void RabbitTestAges() throws FileNotFoundException
		{
			String fileName="RabbitTestA.txt";
			World w =new World(fileName);
			World wNew=new World(3);
			Living life= w.grid[1][1];
			for (int a=0;a<4;a++) // integer a stands for age.
			{
				life=life.next(wNew);
				
				
				
			}
			
			assertTrue("Condition (a) or age is incorrect",life.who()==State.EMPTY);
		}
		//Test for condition b
		@Test
		public void RabbitTestB() throws FileNotFoundException
		{
			String fileName="RabbitTestB.txt";
			World w =new World(fileName);
			World wNew=new World(3);
			
			w.grid[1][1].next(w);
			Living life= w.grid[1][1].next(wNew);
			assertTrue("Condition (b) is incorrect", life.who()==State.EMPTY);
		}
		//Tests for condition c
		@Test
		public void RabbitTestC() throws FileNotFoundException
		{
			String fileName="RabbitTestC.txt";
			World w =new World(fileName);
			World wNew=new World(3);
			w.grid[1][1].next(w);
			Living life= w.grid[1][1].next(wNew);
			assertTrue("Condition (c) is incorrect", life.who()==State.EMPTY);
		}
		//Tests for condition d
		@Test
		public void RabbitTestD() throws FileNotFoundException
		{
			String fileName="RabbitTestD.txt";
			World w =new World(fileName);
			World wNew=new World(3);
			
			w.grid[1][1].next(w);
			Living life= w.grid[1][1].next(wNew);
			assertTrue("Condition (d) is incorrect", life.who()==State.RABBIT);
		}

	}



