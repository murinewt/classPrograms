package exceptionHandling;

public class GoodNightsSleepA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Excuse me while I nap ");
		System.out.println("for just five seconds...");
		takeANap();
		System.out.println("Ah, that was refreshing.");
		}
		static void takeANap() 
		{
			try 
			{
				Thread.sleep(5000);
			} catch (InterruptedException e) 
			{
				System.out.println("Hey, who woke me up?");
			}
		}
}
