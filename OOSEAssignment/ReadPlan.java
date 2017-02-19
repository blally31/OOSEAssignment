/****************************************************************************
** FILE: ReadPlan.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: To read in and process the plan file into its relevant data structure.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPlan {

    /**
   * Method for reading a plannt file containing details on all the plans to run 
   * for a particular simulation. 
   *
   * @param     filename    The name of the file to open containing the plan
   *                        information.
   * @param     controller  Contains the necessary data structures to read store 
   *                        the plan information in.
   * @return    nothing.
   * @throws    IOException             If the file cannot be opened.
   * @throws    FileFormatException     If the format of the file is incorrect.
   */
	public static void readPlanFile(String filename, Controller controller) 
        throws IOException, FileFormatException {

		BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        line = reader.readLine();
        while (line != null)
        {
            String[] parts = line.split(",", -1);
            if (parts.length != 3) {
                throw new FileFormatException(
                    "Incorrect Plan File Format. Cannot run Simulation!");
            }
            
            if (parts[1].equals("B")) {
                BuyPlan plan = new BuyPlan(Integer.parseInt(parts[0]), parts[2]);
                controller.addPlan(plan);
            }
            
            else if (parts[1].equals("S")) {
                SellPlan plan = new SellPlan(Integer.parseInt(parts[0]), parts[2]);
                controller.addPlan(plan);
            }
            
            line = reader.readLine();
        }
        reader.close();
	}
}