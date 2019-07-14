package helloworld;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello world!");
		
		int [] a={1,2,3,4,5};
		for(int i=1;i<5;i++){
			a[i]=a[i]+a[i-1];
		}
		System.out.println(a[4]);
	}
}
