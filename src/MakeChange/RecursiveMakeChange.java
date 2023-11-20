/*
After completing the assignment using all conditional statements, I wanted to try my
hand at using recursion to see if I could get the logic to work. Currently, the math
calculations are correct and the program will spit out the correct number of bills
needed for change. The formatting is not complete however so the print statements look
pretty disgusting.
*/

package MakeChange;

import java.util.Scanner;
import java.text.*;

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
		else if (change == 0) {
			System.out.println("Exact change!");
		}
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
			return;
		}
		else {
			printMethod(billSize, (int) (remainingMoney / billSize), fmod(remainingMoney, billSize));
			remainingMoney = fmod(remainingMoney, billSize);
			billSize = nextBill(billSize);
			makeChange(remainingMoney, billSize);
		}
	}

	public static double fmod(double a, double b) {
		double mod = Math.round(a * 100.0) / 100.0;
		while (mod >= b) {
			mod = mod - b;
		}
		mod = Math.round(mod * 100.0) / 100.0;
		return mod;
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

	public static void printMethod(double billNum, int billQuantity, double mod) {
		DecimalFormat df = new DecimalFormat("#.##");
		if (billNum >= 1) {
			if (billQuantity == 0) {
				return;
			}
			else if (billQuantity > 1) {
				if (mod == 0) {
					System.out.printf("%d %d dollar bills ", billQuantity, (int) billNum);
					return;
				}
				else {
					System.out.printf("%d %d dollar bills, ", billQuantity, (int) billNum);
					return;
				}
			}
			else {
				if (mod == 0) {
					System.out.printf("%d %d dollar bill ", billQuantity, (int) billNum);
					return;
				}
				else {
					System.out.printf("%d %d dollar bill, ", billQuantity, (int) billNum);
				}
			}
		}
		else {
			if (billQuantity == 0) {
				return;
			}
			else if (billQuantity > 1) {
				if (mod == 0) {
					System.out.printf("%d " + df.format(billNum) + " coins", billQuantity, billNum);
					return;
				}
				else {
					System.out.printf("%d " + df.format(billNum) + " coins, ", billQuantity, billNum);
					return;
				}
			}
			else {
				if (mod == 0) {
					System.out.printf("%d " + df.format(billNum) + " coin", billQuantity, billNum);
					return;
				}
				else {
					System.out.printf("%d " + df.format(billNum) + " coin, ", billQuantity, billNum);
					return;
				}
			}
		}
	}

}
