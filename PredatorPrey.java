package edu.iastate.cs228.hw1;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * The PredatorPrey class does the predator-prey simulation over a grid world
 * with squares occupied by badgers, foxes, rabbits, grass, or none.
 *
 *
 * 
 * @author Jingshi Sun
 *
 */
public class PredatorPrey {
	/**
	 * Update the new world from the old world in one cycle.
	 * 
	 * @param wOld
	 *            old world
	 * @param wNew
	 *            new world
	 */
	public static void updateWorld(World wOld, World wNew) {
		// wNew= new World(wOld.getWidth());
		for (int i = 0; i < wOld.getWidth(); i++) {
			for (int j = 0; j < wOld.getWidth(); j++) {
				wNew.grid[i][j] = wOld.grid[i][j].next(wNew);
			}
		}
		//
		// For every life form (i.e., a Living object) in the grid wOld,
		// generate
		// a Living object in the grid wNew at the corresponding location such
		// that
		// the former life form changes into the latter life form.
		//
		// Employ the method next() of the Living class.
	}

	/**
	 * Repeatedly generates worlds either randomly or from reading files. Over
	 * each world, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("The Predator-Prey Simulator"+"\n"+"keys: 1 (random world) 2 (file input) 3 (exit)"+"\n");
		int i = 1;// i stands for number of trials.
		int num = 0;// integer num stands for the simulator keys.
		System.out.println("Trial 1:");
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			
			num = scan.nextInt();
			World even = null;
			int width = 0;

			if (num == 1) {
				
				System.out.println("Random world");
				System.out.println("Enter grid width:");
				width = scan.nextInt();
				even = new World(width);
			} else if (num == 2) {
				

				System.out.println("World input from a file");

				System.out.println("Enter a file name: ");

				String filename = scan.next();

				// Mechanism for the filename
				even = new World(filename);
				width = even.getWidth();

			}
			if(num==3)
			{
				System.out.println("Exit");
				break;
			}

			World odd = new World(width);
			even.randomInit();
			odd.randomInit();
			String Initial = even.toString();
			
			System.out.println("Enter the number of cycles:");
			int cycles = scan.nextInt();
			while (cycles <= 0) {
				cycles = scan.nextInt();
			}
			for (int m = 0; m < cycles; m++) // m stands for the number of
												// time cycles.
			{
				if (m % 2 == 0) {
					updateWorld(even, odd);
				} else {
					updateWorld(odd, even);
				}

			}
			String Final;
			if (cycles % 2 == 0) {
				Final = even.toString();
			} else {
				Final = odd.toString();
			}
			System.out.println("Initial World:"+"\n");
			System.out.println(Initial);
			System.out.println("Final World:"+"\n");
			System.out.println(Final);
			i += 1;
			System.out.println("Trial " + i + ":");

		}

		scan.close();

		// TODO
		//
		// Generate predator-prey simulations repeatedly like shown in the
		// sample run in the project description.
		//
		// 1. Enter 1 to generate a random world, 2 to read a world from an
		// input
		// file, and 3 to end the simulation. (An input file always ends with
		// the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description.
		//
		// 3. For convenience, you may define two worlds even and odd as below.
		// In an even numbered cycle (starting at zero), generate the world
		// odd from the world even; in an odd numbered cycle, generate even
		// from odd.

		// the world after an even number of cycles
		// the world after an odd number of cycles

		// 4. Print out initial and final worlds only. No intermediate worlds
		// should
		// appear in the standard output. (When debugging your program, you can
		// print intermediate worlds.)
		//
		// 5. You may save some randomly generated worlds as your own test
		// cases.
		//
		// 6. It is not necessary to handle file input & output exceptions for
		// this
		// project. Assume data in an input file to be correctly formated.

	}
}
