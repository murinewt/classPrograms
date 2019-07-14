package mk;

/**
 * This program simulates a dice game
 * @author micheal
 *
 */
public class DiceGame {
	

	
	public static double getPercentage(int count , int totalCount) {
		return ((double)(count) * 100)/totalCount ;
	}
	
	public static void main(String [] args) {
		int [] counters = new int[6];
		int numberOfThrows = 1000;
		
		for(int i = 0; i < numberOfThrows; i ++) {
			double random = Math.random();
			
			if(0.0 <= random && random < (1.0/6)) {
				
				counters[0] ++;
				
			}else if((1.0/6) <= random && random < (2.0/6)){
				
				counters[1] ++;
				
			}else if((2.0/6) <= random && random < (3.0/6)){
				
				counters[2] ++;
				
			}else if((3.0/6) <= random && random < (4.0/6)){
				
				counters[3] ++;
				
			}else if((4.0/6) <= random && random < (5.0/6)){
				
				counters[4] ++;
				
			}else if((5.0/6) <= random && random < 1.0){
				
				counters[5] ++;
			}
		}
		
		System.out.println("Face\t\t\tFrequency\t\tPercentage");
		
		for(int i = 0; i < 6 ; i ++) {
			System.out.println((i+1) +"\t\t\t"+ counters[i] + "\t\t\t"+ getPercentage(counters[i], numberOfThrows) + "%");
		}
	}

}
