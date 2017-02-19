/****************************************************************************
** FILE: BankAccount.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: Represents a bank account as a subclass of property. Each company
** 			has exactly one bank account
** LAST MOD: 25/10/16
****************************************************************************
**/

public class BankAccount extends Property {

	public BankAccount() {
		name = "";
		owner = "";
		value = 0;
	}

	/**
   * Method for calculating the profit (interest) for a bank account. Interest is
   * calculated at 5% of the value. Can also be calculated on a negative value.
   *
   * @param 	none.
   * @return 	interest.
   */
	@Override
	public double calcProfit() {
		
		double interest = value * 0.05;
		//System.out.println("INTEREST = " + interest);
		return interest;
	}	
}