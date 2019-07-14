package readInput;
import java.util.Scanner;
import java.util.Random;

public class ReadInput {

	public static void main(String[] args) {
		//@SuppressWarnings("resource")
		Scanner readm = new Scanner(System.in);
		System.out.println("enter you name: ");
		String meme = readm.next();//:String;
		System.out.println("hello " +meme);
		System.out.print("Please enter a number between 0 and 10: ");
		int namem = readm.nextInt();
		int randomnum = new Random().nextInt(10);
		System.out.println("the random num is: " +randomnum);
		if(namem == randomnum)
		{
			System.out.println("you passed");
		}
		else
		{
			System.out.println("FAIL");
		}
		readm.close();
	}
}