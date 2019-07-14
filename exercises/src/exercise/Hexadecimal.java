package exercise;

import java.util.Scanner;

public class Hexadecimal {

	static int hexValue(char hexChar)
	{
		switch (hexChar){
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'A':
		case 'a':
			return 10;
		case 'B':
		case 'b':	
			return 11;
		case 'C':
		case 'c':
			return 12;
		case 'D':
		case 'd':
			return 13;
		case 'E':
		case 'e':
			return 14;
		case 'F':
		case 'f':
			return 15;
		default:
			return -1;
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner hexReader = new Scanner(System.in);
		System.out.println("Input a Hexadecimal number to print out the base 10 number:");
		String hexNum = hexReader.next();
		int value = 0;
		for(int x=0; x<hexNum.length();x++)
		{
			value = value*16+hexValue(hexNum.charAt(x));
		}
		System.out.println(value);
		hexReader.close();
	}

	
}
