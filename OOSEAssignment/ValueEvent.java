/****************************************************************************
** FILE: ValueEvent.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents an increase or decrease in value for a business unit or company.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public class ValueEvent extends Event {

	private String business;

	public ValueEvent(int inYear, char inType, String inBusiness) throws FileFormatException {
		year = inYear;
		if (inType == '-' || inType == '+') {
			type = inType;
		}
		else {
			throw new FileFormatException("Incorrect Value Event type");
		}
		business = inBusiness;
	}

	public String getBusiness() {
		return business;
	}

	/**
   * Method for running a value decrease event on a particular
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
				prop.decreaseValue();
			}
			catch (UnsupportedOperationException e) {}	
		}
	}
	
	/**
   * Method for running a value increase event on a particular
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
				prop.increaseValue();
			}
			catch (UnsupportedOperationException e) {}	
		}	
	}
}