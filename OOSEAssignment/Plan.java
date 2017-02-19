/****************************************************************************
** FILE: Plan.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents a plan proposed by a company director to simulate.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;

public abstract class Plan {

	public int year;
	public String property;

	public int getYear() {
		
		return year;
	}

	public String getPropertyName() {
		
		return property;
	}

	abstract void runPlan(HashMap<String, Property> map, Company primary);
}