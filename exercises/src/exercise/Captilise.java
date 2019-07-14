package exercise;

import java.util.Scanner;

public class Captilise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner inputread = new Scanner(System.in);
		inputread.useDelimiter("\n");
		System.out.println("Enter a string:");
		String sentence = inputread.next();
		String[] capt = sentence.split("[[ ]*[.]*[?]*[!]*[,]*[:]*[;]*]+");
		//System.out.print(sentence.substring(0,5).toUpperCase()+sentence.substring(1));
		for(int x=0;x<capt.length;x++)
		{
			char capletter = Character.toUpperCase(capt[x].charAt(0));
			sentence += " " +capletter + capt[x].substring(1);
		}
		sentence = sentence.trim();
		System.out.println(sentence);
		inputread.close();
	}

}
