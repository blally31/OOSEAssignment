/****************************************************************************
** FILE: ReadProperty.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: To read in and process the property file into its relevant data structure.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadProperty {

    /**
   * Method for reading a property file containing details on all the companies
   * and business units for a particular simulation. 
   *
   * @param     filename    The name of the file to open containing the property
   *                        information.
   * @param     controller  Contains the necessary data structures to read store 
   *                        the property information in.
   * @return    nothing.
   * @throws    IOException             If the file cannot be opened.
   * @throws    FileFormatException     If the format of the file is incorrect.
   */
    public static void readPropertyFile(String filename, Controller controller) 
        throws IOException, FileFormatException {
        boolean first = true;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        
        line = reader.readLine(); //Disregard the first line of the file
        
        while (line != null)
        {
            String[] parts = line.split(",", -1);
            
            if (parts.length != 6) {
                throw new FileFormatException(
                    "Incorrect Property File Format. Cannot run Simulation!");
            }

            if (parts[1].equals("C")) {
                
                Company company = new Company(parts[0], parts[2], Double.valueOf(parts[3]));
                //Sets the primary company to the first company read
                if (first) {
                    controller.setPrimary(company);
                    first = false;
                } 
                
                //Check if company is owned by another company
                if (!controller.checkOwner(parts[2])) {
                    controller.addProperty(company);
                }
                else {
                    //Add company to the property list of the company that owns it
                    Property comp = controller.getProperty(company.getOwner());
                    comp.addProperty(company);
                    controller.addProperty(company);
                }
            }
            else if (parts[1].equals("B")) {
                
                BusinessUnit business = new BusinessUnit(parts[0], parts[2], 
                    Double.valueOf(parts[3]), Double.valueOf(parts[4]), Double.valueOf(parts[5]));
                //Check if business owner is unnamed or not
                if (parts[2].equals("")) {
                    controller.addProperty(business);
                }
                else {
                    //Get the owning company and update its property list
                    Property comp = controller.getProperty(business.getOwner());
                    comp.addProperty(business);
                    controller.addProperty(business);
                }
            }
            
            line = reader.readLine();
        }
        reader.close();
    }
}