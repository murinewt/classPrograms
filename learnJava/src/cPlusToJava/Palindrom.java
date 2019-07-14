package cPlusToJava;
import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputread = new Scanner(System.in);
		String array="name";
		System.out.println("Enter a word to check if it is palindrome: ");
		array = inputread.next();
		int length = array.length();
		String newarray="";
		for(int i = length-1;i>=0;i--){
			newarray=newarray+array.charAt(i);
		}
		System.out.println("the reverse is:"+newarray);
		if(array.equals(newarray))
			System.out.println("the word is a Palindrom");
		else
			System.out.println("the word is not a palindrom ");
		inputread.close();
	}

}
