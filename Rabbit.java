package edu.iastate.cs228.hw1;


/*
 * A rabbit eats grass and lives no more than three years.
 *
 *
 * 
 * @author Jingshi Sun
 *
 */
public class Rabbit extends Living 
{
	private int age; 
	
	/**
	 * Creates a Rabbit object.
	 * @param w: world  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (World w, int r, int c, int a) 
	{
		super.world=w;
		super.row=r;
		super.column=c;
		age=a;
		
	}
	
	// Rabbit occupies the square.
	public State who()
	{
		 
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger, or it is eaten by a badger or a fox. 
	 * @param wNew  world of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(World wNew)
	{
		wNew=this.world;
		int [] population=new int[5];
		
		wNew.grid[this.row][this.column].census(population);
		Living life;
		if(this.age==RABBIT_MAX_AGE)
		{
			life= new Empty(wNew, this.row,this.column);
		}
		else if(population[3]==0)
		{
			life= new Empty(wNew, this.row,this.column);
		}
		else if(population[2]+population[0]>=population[4])
		{
			life= new Empty(wNew, this.row, this.column);
		}
		else
		{
			this.age+=1;
			life= this;
		}
		return life;
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		
	}
}
