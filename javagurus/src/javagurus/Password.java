package javagurus;

public class Password
{
   public static void main (String[] args)
   {
	 
      String password = "";
 
      for (int i=0; i<=3; i++)
       {
    	  password += (char) (Math.random() * 26 + 'a');
    	  password += (int) (Math.random() * 10);
       }
 
      System.out.println ("The password is: " + password);
   }
}