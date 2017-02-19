/****************************************************************************
** FILE: Property.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: An abstract class to represent a Property and its generic properties
** LAST MOD: 25/10/16
****************************************************************************
**/

public abstract class Property {
	
	public String name;
	public String owner;
	public double value;

	public void setName(String inName) {
		name = inName;
	}
	public String getName() {
		return name;
	}

	public void setOwner(String newOwner) {
		owner = newOwner;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setValue(double inValue) {
		value += inValue;
	}

	public void updateBalance(double inValue) {
		setValue(inValue);
	}
	
	public double getValue() {
		return value;
	}

	public void increaseValue() {
		value *= 1.05;
	}

	public void decreaseValue() {
		value *= 0.95;
	}

	//Default implementations. Business Units and Bank Accounts do not support these operations
	public void addProperty(Property property) {
		throw new UnsupportedOperationException("Cannot add property");
	}

	public void removeProperty(Property property) {
		throw new UnsupportedOperationException("Cannot remove property");
	}

	//Default implementations. Companies and Bank Accounts do not support these operations
	public void increaseWagePayment() {
		throw new UnsupportedOperationException("Cannot increase Wage Payments");
	}
	public void decreaseWagePayment() {
		throw new UnsupportedOperationException("Cannot decrease Wage Payments");
	}
	public void increaseRevenue() {
		throw new UnsupportedOperationException("Cannot increase Revenue");
	}
	public void decreaseRevenue() {
		throw new UnsupportedOperationException("Cannot decrease Revenue");
	}

	abstract double calcProfit();

	public void print() {
		throw new UnsupportedOperationException();
	}

	
}