package cPlusToJava;
import java.util.Scanner;

public class NumberPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner inputRead = new Scanner(System.in);
		System.out.print("Enter a number to check if its a palindrom: ");
		int numRead = inputRead.nextInt();
		int newNum = 0,sum=0,divide=0;
		int realNum=numRead;
		while(numRead>0){
			newNum=numRead%10;
			divide=numRead/10;
			sum=(sum*10)+newNum;
			numRead=divide;
		}
		//String sumString= int.ParseInteger(sum);
		System.out.print(""+sum);
		if(realNum==sum)
			System.out.print("\npalindrom");
		else
			System.out.print("\nnot Palindrom");
		inputRead.close();
	}
}
