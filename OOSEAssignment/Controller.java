/****************************************************************************
** FILE: Controller.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Provides the necessary data structures to run the company simulation.
** 			Stores the properties, events, plans, the primary company and the start
**			and year years.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.HashMap;
import java.util.LinkedList;

public class Controller {

	private HashMap<String, Property> propertyMap;
	private LinkedList<Event> eventList;
	private LinkedList<Plan> planList;
	private Company primaryCompany;
	private int startYear;
	private int endYear;

	public Controller() {
		
		propertyMap = new HashMap<String, Property>();
		eventList = new LinkedList<Event>();
		planList = new LinkedList<Plan>();
		primaryCompany = new Company();
		startYear = 0;
		endYear = 0;
	}	

	public String getPrimary() {
		
		return primaryCompany.getName();
	}

	public void setPrimary(Company company) {
		
		primaryCompany = company;
	}

	public void addProperty(Property property) {
		
		propertyMap.put(property.getName(), property);
	}

	public void addEvent(Event event) {
		
		eventList.add(event);	
	}

	public void addPlan(Plan plan) {
		
		planList.add(plan);
	}

	public int getStartYear() {
		
		return startYear;
	}

	public void setStartYear(int year) {
		
		startYear = year;
	}

	public int getEndYear() {
		
		return endYear;
	}

	public void setEndYear(int year) {
		
		endYear = year;
	}

	/**
   * Checks to see whether a company is owned by another company.
   *
   * @param 	owner 	The name of the owner to check.
   * @return 	true 	If the company does have an owner.
   *			false 	If the company doesn't have an owner.
   */
	public boolean checkOwner(String owner) {
		
		if (propertyMap.containsKey(owner)) {
			return true;
		}
		return false;
	}

	public Property getProperty(String name) {
		
		return propertyMap.get(name);
	}

	/**
   * Calculates the profits for every company within the simulation.
   *
   * @param 	none.
   * @return 	nothing.
   */
	public void calcProfits() {
		
		for (HashMap.Entry<String, Property> entry : propertyMap.entrySet()) {
			Property value = entry.getValue();
			if (value instanceof Company) {
				double val = value.calcProfit();
			}
		}
	}

	public void printCompanies() {
		
		for (HashMap.Entry<String, Property> entry : propertyMap.entrySet()) {
			Property value = entry.getValue();
			try {
				value.print();
			}
			catch (UnsupportedOperationException e) {}
		}
	}

	/**
   * Takes a given year and runs all the events for that particular year.
   *
   * @param 	year 		The year to run the events for.
   * @return 	nothing.
   */
	public void runEvents(int year) {
		
		//Only run events if there are events in the list and they match the given year.
		for (Event current : eventList) {
			if (current.getYear() == year) {
				current.runEvent(propertyMap);
			}
		}
	}	

	/**
   * Takes a given year and runs all the plans for that particular year.
   *
   * @param 	year 		The year to run the events for.
   * @return 	nothing.
   */
	public void runPlans(int year) {
		
		//Only run plans if there are plans in the list and they match the given year.
		for (Plan current : planList) {
			if (current.getYear() == year) {
				current.runPlan(propertyMap, primaryCompany);
			}
		}
	}	
}