package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Jingshi Sun
 *
 */
public class GrassTest {
	// Tests for condition a
	@Test
	public void GrassTestA() throws FileNotFoundException {
		String fileName = "GrassTestA.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (b) is incorrect", life.who() == State.EMPTY);
	}

	// Tests for condition b
	@Test
	public void GrassTestB() throws FileNotFoundException {
		String fileName = "GrassTestB.txt";
		World w = new World(fileName);
		World wNew = new World(3);
		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (c) is incorrect", life.who() == State.RABBIT);
	}

	// Tests for condition c
	@Test
	public void GrassTestC() throws FileNotFoundException {
		String fileName = "GrassTestC.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (d) is incorrect", life.who() == State.GRASS);
	}

}
