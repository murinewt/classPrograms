package examRevision;

public class DiceRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dice1,dice2,sum;
		dice1=(int)(Math.random()*6)+1;
		dice2=(int)(Math.random()*6)+1;
		sum=dice1+dice2;
		System.out.print(sum);

	}

}
