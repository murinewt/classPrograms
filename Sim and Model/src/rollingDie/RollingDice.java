package rollingDie;

public class RollingDice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []count = new int[7];
		for(int x=0;x<7;x++){
			count[x]=0;
		}
		while(count[0]<1000){
			double x = Math.random();
			if(x>=0.0&&x<(1.0/6)){
				//System.out.println("face 1");
				count[1]++;
			}else if(x>=(1.0/6)&&x<(2.0/6)){
				//System.out.println("face 2");
				count[2]++;
			}else if(x>=(2.0/6)&&x<(0.5)){
				//System.out.println("face 3");
				count[3]++;
			}else if(x>=(0.5)&&x<(4.0/6)){
				//System.out.println("face 4");
				count[4]++;
			}else if(x>=(4.0/6)&&x<(5.0/6)){
				//System.out.println("face 5");
				count[5]++;
			}else if(x>=(5.0/6)&&x<(1.00)){
				//System.out.println("face 6");
				count[6]++;
			}	
			count[0]++;
		}
		System.out.println("Face	Frequency	Percentage");
		for(int y=1; y<7;y++){
			System.out.printf(y+"	"+count[y]+"		%.1f",((double)(count[y])/count[0]*100));
			System.out.println("%");
		}
	}
}
