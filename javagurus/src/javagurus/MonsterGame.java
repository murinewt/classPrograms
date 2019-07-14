package javagurus;
import java.util.Random;
import java.util.Scanner;

public class MonsterGame
{
   public static void main (String[] args)
   {
	  Random generator = new Random();
      int arrow, energy;
      String chance = "y";
      Scanner inputread = new Scanner(System.in);
 
      do
      {  energy = 10;
         System.out.println("The monster has "+energy+" points left.");
         System.out.print("Fire your first arrow: ");
         arrow = generator.nextInt(10);
         System.out.println(arrow);
         energy = Math.max(energy - arrow,0);
         System.out.println("The monster has " + energy +" points left.");
        
         if(energy > 0)
          {
            System.out.print("Fire your second arrow: ");
           arrow = generator.nextInt(10);
           System.out.println(arrow);
           energy = Math.max(energy - arrow,0);
           System.out.println("The monster has " + energy +" points left.");
          }
         
         if (energy > 0)
          {
            System.out.print("Fire your third arrow: ");
           arrow = generator.nextInt(10);
           System.out.println(arrow);
           energy = Math.max(energy - arrow,0);
           System.out.println("The monster has " + energy +" points left.");
          }
         if (energy > 0)
           System.out.println ("Nice try; almost there!");
         else
           System.out.println ("You won!");
 
         System.out.println();
         System.out.print ("Play chance (y/n)?: ");
         chance = inputread.next();         
      }
      while (chance.equalsIgnoreCase("y"));
      inputread.close();

   }
}