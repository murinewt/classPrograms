package exercise;

import java.util.Scanner;

public class Display {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputread = new Scanner(System.in);
		inputread.useDelimiter("\n");
		System.out.println("Enter a string:");
		String sentence = inputread.next();
		String[] word = sentence.split("[[']*[ ]*[,]*]+");
		for(int x=0; x<word.length; x++)
		{
			System.out.println(word[x]);
		}
		inputread.close();
	}

}
