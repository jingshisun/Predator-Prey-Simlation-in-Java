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
public class PredatorPreyTest 
{
	//Test for updateWorldTest() method.
	@Test
	public void updateWorldTest() throws FileNotFoundException
	{
		String fileNameOne="BadgerTestA.txt";
		String fileNameTwo="BadgerTestAUpdate.txt"; // I create an updated world of "BadgerTestA" by my self. It will be compared with wNew.
		
		World one = new World(fileNameOne);
		
		World wNew= new World(3);                //This is the world updated by updateWorld(one, new).
		PredatorPrey.updateWorld(one, wNew);
		
		
		World two =new World(fileNameTwo);       //World two is an world that correctly updated the World one.
		boolean same=true;
		
		
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3; j++)
			{
				if(!wNew.grid[i][j].who().equals(two.grid[i][j].who())) // Comparing every square of the two worlds.
				{
					same=false;
				}
			}
				
		}
		assertTrue("updateWorld(World wOld,World wNew) is incorrect",same); //The two worlds should be the same.
	}

}
