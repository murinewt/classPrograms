package examRevision;

import java.util.Scanner;

public class StudentMark {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Total Marks: ");
		double mark = scan.nextDouble();
		
		if(mark>=50)
			System.out.println("Pass!!");
		else
			System.out.println("Fail!!");

		scan.close();
	}
	
}
