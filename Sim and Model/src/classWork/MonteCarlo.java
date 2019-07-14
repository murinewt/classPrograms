package classWork;

//import java.util.Scanner;

public class MonteCarlo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.print("Enter the value of n: ");
		Scanner read  = new Scanner(System.in);
		int n = read.nextInt();*/
		int n = 80;
		double X = 0;
		for(int i=0;i<n;i++){
			double u = Math.random();
			 X += Math.sin(u * Math.PI);
			
		}
		double ans = Math.PI * X/n;
		//read.close();
		System.out.printf("%.4f",ans);

	}

}
