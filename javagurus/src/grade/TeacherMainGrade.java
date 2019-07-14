package grade;
/**
 * Newton Murithi
 * TeacherMainGrade.java
 * this is the user class
 * program that a lecture can use to enter student details
 */
import javax.swing.*;

public class TeacherMainGrade{
	public static void main(String[] args) {
		JTextArea myText= new JTextArea();
		Grading myStudent=new Grading();
		int num=0; 
		do{
			num=myStudent.numOfStudents();
		}while(num<0||num>20);
		double [] cats1 = new double[num];
		double [] cats2 = new double[num];
		double [] cats3 = new double[num];
		double [] exams = new double[num];
		double sum=0;
		char [] grades = new char[num];
		String [] names = new String[num];
		double [] sums = new double[num];
		for(int x=0;x<num;x++)
		{
			do{
			myStudent.name=myStudent.inputName();
			names[x]=myStudent.name;
			}
			while(myStudent.name.isEmpty());
			do{
				myStudent.cat1=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 1: ");
				cats1[x]=myStudent.cat1;
			}
			while(myStudent.cat1 < 0 || myStudent.cat1 > 10);
			do{	
				myStudent.cat2=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 2: ");
				cats2[x]=myStudent.cat2;
			}
			while(myStudent.cat2<0||myStudent.cat2>10
					);
			do{
				myStudent.cat3=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 3: ");
				cats3[x]=myStudent.cat3;
			}
			while(myStudent.cat3<0||myStudent.cat3>10);
			do{
				myStudent.exam=myStudent.inputExam("Enter "+myStudent.name+"'s Exam: ");
				exams[x]=myStudent.exam;
			}
			while(myStudent.exam<0||myStudent.exam>70);
			sum=myStudent.cat1+myStudent.cat2+myStudent.cat3+myStudent.exam;
			sums[x]=sum;
			myStudent.grade=myStudent.computeGrade(sum);
			grades[x]=myStudent.grade;
		}
		
		myText.setText("\tNAME\tCAT_01(10)\tCAT_02(10)\tCAT_03(10)\tEXAM(70)\tTOTAL\tGRADE\n");
		myText.append("==============================================================================================\n");
		for(int y=0;y<num;y++){
			myText.append((y+1)+".\t"+names[y]+"\t"+cats1[y]+"\t"+cats2[y]+"\t"+cats3[y]+"\t"
						+exams[y]+"\t"+sums[y]+"\t"+grades[y]+"\n");
		}
		myText.append("\n\t\t\t\tEND\t\t\t");
		JOptionPane.showMessageDialog(null,myText,"MARKS",JOptionPane.PLAIN_MESSAGE);
	
	
		
	}

}
