package exercise;

import java.util.Scanner;

public class Factorial {
	static int valueD=1;

	public static int factorial(int number){
		if(number<1)
			return 1;
		else if(number!=1){
			while(number!=1){
				return (number*factorial(number-1));
			}
		}
		return 1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner numReader = new Scanner(System.in);
		System.out.print("Input a number to find its factorial: ");
		String number = numReader.next();
		int newNum = Integer.parseInt(number);
		int value = factorial(newNum);
		System.out.println("factorial of "+newNum+" is: "+value);
		numReader.close();
	}
}
