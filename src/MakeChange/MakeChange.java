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
		double amount = 0.0, tendered = 0.0;
		
		//Part 1: The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you wish to purchase: ");
		amount = kb.nextDouble();

		//Part 2: The user is then prompted asking how much 
		//		  money was tendered by the customer.
		System.out.print("What is the price of the item you wish to purchase: ");
		tendered = kb.nextDouble();
		
		//Part 3: Display an appropriate message if the customer 
		//	  	  provided too little money or the exact amount.
		if (amount > tendered) {
			System.out.println("That is not enough money for what you wish to purchase");
		}
		System.out.println(amount);
		System.out.println(tendered);
		
		kb.close();
	}

}
