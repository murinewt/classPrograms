package cPlusToJava;

import java.util.Scanner;

public class Name {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputread = new Scanner(System.in);
		System.out.println("Whats your Name? ");
		String name = inputread.next();
		System.out.println("Hello "+name);
		inputread.close();

	}

}
