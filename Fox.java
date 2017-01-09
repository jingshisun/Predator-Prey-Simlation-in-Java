package edu.iastate.cs228.hw1;


/**
 * A fox eats rabbits and competes against a badger. 
 *
 * @author Jingshi
 */
public class Fox extends Living 
{
	private int age; 
	
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (World w, int r, int c, int a) 
	{
		super.world=w;
		super.row=r;
		super.column=c;
		age=a;
	}
	
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger or attack by one or more badgers. 
	 * @param wNew  world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew)
	{
		wNew=this.world;
		int [] population=new int[5];
		
		wNew.grid[this.row][this.column].census(population);
		Living life;
		if(this.age==FOX_MAX_AGE)
		{
			life=new Empty(wNew,this.row,this.column);
		}
		else if(population[0]>=population[2])
		{
			life=new Badger(wNew,this.row,this.column,0);
		}
		else if(population[0]+population[2]>population[4])
		{
			life=new Empty(wNew, this.row,this.column);
		}
		else
		{
			this.age+=1;
			life=this;
		}
		//wNew.grid[this.row][this.column]=life;
		return life;
		
		
		
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
		
	}
}
