package rollingDie;

public class Roll {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DiceRoll roll1 = new DiceRoll();
		DiceRoll roll2 = new DiceRoll();
		DiceRoll roll3 = new DiceRoll();
		System.out.println("floor = "+roll1.roll1()+"\nrandom = "+roll1.roll() );
		
		for(int a=0;a<10;a++)
			System.out.println(roll1.roll()+" "+roll2.roll()+" "+roll3.roll());
	}

}
