/****************************************************************************
** FILE: WagesEvent.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents an increase or decrease in wages across all business units.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public class WagesEvent extends Event {

	public WagesEvent(int inYear, char inType) throws FileFormatException{
		year = inYear;
		if (inType == '-' || inType == '+') {
			type = inType;
		}
		else {
			throw new FileFormatException("Incorrect Wage Event type");
		}
	}

	/**
   * Method for running a wages increase event on all the businesses
   * in the simulation. 
   *
   * @param     map    		The property map
   * @return    nothing.
   */
	@Override
	public void increase(HashMap<String, Property> map) {
		//Iterate and update every business in the map
		for (HashMap.Entry<String, Property> entry : map.entrySet()) {
			Property value = entry.getValue();
			try {
				value.increaseWagePayment();
			}
			catch (UnsupportedOperationException e) {}
		}
	}

	/**
   * Method for running a wages decrease event on all the businesses
   * in the simulation. 
   *
   * @param     map    		The property map
   * @return    nothing.
   */
	@Override
	public void decrease(HashMap<String, Property> map) {
		//Iterate and update every business in the map
		for (HashMap.Entry<String, Property> entry : map.entrySet()) {
			Property value = entry.getValue();
			try {
				value.decreaseWagePayment();
			}
			catch (UnsupportedOperationException e) {}
		}
	}
}