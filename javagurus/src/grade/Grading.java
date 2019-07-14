package grade;
/**
 * 
 * @author user
 * grade computation class
 *Grading.java
 */
import javax.swing.*;

public class Grading implements Comparable<Grading> {
	//declare instance variable
	protected String name;
	protected double cat1=5,cat2=5,cat3=5,exam=55;
	protected char grade;
	protected double sum = 0;
	
	//create methods
	
	
	public int numOfStudents(){
		int num=0;
		String out;
		String output="Enter the number of Students: ";
		do{
			out=(JOptionPane.showInputDialog(output));	
		}
		while(out.isEmpty());
		try{
		num=Integer.parseInt(out);
		}catch(NumberFormatException e){
			return -1;
		}
		return num;
	}
	
	public String inputName(){
		name=JOptionPane.showInputDialog("Enter Name");
		return name;
	}
	public double inputCat(String inputCat){
		String catInput;
		do{
		catInput =(JOptionPane.showInputDialog(inputCat));
		}
		while(catInput.isEmpty());
		try{
		 Double.parseDouble(catInput);
		}catch(NumberFormatException e){
			return -1;
		}
		return Double.parseDouble(catInput);
	}
	
	public double inputExam(String inputExam){
		String examInput;
		do{
		examInput =(JOptionPane.showInputDialog(inputExam));
		}
		while(examInput.isEmpty());
		try{
			Double.parseDouble(examInput);
		}catch(NumberFormatException e){
			return -1;
		}
		return Double.parseDouble(examInput);
	}
	public char computeGrade(double sum){
		if(sum<40&&sum>=0)
			grade='E';
		else if(sum<50)
			grade='D';
		else if(sum<60)
			grade='C';
		else if(sum<70)
			grade='B';
		else if(sum<100)
			grade='A';
		else
			grade='Z';
		
		return grade;
	}
	@Override
	public int compareTo(Grading std2) {
		if(this.sum < std2.sum)
			return 1;
		else if(this.sum > std2.sum)
			return -1;
		else
			return 0;
		
	}
}
