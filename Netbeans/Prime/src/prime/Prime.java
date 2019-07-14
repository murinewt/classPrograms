package prime;
import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		Scanner numReader = new Scanner(System.in);
		System.out.print("Input a number to find if it is prime: ");
		int number = numReader.nextInt();
		if(prime(number)==true)
			System.out.println("Prime");
		else if(prime(number)==false)
			System.out.println("Not Prime");
		numReader.close();
	}
	public static boolean prime(int newNum){
		boolean trueD=true;
		for(int x=2;x<newNum;x++){
			if((newNum%x)==0){
				trueD= false;
			}
		}
                return trueD;
	}
}
