package edu.iastate.cs228.hw1;

import java.io.File;
 import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The world is represented as a square grid of size width X width. 
 *
 * 
 * @author Jingshi Sun
 *
 */
public class World 
{
	private int width; // grid size: width X width 
	
	public Living [][] grid;

	
	/**
	 *  Default constructor reads from a file 
	 */
	public World(String inputFileName) throws FileNotFoundException
	{ 
		int w=0; //w will be use to measure width.
		
		File file=new File(inputFileName);
		try{
		Scanner scan1=new Scanner(file);
		String line1=scan1.nextLine();
		Scanner scan2=new Scanner(line1);
		while(scan2.hasNext())
		{
			scan2.next();
			w+=1;
		}
		width=w;
		grid=new Living[w][w];
		Scanner scan3= new Scanner(file);
		for (int i =0; i<w;i++)
		{
			for (int j=0;j<w;j++)
			{
				String s=scan3.next();
				if(s.equals("B"))
				{
					grid[i][j]=new Badger(this, i,j, 0  );
					
				}
				else if(s.equals("E"))
				{
					grid[i][j]=new Empty(this,i,j);
				}
				else if(s.equals("F"))
				{
					grid[i][j]=new Fox(this,i,j,0);
				}
				else if(s.equals("G"))
				{
					grid[i][j]=new Grass(this,i,j);
				}
				else
				{
					grid[i][j]=new Rabbit(this,i,j,0);
					
				}
			}
		}
		
		scan1.close();
		scan2.close();
		scan3.close();}
		catch(FileNotFoundException e){
			System.out.println("e");
		}
		
	
		
		
			
			
		
		
		
		
		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid world in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. //How to close the file???
	}
	
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public World(int w)
	{
		width=w;
		grid=new Living[width][width]; 
	}
	
	
	public int getWidth()
	{
		 
		return width;  // to be modified 
	}
	
	/**
	 * Initialize the world by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 */
	public void randomInit()
	{
		int k=0;
		Random generator = new Random(); 
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<width;j++)
			{
				k=generator.nextInt(5);
				if(k==0)
				{
					grid[i][j]=new Badger(this,i,j,0);
				}
				else if(k==1)
				{
					grid[i][j]=new Empty(this,i,j);
				}
				else if(k==2)
				{
					grid[i][j]=new Fox(this,i,j,0);
				}
				else if(k==3)
				{
					grid[i][j]=new Grass(this,i,j);
				}
				else if(k==4)
				{
					grid[i][j]=new Rabbit(this,i,j,0);
				}
				
			}
		}
 
		
	}
	
	
	/**
	 * Write the world grid as a string according to the output format.
	 */
	@Override
	public String toString()
	{ 
		String s="";
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<width;j++)
			{
				 if(grid[i][j].who()==State.BADGER)
				 {
					 s+="B ";
				 }
				 else if(grid[i][j].who()==State.EMPTY)
				 {
					 s+="E ";
				 }
				 else if(grid[i][j].who()==State.FOX)
				 {
					 s+="F ";
				 }
				 else if(grid[i][j].who()==State.GRASS)
				 {
					 s+="G ";
				 }
				 else if(grid[i][j].who()==State.RABBIT)
				 {
					 s+="R ";
				 }
			}
			s+="\n";
			
		}
		return s;
		
		 
	}
	
	/**
	 * Write the world grid to an output file.  Useful for a randomly generated world. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		
		File outFile= new File(outputFileName);
		
		
		String s=this.toString();
		
		Scanner in = new Scanner(s);
		try {
			PrintWriter out = new PrintWriter(outFile);
			while(in.hasNext())
			{
				String line=in.nextLine();
				
				out.println(line);
			}
			out.close();
		} 
		
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		in.close();
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 

	}			
}
