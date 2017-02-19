/****************************************************************************
** FILE: ReadEvent.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: To read in and process the event file into its relevant data structure.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadEvent {

    /**
   * Method for reading an event file containing details on all the event to run 
   * for a particular simulation. 
   *
   * @param     filename    The name of the file to open containing the event
   *                        information.
   * @param     controller  Contains the necessary data structures to read store 
   *                        the event information in.
   * @return    nothing.
   * @throws    IOException             If the file cannot be opened.
   * @throws    FileFormatException     If the format of the file is incorrect.
   */
	public static void readEventFile(String filename, Controller controller) 
        throws IOException, FileFormatException {

		BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        line = reader.readLine();
        
        while (line != null)
        {
            String[] parts = line.split(",", -1);
            if (parts.length != 3) {
            	throw new FileFormatException(
                    "Incorrect Event File Format. Cannot run Simulation!");
            }
            
            if (parts[1].charAt(0) == 'W') {
                WagesEvent wage = new WagesEvent(Integer.parseInt(parts[0]), parts[1].charAt(1));
                controller.addEvent(wage);
            }
            else if (parts[1].charAt(0) == 'R') {
                RevenueEvent revenue = new RevenueEvent(
                    Integer.parseInt(parts[0]), parts[1].charAt(1), parts[2]);
                controller.addEvent(revenue);
            }
            else if (parts[1].charAt(0) == 'V') {
                ValueEvent values = new ValueEvent(
                    Integer.parseInt(parts[0]), parts[1].charAt(1), parts[2]);
                controller.addEvent(values);
            }

            line = reader.readLine();
        }
        reader.close();
	}
}