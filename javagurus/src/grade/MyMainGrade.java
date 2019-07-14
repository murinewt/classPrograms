package grade;



/**
 * 
 * @author murinewt
 *a class for using the grading
 *MyMainGrade.java
 *
 */
import javax.swing.*;
public class MyMainGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JTextArea myText= new JTextArea();
		Grading myStudent=new Grading();
		myStudent.name=myStudent.inputName();
		do{
			myStudent.cat1=myStudent.inputCat("Enter Cat 1: ");
		}
		while(myStudent.cat1 < 0 || myStudent.cat1 > 10);
		do{	
			myStudent.cat2=myStudent.inputCat("Enter Cat 2: ");
		}
		while(myStudent.cat2<0||myStudent.cat2>10);
		do{
			myStudent.cat3=myStudent.inputCat("Enter Cat 3: ");
		}
		while(myStudent.cat3<0||myStudent.cat3>10);
		do{
			myStudent.exam=myStudent.inputExam("Enter Exam: ");
			
		}
		while(myStudent.exam<0||myStudent.exam>70);
		double sum=myStudent.cat1+myStudent.cat2+myStudent.cat3+myStudent.exam;
		myStudent.grade=myStudent.computeGrade(sum);
		myText.setText("NAME\tCAT_01(10)\tCAT_02(10)\tCAT_03(10)\tEXAM(70)\tTOTAL\tGRADE\n");
		myText.append("=============================================================================\n");
		myText.append(myStudent.name+"\t"+myStudent.cat1+"\t"+myStudent.cat2+"\t"+myStudent.cat3+"\t"
						+myStudent.exam+"\t"+sum+"\t"+myStudent.grade);
		myText.append("\n\t\t\tEND\t\t\t");
		JOptionPane.showMessageDialog(null,myText,"MARKS",JOptionPane.PLAIN_MESSAGE);

		}

}
