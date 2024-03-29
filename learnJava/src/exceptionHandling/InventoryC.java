package exceptionHandling;

import java.util.Scanner;
import java.text.NumberFormat;

public class InventoryC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double boxPrice = 3.25;
		Scanner keyboard = new Scanner(System.in);
		NumberFormat currency =
		NumberFormat.getCurrencyInstance();
		System.out.print("How many boxes do we have? ");
		String numBoxesIn = keyboard.next();
		try {
		int numBoxes = Integer.parseInt(numBoxesIn);
		if (numBoxes < 0) {
			keyboard.close();
			throw new OutOfRangeException();
		}
		if (numBoxes > 1000) {
			keyboard.close();
			throw new NumberTooLargeException();
		}
		System.out.print("The value is ");
		System.out.println(
		currency.format(numBoxes * boxPrice));
		}
		catch (NumberFormatException e) {
			System.out.println("That�s not a number.");
		}
		catch (OutOfRangeException e) {
			System.out.print(numBoxesIn);
			System.out.println("? That�s impossible!");
		}
		catch (Exception e) {
			System.out.print("Something went wrong, ");
			System.out.print("but I�m clueless about what ");
			System.out.println("it actually was.");
		}
		System.out.println("That�s that.");
		keyboard.close();
	}
}