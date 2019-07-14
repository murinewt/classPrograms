package rollingDie;

public class DiceRoll {
	int face,face1;
	
	public int roll(){
		face = 1+(int)(Math.random()*6);
		return face;
	}

	public int roll1(){
		face1 = (int)(Math.floor(Math.random()*7))+1;
		return face1;
	}

}
