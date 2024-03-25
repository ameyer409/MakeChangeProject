package MakeChange;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChangePlus {
	private BigDecimal total;
	private BigDecimal tendered;
	private BigDecimal[] values = { new BigDecimal(20), new BigDecimal(10), new BigDecimal(5), new BigDecimal(1),
			new BigDecimal(.25), new BigDecimal(".1"), new BigDecimal(".05"), new BigDecimal(".01") };
	private int[] amounts = new int[8];

	public static void main(String[] args) {
		MakeChangePlus mcp = new MakeChangePlus();
		mcp.launch();
	}

	public void launch() {
		Scanner sc = new Scanner(System.in);
		getTotal(sc);
		getTendered(sc);
		if (total.compareTo(tendered) == 1) {
			System.out.println(tendered + " is not enough money to pay for " + total);
			getTendered(sc);
		} else if (total.compareTo(tendered) == 0) {
			System.out.println("Exact Change!");
		} else {
			makeChange(tendered.subtract(total), 0);
		}
		printResults();
//		System.out.println("total: " + total);
//		System.out.println("tendered: " + tendered);

	}
	
	public void printResults() {
		System.out.println("Your change is: ");
		for (int i = 0; i < amounts.length; i++) {
//			System.out.println(values[i].toString());
			if (amounts[i] > 1) {
				switch (values[i].toString()) {
				case "20":
					System.out.println(amounts[i] + " twenty dollar bills");
					break;
				case "10":
					System.out.println(amounts[i] + " ten dollar bills");
					break;
				case "5":
					System.out.println(amounts[i] + " five dollar bills");
					break;
				case "1":
					System.out.println(amounts[i] + " one dollar bills");
					break;
				case "0.25":
					System.out.println(amounts[i] + " quarters");
					break;
				case "0.1":
					System.out.println(amounts[i] + " dimes");
					break;
				case "0.05":
					System.out.println(amounts[i] + " nickels");
					break;
				case "0.01":
					System.out.println(amounts[i] + " pennies");
					break;
				}
			}
			else if (amounts[i] == 1) {
				switch (values[i].toString()) {
				case "20":
					System.out.println(amounts[i] + " twenty dollar bill");
					break;
				case "10":
					System.out.println(amounts[i] + " ten dollar bill");
					break;
				case "5":
					System.out.println(amounts[i] + " five dollar bill");
					break;
				case "1":
					System.out.println(amounts[i] + " one dollar bill");
					break;
				case "0.25":
					System.out.println(amounts[i] + " quarter");
					break;
				case "0.1":
					System.out.println(amounts[i] + " dime");
					break;
				case "0.05":
					System.out.println(amounts[i] + " nickel");
					break;
				case "0.01":
					System.out.println(amounts[i] + " penny");
					break;
				}
			}
		}
	}

	public void makeChange(BigDecimal difference, int index) {
		if (index < values.length) {
			if (values[index].compareTo(difference) == 1) {
				makeChange(difference, index + 1);
			} else {
				BigDecimal dar[] = difference.divideAndRemainder(values[index]);
				amounts[index] = dar[0].intValue();
				difference = dar[1];
				makeChange(difference, index + 1);
//				amounts[index] = (difference.divide(values[index])).intValue();
			}
		}
	}

	public void getTotal(Scanner sc) {
		boolean totalRetrieved = false;
		while (!totalRetrieved) {
			try {
				System.out.print("What is the total amount due: \n");
				total = sc.nextBigDecimal();
				totalRetrieved = true;
				clearBuffer(sc);
			} catch (InputMismatchException e) {
				clearBuffer(sc);
				e.printStackTrace();
				System.out.println("Bad input. Please enter a valid numeric value.");
			}
		}
	}

	public void getTendered(Scanner sc) {
		boolean totalRetrieved = false;
		while (!totalRetrieved) {
			try {
				System.out.print("Please input amount of money tendered: \n");
				tendered = sc.nextBigDecimal();
				totalRetrieved = true;
				clearBuffer(sc);
			} catch (InputMismatchException e) {
				clearBuffer(sc);
				e.printStackTrace();
				System.out.println("Bad input. Please enter a valid numeric value.");
			}
		}
	}

	public void clearBuffer(Scanner sc) {
		sc.nextLine();
	}
}
