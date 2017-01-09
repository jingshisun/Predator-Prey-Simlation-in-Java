package edu.iastate.cs228.hw1;


/**
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 *
 * @author Jingshi
 */
public class Grass extends Living 
{
	public Grass (World w, int r, int c) 
	{
		super.world=w;
		super.row=r;
		super.column=c;
	}
	
	public State who()
	{
		
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by rabbits in the neighborhood. 
	 */
	public Living next(World wNew)
	{
		wNew=this.world;
		int [] population=new int[5];
		
		wNew.grid[this.row][this.column].census(population);
		Living life;
		if(population[4]>=2*population[3])
		{
			life= new Empty(wNew,this.row,this.column);
		}
		else if(population[4]>population[3])
		{
			life= new Rabbit(wNew, this.row,this.column,0);
		}
		else
		{
			
			life=this;
		}
		return life;
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		
	}
}
