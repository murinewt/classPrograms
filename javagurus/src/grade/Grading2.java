package grade;
/**
 * 
 * @author user
 * grade computation class
 *Grading.java
 */
import javax.swing.*;
public class Grading2 {
	//declare instance variable
	protected String name1,doThat;
	protected String name2;
	protected double cat21=5,cat22=5,cat23=5,exam2=55;
	protected char grade2;
	
	//create methods
	
	public String inputName2(){
		name2=JOptionPane.showInputDialog("Enter Name");
		return name2;
	}
	public double inputCat2(String inputCat2){
		 double cats = Double.parseDouble(JOptionPane.showInputDialog(inputCat2));
		 return cats;
	}
	public double inputExam2(String inputExam2){
		return Double.parseDouble(JOptionPane.showInputDialog(inputExam2));
	}
	public char computeGrade2(double sum2){
		if(sum2<40&&sum2>=0)
			grade2='E';
		else if(sum2<50)
			grade2='D';
		else if(sum2<60)
			grade2='C';
		else if(sum2<70)
			grade2='B';
		else if(sum2<100)
			grade2='A';
		else
			grade2='Z';
		
		return grade2;
	}
	/*public void doThis(String numOfTimes){
		int Students = Integer.parseInt(numOfTimes);
		for(int x=0;x<=Students;x++){
		 Grading myStudent = new Grading();
		}
		
	}*/
	/**
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}**/
	/*public void doThis(String numOfTimes) {
		// TODO Auto-generated method stub
		
	}*/

}
