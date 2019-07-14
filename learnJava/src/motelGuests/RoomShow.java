package motelGuests;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class RoomShow {
	public static void main(String args[]) throws IOException 
	{
		Room rooms[] = new Room[10];
		Scanner diskScanner = new Scanner(new File("F:\\PROGRAMS\\Java\\roomliist.txt"));
		for (int roomNum = 0; roomNum < 10; roomNum++) 
		{
			rooms[roomNum] = new Room();
			rooms[roomNum].readRoom(diskScanner);
		}
		out.println("Room\tGuests\tRate\tSmoking?");
		for (int roomNum = 0; roomNum < 10; roomNum++) 
		{
			out.print(roomNum);
			out.print("\t");
			rooms[roomNum].writeRoom();
		}
	}
}