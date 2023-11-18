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
		 * 
		 * NOTE: The formatting got a bit complex when trying to determine whether a 
		 * comma should print at the end of a calculation. For example, if the
		 * change % 20 == 0 is true, then I don't want to print a comma, because
		 * the change will only be in twenty dollar bills. However if it is false, then
		 * I do want to print a comma before the next part of the result. similarly,
		 * I needed to account for singular vs. plural, i.e. 2 twenty dollar bills vs.
		 * 1 twenty dollar bill. I don't currently know of a good way to handle these
		 * specific cases, so I ended up hard-coding each possibility. I know this is
		 * not ideal and I hope to learn how to better handle this type of issue
		 * in the future.
		 */
		else {
			change = tendered - amount;
			// various $20 bill cases
			if (change % 20 == 0 && change > 20) {
				System.out.print((int) (change / 20) + " twenty dollar bills ");
				change = change - ((int) (change / 20) * 20);
			}
			else if (change > 40) {
				System.out.print((int) (change / 20) + " twenty dollar bills, ");
				change = change - ((int) (change / 20) * 20);
			}
			else if (change > 20) {
				System.out.print((int) (change / 20) + " twenty dollar bill, ");
				change = change - ((int) (change / 20) * 20);
			}
			else if (change == 20) {
				System.out.print((int) (change / 20) + " twenty dollar bill ");
				change = change - ((int) (change / 20) * 20);
			}
			// various $10 bill cases
			if (change > 10) {
				System.out.print((int) (change / 10) + " ten dollar bill, ");
				change = change - ((int) (change / 10) * 10); // this could also just subtract ten, since this register
																// can only ever give back 1 ten dollar bill
			}
			else if (change == 10) {
				System.out.print((int) (change / 10) + " ten dollar bill ");
				change = change - ((int) (change / 10) * 10); // this could also just subtract ten, since this register
				// can only ever give back 1 ten dollar bill
			}
			// $5 bill cases
			if (change > 5) {
				System.out.print((int) (change / 5) + " five dollar bill, ");
				change = change - ((int) (change / 5) * 5);
			}
			else if (change == 5) {
				System.out.print((int) (change / 5) + " five dollar bill ");
				change = change - ((int) (change / 5) * 5);
			}
			// $1 bill cases
			if (change % 1 == 0 && change > 1) {
				System.out.print((int) (change / 1) + " one dollar bills ");
				change = change - ((int) change);
			}
			else if (change >= 2) {
				System.out.print((int) (change / 1) + " one dollar bills, ");
				change = change - ((int) change);
			}
			else if (change > 1) {
				System.out.print((int) (change / 1) + " one dollar bill, ");
				change = change - ((int) change);
			}
			else if (change == 1) {
				System.out.print((int) (change / 1) + " one dollar bill ");
				change = change - ((int) change);
			}
			// 25 cent cases
			if (change == .75) {
				System.out.print((int) (change / .25) + " quarters ");
				change = fmod(change, 0.25);
			}
			else if (change > .50) {
				System.out.print((int) (change / .25) + " quarters, ");
				change = fmod(change, 0.25);
			}
			else if (change == .50) {
				System.out.print((int) (change / .25) + " quarters ");
				change = fmod(change, 0.25);
			}
			else if (change > .25) {
				System.out.print((int) (change / .25) + " quarter, ");
				change = fmod(change, 0.25);
			}
			else if (change == .25) {
				System.out.print((int) (change / .25) + " quarter ");
				change = fmod(change, 0.25);
			}
			// 10 cent cases
			if (change > .20) {
				System.out.print((int) (change / .10) + " dimes, ");
				change = fmod(change, 0.1);
			}
			else if (change == .20) {
				System.out.print((int) (change / .10) + " dimes ");
				change = fmod(change, 0.1);
			}
			else if (change > .10) {
				System.out.print((int) (change / .10) + " dime, ");
				change = fmod(change, 0.1);
			}
			else if (change == .10) {
				System.out.print((int) (change / .10) + " dime ");
				change = fmod(change, 0.1);
			}
			// 5 cent cases
			if (change > .05) {
				System.out.print((int) (change / .05) + " nickel, ");
				change = fmod(change, 0.05);
			}
			if (change == .05) {
				System.out.print((int) (change / .05) + " nickel ");
				change = fmod(change, 0.05);
			}
			// 1 cent cases
			if (change >= .02) {
				System.out.print((int) (change / .01) + " pennies");
				change = fmod(change, 0.01);
			}
			else if (change >= .01) {
				System.out.print((int) (change / .01) + " penny");
				change = fmod(change, 0.01);
			}

		}

		kb.close();
	}

	/*
	 * I ran into an issue when trying calculate the changes in cents. There are many
	 * cases where subtracting two doubles doesn't give an accurate value due to the
	 * limitations of storing decimals in binary. I found the Math.round() solution 
	 * below through online searches. I'll note however that when trying to test all 
	 * of the cases from 1.00 to 0.01 cents, I used a for loop and ran each option 
	 * through this method, and it sometimes still had issues. so I acknowledge that 
	 * while this method will work for the program as currently written, it is flawed.
	 * I'm aware that BigDecimal exists and probably has a way to deal with this more
	 * cleanly, but that was something we hadn't covered and I didn't feel comfortable
	 * enough with trying to comb through the source material on it.  
	 */
	public static double fmod(double a, double b) {
		double mod = a;
		while (mod >= b) {
			mod = mod - b;
		}
		return Math.round(mod * 100.0) / 100.0;
	}

}
