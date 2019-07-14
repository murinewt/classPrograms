package exceptionHandling;

import java.util.Scanner;
import java.text.NumberFormat;

public class InventoryB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double boxPrice = 3.25;
		Scanner readInput = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.print("How many boxes do we have? ");
		String numBoxes = readInput.next();
		try{
			int numBoxesIn = Integer.parseInt(numBoxes);
			if (numBoxesIn < 0){
				readInput.close();
				throw new OutOfRangeException();	
			}
			System.out.print("The value is ");
			System.out.println(currency.format(numBoxesIn * boxPrice));
			} 
			catch (NumberFormatException e){
				System.out.println("That's not a number");
			} 
			catch (OutOfRangeException e){
				System.out.print(numBoxes);
				System.out.println("? That's impossible!");
			}
		readInput.close();
	}
}