package edu.iastate.cs228.hw1;


/**
 * 
 * Living refers to the life form occupying a square in a world grid. It is a 
 * superclass of Badger, Empty, Fox, Grass, and Rabbit, and has two abstract 
 * methods awaiting implementation. 
 *
 *
 * 
 * @author Jingshi Sun
 *
 */
public abstract class Living 
{
	protected World world; // the world in which the life form resides
	protected int row;     // location of the square on which 
	protected int column;  // the life form resides
	
	// constants to be used as indices. 
	protected static final int BADGER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int FOX = 2; 
	protected static final int GRASS = 3; 
	protected static final int RABBIT = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int BADGER_MAX_AGE = 4; 
	public static final int FOX_MAX_AGE = 5; 
	public static final int RABBIT_MAX_AGE = 3; 
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a world. 
	 * @param population  counts of all life forms
	 */
	protected void census(int population[]) 
	{
		
		population[0]=0;
		population[1]=0;
		population[2]=0;
		population[3]=0;
		population[4]=0;

		for (int i = row-1; i <=row+1; i++) {
			for (int j = column-1; j <= column+1; j++) {
				if (i >= 0 && i < world.getWidth()
						&&  j >= 0 && j < world.getWidth()) {
					if (world.grid[i][j].who().equals(State.BADGER)) {
						population[0] += 1;
					} else if (world.grid[i][j].who().equals(State.EMPTY)) {
						population[1] += 1;
					} else if (world.grid[i][j].who().equals(State.FOX)) {
						population[2] += 1;
					} else if (world.grid[i][j].who().equals(State.GRASS)) {
						population[3] += 1;
					} else
					{
						population[4] += 1;
					}
				}
			}

		}
			
		
		// 
		// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits  
		// in the 3 by 3 neighborhood centered at this Living object.  Store the 
		// counts in the array population[] at indices 0, 1, 2, 3, 4, respectively. 
	}
	

	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	// To be implemented in each class of Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// There are five states given in State.java. Include the prefix State in   
	// the return value, e.g., return State.Fox instead of Fox.  
	
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  wNew  world of the next cycle
	 * @return Living 
	 */
	public abstract Living next(World wNew); 
	// To be implemented in the classes Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// For each class (life form), carry out the following: 
	// 
	// 1. Obtains counts of life forms in the 3X3 neighborhood of the class object. 

	// 2. Applies the survival rules for the life form to determine the life form  
	//    (on the same square) in the next cycle.  These rules are given in the  
	//    project description. 
	// 
	// 3. Generate this new life form at the same location in the world wNew.      


}

