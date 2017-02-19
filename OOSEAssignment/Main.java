/****************************************************************************
** FILE: Main.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Contains and runs the company simulation
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.io.IOException;


public class Main {

	/**
   * The main method for the program. Calls all the file readers to populate the 
   * controller object with all the necessary data to run the simulation.
   * Handles all the exceptions relating to file reading and command line arguments,
   * exiting with an appropriate error message as the simulation cannot run without
   * the correct data.
   *
   * @param 	args 	Contains the command line arguements: the filenames of the
   *					property, event and plan files along with the start and
   * 					end date for the simulation.
   * @return 	nothing.
   */
	public static void main(String[] args) {

		try {
			if (args.length != 5) {
				throw new IllegalArgumentException(
					"Incorrect number of command-line arguements");
			}
			
			Controller controller = new Controller();
			//Read input files into relevant data structures
			ReadProperty.readPropertyFile(args[0], controller);
			ReadEvent.readEventFile(args[1], controller);
			ReadPlan.readPlanFile(args[2], controller);

			controller.setStartYear(Integer.parseInt(args[3]));
			controller.setEndYear(Integer.parseInt(args[4]));
		
			if (controller.getEndYear() < controller.getStartYear()) {
				throw new IllegalArgumentException("End year is before start year");
			}

			runSimulation(controller);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (FileFormatException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
   * This method runs the simulation on a controller object from a given start date
   * to an end date.
   *
   * @param 	controller 	Contains the necessary data structures to run the simulation.
   * @return 	nothing.
   */
	public static void runSimulation(Controller controller) {

		for (int currentYear = controller.getStartYear(); currentYear <= 
			(controller.getEndYear() + 1); currentYear++) {

			if (currentYear > controller.getStartYear()) {
				//Calculate profits for previous year
				controller.calcProfits();
				System.out.println("Summary of Year : " + 
					(currentYear - 1) + "----------------------------------------");
				//Print out companies and respective bank balances
				controller.printCompanies();
				//Do all events for the current year
				controller.runEvents(currentYear);
				//Do all plans for the current year
				controller.runPlans(currentYear);
				
			}			
			//Will only execute the else during the first year (when current year is 
			//equal or less than the start year)
			else {
				//Do all events for the current year
				controller.runEvents(currentYear);
				//Do all plans for the current year
				controller.runPlans(currentYear);
				//controller.printCompanies();
			}
		}
	}
}