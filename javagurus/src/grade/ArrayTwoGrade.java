package grade;
import java.util.Arrays;
/**
 * Newton Murithi
 * ArrayTwoGrade.java
 * this is the user class
 * program that a lecture can use to enter student details
 */
import javax.swing.*;

public class ArrayTwoGrade{
	public static void main(String[] args) {
		JTextArea myText= new JTextArea();
		Grading myStud=new Grading();
		int num=0; 
		do{
			num=myStud.numOfStudents();
		}while(num<0||num>20);
		Grading [] arrayGrade=new Grading[num];
		double [] [] catsExam = new double[num][5];
		char [] grades = new char[num];
		String [] names = new String[num];
		for(int x=0;x<num;x++)
		{
			Grading myStudent=new Grading();
			do{
			myStudent.name=myStudent.inputName();
			names[x]=myStudent.name;
			}
			while(myStudent.name.isEmpty());
			do{
				myStudent.cat1=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 1: ");
				catsExam[x][0]=myStudent.cat1;
			}
			while(myStudent.cat1 < 0 || myStudent.cat1 > 10);
			do{	
				myStudent.cat2=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 2: ");
				catsExam[x][1]=myStudent.cat2;
			}
			while(myStudent.cat2<0||myStudent.cat2>10
					);
			do{
				myStudent.cat3=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 3: ");
				catsExam[x][2]=myStudent.cat3;
			}
			while(myStudent.cat3<0||myStudent.cat3>10);
			do{
				myStudent.exam=myStudent.inputExam("Enter "+myStudent.name+"'s Exam: ");
				catsExam[x][3]=myStudent.exam;
			}
			while(myStudent.exam<0||myStudent.exam>70);
			catsExam[x][4]=catsExam[x][0]+catsExam[x][1]+catsExam[x][2]+catsExam[x][3];
			myStudent.grade=myStudent.computeGrade(catsExam[x][4]);
			grades[x]=myStudent.grade;
			myStudent.sum=myStudent.cat1+myStudent.cat2+myStudent.cat3+myStudent.exam;
			myStudent.grade=myStudent.computeGrade(myStudent.sum);
			arrayGrade[x]=myStudent;
		}
		myText.setText("UNSORTED LIST\n");
		myText.append("\tNAME\tCAT_01(10)\tCAT_02(10)\tCAT_03(10)\tEXAM(70)\tTOTAL\tGRADE\n");
		myText.append("==============================================================================================\n");
		for(int y=0;y<num;y++){
			myText.append((y+1)+".\t"+names[y]+"\t"+catsExam[y][0]+"\t"+catsExam[y][1]+"\t"+catsExam[y][2]+"\t"
						+catsExam[y][3]+"\t"+catsExam[y][4]+"\t"+grades[y]+"\n");
		}
		myText.append("\n\t\t\t\tEND\t\t\t\n\n");
		Arrays.sort(arrayGrade);
		myText.append("SORTED LIST\n");
		for(int y=0;y<num;y++){
			myText.append((y+1)+".\t"+arrayGrade[y].name+"\t"+arrayGrade[y].cat1+"\t"+arrayGrade[y].cat2+"\t"+arrayGrade[y].cat3+"\t"
						+arrayGrade[y].exam+"\t"+arrayGrade[y].sum+"\t"+arrayGrade[y].grade+"\n");
		}
		
		JOptionPane.showMessageDialog(null,myText,"MARKS",JOptionPane.PLAIN_MESSAGE);	
	}
}
