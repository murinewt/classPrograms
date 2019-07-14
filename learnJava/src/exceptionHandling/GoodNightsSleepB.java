package exceptionHandling;

public class GoodNightsSleepB {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.print("Excuse me while I nap ");
		System.out.println("for just five seconds...");
		try {
		takeANap();
		} catch (InterruptedException e) 
		{
			System.out.println("Hey, who woke me up?");
		}
		System.out.println("Ah, that was refreshing.");
	}
	static void takeANap() throws InterruptedException 
	{
		Thread.sleep(5000);
	}
}