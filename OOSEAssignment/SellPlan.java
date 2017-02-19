/****************************************************************************
** FILE: SellPlan.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents a plan to sell a property.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public class SellPlan extends Plan {

	public SellPlan(int inYear, String inProperty) throws FileFormatException{
		year = inYear;
		property = inProperty;
	}

	/**
   * Method for selling a property
   *
   * @param     map    		The property map
   * @param     primary    	The company that is selling the property
   * @return    nothing.
   */
	@Override
	public void runPlan(HashMap<String, Property> map, Company primary) {
		
		Property prop = map.get(property);
		//Get property from map and remove it from the primary company
		primary.sellProperty(prop);
	}
}