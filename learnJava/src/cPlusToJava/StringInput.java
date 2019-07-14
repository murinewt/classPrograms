package cPlusToJava;

import java.util.Scanner;

public class StringInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner inputRead = new Scanner(System.in);
		//String name = args[0];
		System.out.print("Enter a Character: ");
		String name=inputRead.next();
		int length = name.length();
		
		char first = name.charAt(0);
		char last = name.charAt(length-1);
		System.out.println("length: "+length+"First initial:"+first+" last Initial: "+last);
		inputRead.close();
	}
}