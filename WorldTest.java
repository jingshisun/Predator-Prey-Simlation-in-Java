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
public class WorldTest {

	// Test for World(String inputFileName)
	@Test
	public void world() throws FileNotFoundException {
		String fileName = "BadgerTestA.txt";
		World w = new World(fileName);
		assertTrue("Input File World method not correct, need to modify",
				w.grid[1][1].who() == State.BADGER);
	}

	// Test for World(int width)
	@Test
	public void worldTest() {

		World w = new World(3);
		w.grid[2][2] = new Grass(w, 2, 2);
		assertTrue("World method with width not correct", w.grid[2][2].who()
				.equals(State.GRASS));
	}

	// Test for getWidth()
	@Test
	public void getWdithTest() {
		World w = new World(5);
		assertEquals(5, w.getWidth());
	}

	// Test for randomInit()
	@Test
	public void randomInitTest() throws FileNotFoundException {
		String fileName = "BadgerTestA.txt";
		World a = new World(fileName);
		World b = new World(fileName);

		a.randomInit();

		boolean same = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!a.grid[i][j].who().equals(b.grid[i][j].who())) {
					same = false;
				}

			}
		}

		assertFalse("The randomInit() method is incorrect", same);

	}

	// Test for write(String outputFileName) method.
	@Test
	public void writeTest() throws FileNotFoundException {
		String fileIn = "BadgerTestA.txt";
		String out = "OutFileName.txt";
		World b = new World(fileIn);

		b.write(out);
		World c = new World(out); // Write the out file in.
		assertTrue("the out file is not correctly written", b.toString()
				.equals(c.toString()));

	}

}
