package exercise;

import java.util.Scanner;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first digit: ");
		double intOne = input.nextDouble();
		System.out.print("Enter the second digit: ");
		double intTwo = input.nextDouble();
		System.out.println("Answer is: "+intOne+intTwo);
		input.close();

	}

}
