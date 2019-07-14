package motelGuests;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Guests {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		Scanner disk = new Scanner(new File("F:\\PROGRAMS\\Java\\Guests.txt"));
		int motel[] = new int[10];
		for(int guests=0;guests<10;guests++)
		{
			motel[guests]= disk.nextInt();
		}
		disk.close();
		System.out.println("roomnumber\tguests");
		for(int x=0;x<10;x++)
		{
			System.out.println(x+"\t\t"+motel[x]);
		}
	}
}