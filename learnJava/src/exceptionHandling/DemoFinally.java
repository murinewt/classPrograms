package exceptionHandling;

public class DemoFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			doSomething();
			} catch (Exception e) {
			System.out.println("Exception caught in main.");
		}
	}
	static void doSomething() {
		try {
			System.out.println(0 / 0);
		} catch (Exception e) {
			System.out.println("Exception caught in doSomething.");
			System.out.println(0 / 0);
		} finally {
			System.out.println("I’ll get printed.");
		}
		System.out.println("I won’t get printed.");
		}

}
