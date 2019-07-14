package exercise;

import java.util.Scanner;

public class Prime{
	
	private static Scanner read;

	public static void main(String [] args){
		read = null;
		System.out.print("Enter a number to check if its prime: ");
		int num = read.nextInt();
		if(PrimeInt(num)==true)
			System.out.println("prime");
		else
			System.out.println("not prime");
		read.close();
	}
	
	static boolean PrimeInt(int number){
		boolean trueFalse = true;
		for(int x=2;x<number;x++){
			if(number%x==0)
				trueFalse=false;
		}
		return trueFalse;
		
	}
}