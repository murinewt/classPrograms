package exercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EvenNumName implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = input.next();
		String name2 = input.next();
		System.out.print("Enter a digit: ");
		
		int even = input.nextInt();
		//int x=1;
		for(int x = 1; x<=even;x++){
			
			if(x%2==0){
				System.out.println(""+x);
				//x++;
			}
			//even++;
			//x++;
		}
		System.out.print("Hello " +name+" "+name2);
		input.close();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
