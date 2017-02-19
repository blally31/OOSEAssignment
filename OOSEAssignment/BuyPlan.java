/****************************************************************************
** FILE: BuyPlan.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents a plan to buy a property.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public class BuyPlan extends Plan {

	public BuyPlan(int inYear, String inProperty) throws FileFormatException{
		year = inYear;
		property = inProperty;
	}

	/**
   * Method for buying a property. 
   *
   * @param     map    		The property map
   * @param     primary    	The property map
   * @return    nothing.
   */
	@Override
	public void runPlan(HashMap<String, Property> map, Company primary) {
		
		Property prop = map.get(property);
		
		String previousOwner = prop.getOwner();
		//Update the previous owners bank account if it has one
		if (!previousOwner.equals("Unnamed Owner")) {
			//Update the bank account of the selling company
			map.get(previousOwner).updateBalance(prop.getValue());
			//Remove it from old company
			map.get(previousOwner).removeProperty(prop);
		}
		//Get property from map and add it to the primary company
		primary.buyProperty(prop);
	}
}