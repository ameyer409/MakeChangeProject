/*
In the cash register we will calculate the amount of change returned to a customer 
based on the purchase price and the amount tendered. We will also notify the 
attendant how many of each piece of currency 
($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. 
Change should be provided using the largest bill and coin denominations as possible. 
Denominations that are not used should not be displayed.
*/

package MakeChange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		double amount = 0.0, tendered = 0.0, change = 0.0;

		// Part 1: The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you wish to purchase: ");
		amount = kb.nextDouble();

		// Part 2: The user is then prompted asking how much
		// money was tendered by the customer.
		System.out.print("How much money are you purchasing with: ");
		tendered = kb.nextDouble();

		System.out.println("amount: " + amount);
		System.out.println("tendered: " + tendered);
		System.out.print("change: ");
		// Part 3: Display an appropriate message if the customer
		// provided too little money or the exact amount.
		if (amount > tendered) {
			System.out.println("That is not enough money for what you wish to purchase");
		}
		/*
		 * Part 4: If the amount tendered is more than the cost of the item, display the
		 * number of bills and coins that should be given to the customer.
		 */
		else {
			change = tendered - amount;
			System.out.println(change);
			// if (change > 20 && change % 20 != 0 || change == 20) {
			if (change >= 40) {
				System.out.print((int) (change / 20) + " twenty dollar bills, ");
				change = change - ((int) (change / 20) * 20);
			}
			else if (change >= 20){
				System.out.print((int) (change / 20) + " twenty dollar bill, ");
				change = change - ((int) (change / 20) * 20);
			}
			
			if (change >= 10) {
				System.out.print((int) (change / 10) + " ten dollar bill, ");
				change = change - ((int) (change / 10) * 10); // this could also just subtract ten, since this register
																// can only ever give back 1 ten dollar bill
			}
			
			if (change >= 5) {
				System.out.print((int) (change / 5) + " five dollar bill, ");
				change = change - ((int) (change / 5) * 5);
			}
			
			if (change >= 2) {
				System.out.print((int) (change / 1) + " one dollar bills, ");
				change = change - ((int) change);
			}
			else if (change >=1) {
				System.out.print((int) (change / 1) + " one dollar bill, ");
				change = change - ((int) change);
			}
			
			if (change >= .50) {
				System.out.print((int) (change / .25) + " quarters, ");
				change = fmod(change, 0.25);
			}
			else if (change >= .25) {
				System.out.print((int) (change / .25) + " quarter, ");
				change = fmod(change, 0.25);
			}
			
			if (change >= .20) {
				System.out.print((int) (change / .10) + " dimes, ");
				change = fmod(change, 0.1);
			}
			else if (change >= .10) {
				System.out.print((int) (change / .10) + " dime, ");
				change = fmod(change, 0.1);
			}
			
			if (change >= .05) {
				System.out.print((int) (change / .05) + " nickel, ");
				change = fmod(change, 0.05);
			}
			
			if (change >= .02) {
				System.out.print((int) (change / .01) + " pennies");
				change = fmod(change, 0.01);
			}
			else if (change >= .01) {
				System.out.print((int) (change / .01) + " penny");
				change = fmod(change, 0.01);
			}

		}
		// System.out.println(change);

		kb.close();
	}

	public static double fmod(double a, double b) {
		double mod = a;
		while (mod >= b) {
			mod = mod - b;
		}
		return Math.round(mod * 100.0) / 100.0;
	}

}
