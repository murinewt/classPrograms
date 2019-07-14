package exceptionHandling;

import java.util.Scanner;

public class InventoryA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double boxPrice = 3.25;
		Scanner readInput = new Scanner(System.in);
		java.text.NumberFormat currency = java.text.NumberFormat.getCurrencyInstance();
		System.out.print("How many boxes do we have? ");
		String numBoxes = readInput.next();
		try {
			int numBoxesIn = Integer.parseInt(numBoxes);
			System.out.print("the value is:");
			System.out.println(currency.format(numBoxesIn * boxPrice));
		} catch (NumberFormatException e) {
			System.out.println("thats not a number");
		}
		readInput.close();
	}

}
