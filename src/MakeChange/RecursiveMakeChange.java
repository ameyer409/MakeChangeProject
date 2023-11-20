/*
After completing the assignment using all conditional statements, I wanted to try my
hand at using recursion to see if I could get the logic to work. Currently, the math
calculations are correct and the program will spit out the correct number of bills
needed for change. The formatting is not complete however so the print statements look
pretty disgusting.
*/

package MakeChange;

import java.util.Scanner;

public class RecursiveMakeChange {

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
		change = tendered - amount;

		if (change < 0) {
			System.out.println("That is not enough money for what you wish to purchase");
		}
		/*
		 * else if (change == 0) { System.out.println("Exact change!"); }
		 */
		else {
			System.out.println("amount: " + amount);
			System.out.println("tendered: " + tendered);
			System.out.print("change: ");
			makeChange(change, 20);
		}

		kb.close();

	}

	public static void makeChange(double remainingMoney, double billSize) {
		if (remainingMoney == 0) {
//			System.out.println("done");
			return;
		}
		else {
//			System.out.print((int) (remainingMoney / billSize) + " twenty dollar bills ");
//			System.out.println(remainingMoney + " " + billSize + " " + remainingMoney/billSize);
			printMethod(billSize, (int) (remainingMoney / billSize));
			remainingMoney = fmod(remainingMoney, billSize);
			// System.out.println(remainingMoney);
			billSize = nextBill(billSize);
			makeChange(remainingMoney, billSize);
			// change = change - ((int) (change / 20) * 20);
		}
	}

	public static double fmod(double a, double b) {
		double mod = a;
//		System.out.println("1st: " + mod);
		while (mod >= b) {
			mod = mod - b;
		}
//		System.out.println("2nd: " + mod);
		if (mod < 0.01) {
			return 0;
		}
		return Math.round(mod * 100.0) / 100.0;
	}

	public static double nextBill(double bill) {
		if (bill == 20) {
			return 10;
		}
		else if (bill == 10) {
			return 5;
		}
		else if (bill == 5) {
			return 1;
		}
		else if (bill == 1) {
			return .25;
		}
		else if (bill == .25) {
			return .1;
		}
		else if (bill == .1) {
			return .05;
		}
		else if (bill == .05) {
			return .01;
		}
		else {
			return 0;
		}
	}

	public static void printMethod(double billNum, int billQuantity) {
		if (billNum >= 1) {
			if (billQuantity > 1) {
				System.out.printf("%d %f dollar bills, ", billQuantity, billNum);
				return;
			}
			else if (billQuantity == 0) {
				return;
			}
			else {
				System.out.printf("%d %f dollar bill, ", billQuantity, billNum);
				return;
			}
		}
		else {
			if (billQuantity > 1) {
				System.out.printf("%d %f dollar bills, ", billQuantity, billNum);
				return;
			}
			else if (billQuantity == 0) {
				return;
			}
			else {
				System.out.printf("%d %f dollar bill, ", billQuantity, billNum);
				return;
			}
		}
	}

}
