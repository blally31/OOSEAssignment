/****************************************************************************
** FILE: Company.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents a company as a subclass of property.
** LAST MOD: 25/10/16
****************************************************************************
**/

import java.util.ArrayList;

public class Company extends Property {
	
	private ArrayList<Property> propertyList;
	private static int BANK_ACCOUNT = 0;

	public Company() {
		
		name = "";
		owner = "";
		value = 0.0;
		propertyList = new ArrayList<Property>();
		//Each Company has exactly one bank account
		propertyList.add(new BankAccount());
	}

	public Company(String inName, String inOwner, double inValue) {
		
		name = inName;
		owner = inOwner;
		value = inValue;
		propertyList = new ArrayList<Property>();
		//Each Company has exactly one bank account
		propertyList.add(new BankAccount());
	}

	/**
   * Updates the bank account balance by the amount given.
   *
   * @param 	amount 		The amount to add to the bank account (can be negative).
   * @return 	nothing.
   */
	@Override
	public void updateBalance(double amount) {
		
		propertyList.get(BANK_ACCOUNT).setValue(amount);
	}
	
	@Override
	public String getOwner() {
		
		if (owner.equals("")) {
			owner = "Unnamed Owner";
		}
		return owner;
	}

	@Override
	public void addProperty(Property property) {
		
		propertyList.add(property);
	}

	@Override
	public void removeProperty(Property property) {
		
		propertyList.remove(property);
	}

	/**
   * Method for a company to buy a property. Takes a property and then changes
   * the owner to itself, adds it to its list and then updates its bank account
   * by deducting the value of the property.
   *
   * @param 	property 	The property which is to be bought.
   * @return 	nothing.
   */
	public void buyProperty(Property property) {
		
		//Check whether the company already owns the property
		if (!propertyList.contains(property)) {
			//set new owner
			property.setOwner(this.getOwner());
			//Add the new property to the list
			addProperty(property);
			//Subtract the property value from the bank account
			updateBalance(-property.getValue());
		}
		
	}

	/**
   * Method for a company to sell a property. Takes a property and then checks
   * to see whether it actually owns it, removes it from its list and then updates 
   * its bank account by adding the value of the property.
   *
   * @param 	property 	The property which is to be sold.
   * @return 	nothing.
   */
	public void sellProperty(Property property) {
		
		//Check to see if the property is owned by the company
		if (propertyList.contains(property)) {
			removeProperty(property);
			//Add the property value to the bank account
			updateBalance(property.getValue());
		}
	}

	@Override
	public void print() {
		
		System.out.println("Company : " + name );
		System.out.println("Bank Account Balance : " + propertyList.get(0).getValue());
		System.out.println();
	}

	/**
   * Method for calculating the profit of a company. The profit for a company is
   * calculated by first calculating the profit of all the property that it owns, 
   * then calculating its bank interest.
   *
   * @param 	none.
   * @return 	profit 		The calculated profit for the particular company.
   */
	@Override
	public double calcProfit() {

		double profit = 0;
		double interest = 0;

		for (int i = 1; i < propertyList.size(); i++) {
			Property property = propertyList.get(i);
			profit += property.calcProfit();
		}
		
		if (profit < 0) {
			//Reduce the bank account balance by profit
			updateBalance(profit);
			//Calculate interest on bank account
			interest = propertyList.get(BANK_ACCOUNT).calcProfit();
			//Set bank account balance after interest
			updateBalance(interest);
			profit = 0;
		}
		else {
			profit *= 0.5;
			//Set bank account balance
			updateBalance(profit);
			//Calculate interest on bank account
			interest = propertyList.get(BANK_ACCOUNT).calcProfit();
			//Set bank account balance after interest
			updateBalance(interest);
		}
		return profit;
	}	
}