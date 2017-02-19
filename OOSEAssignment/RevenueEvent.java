/****************************************************************************
** FILE: RevenueEvent.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents an increase or decrease in revenue for a business.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public class RevenueEvent extends Event {

	private String business;

	public RevenueEvent(int inYear, char inType, String inBusiness) 
		throws FileFormatException {
		year = inYear;
		if (inType == '-' || inType == '+') {
			type = inType;
		}
		else {
			throw new FileFormatException("Incorrect Revenue Event type");
		}
		business = inBusiness;
	}

	public String getBusiness() {
		return business;
	}

	/**
   * Method for running a revenue decrease event on a particular
   * business. 
   *
   * @param     map    		The property map
   * @return    nothing.
   */
	@Override
	public void decrease(HashMap<String, Property> map) {
		
		if (map.containsKey(business)) {
			Property prop = map.get(business);
			try {
				prop.decreaseRevenue();
			}
			catch (UnsupportedOperationException e) {}	
		}
	}
	
	/**
   * Method for running a revenue increase event on a particular
   * business. 
   *
   * @param     map    		The property map
   * @return    nothing.
   */
	@Override	
	public void increase(HashMap<String, Property> map) {

		if (map.containsKey(business)) {
			Property prop = map.get(business);
			try {
				prop.increaseRevenue();
			}
			catch (UnsupportedOperationException e) {}	
		}	
	}
}