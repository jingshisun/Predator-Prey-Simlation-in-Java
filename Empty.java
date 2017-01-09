package edu.iastate.cs228.hw1;


/** 
 * Empty squares are competed by various forms of life.
 *
 * @author Jingshi
 */
public class Empty extends Living 
{
	public Empty (World w, int r, int c) 
	{
		super.world=w;
		super.row=r;
		super.column=c;
	}
	
	public State who()
	{
		
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by Badger, Fox, Rabbit, or Grass, 
	 * or remain empty. 
	 * @param wNew  world of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(World wNew)
	{
		wNew=this.world;
		int [] population=new int[5];
		
		wNew.grid[this.row][this.column].census(population);
		Living life;
		if(population[4]>1)
		{
			life= new Rabbit(wNew,this.row,this.column,0);
		}
		else if(population[2]>1)
		{
			life=new Fox(wNew,this.row,this.column,0);
		}
		else if(population[0]>1)
		{
			life=new Badger(wNew,this.row,this.column,0);
		}
		else if(population[3]>=1)
		{
			life=new Grass(wNew, this.row,this.column);
		}
		else
		{
			life=this;
		}
		return life;
		// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		
	}
}
