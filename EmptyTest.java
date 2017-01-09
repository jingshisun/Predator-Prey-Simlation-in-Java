package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 * 
 * @author Jingshi Sun
 *
 */
public class EmptyTest {
	// Tests for condition a
	@Test
	public void EmptyTestA() throws FileNotFoundException {
		String fileName = "EmptyTestA.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (b) is incorrect", life.who() == State.RABBIT);
	}

	// Tests for condition b
	@Test
	public void EmptyTestB() throws FileNotFoundException {
		String fileName = "EmptyTestB.txt";
		World w = new World(fileName);
		World wNew = new World(3);
		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (c) is incorrect", life.who() == State.FOX);
	}

	// Tests for condition c
	@Test
	public void EmptyTestC() throws FileNotFoundException {
		String fileName = "EmptyTestC.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (d) is incorrect", life.who() == State.BADGER);
	}

	// Tests for condition d
	@Test
	public void EmptyTestD() throws FileNotFoundException {
		String fileName = "EmptyTestD.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (d) is incorrect", life.who() == State.GRASS);
	}

	// Tests for condition e
	@Test
	public void EmptyTestE() throws FileNotFoundException {
		String fileName = "EmptyTestE.txt";
		World w = new World(fileName);
		World wNew = new World(3);

		w.grid[1][1].next(w);
		Living life = w.grid[1][1].next(wNew);
		assertTrue("Condition (d) is incorrect", life.who() == State.EMPTY);
	}

}
