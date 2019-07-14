package classWork;

public class MonteCarlo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num_of_times = 100000;
		double answers = 0;
		for(int q=0;q<num_of_times;q++){
			answers += 3 + Math.pow((Math.random()*6), 1);
		}
		double Ans = 6*answers/num_of_times;
		System.out.printf("%.4f",Ans);
		
		int n = 80;
		double X = 0;
		for(int i=0;i<n;i++){
			double u = Math.random();
			 X += Math.sin(u * Math.PI);
			
		}
		double ans = Math.PI * X/n;
		//read.close();
		System.out.printf("\n%.4f",ans);
	}

}
