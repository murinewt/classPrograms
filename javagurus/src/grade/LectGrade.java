package grade;

import javax.swing.JOptionPane;
import java.util.Arrays;
import javax.swing.JTextArea;

public class LectGrade {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextArea myText= new JTextArea();
		Grading my=new Grading();
		int num=0; 
		do{
			num=my.numOfStudents();
		}while(num<0||num>20);
		Grading [] arrayGrade= new Grading[num];
		double sum=0;
		for(int x=0;x<num;x++)
		{
			Grading myStudent=new Grading();
			do{
			myStudent.name=myStudent.inputName();
			}
			while(myStudent.name.isEmpty());
			do{
				myStudent.cat1=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 1: ");
			}
			while(myStudent.cat1 < 0 && myStudent.cat1 > 10);
			do{	
				myStudent.cat2=myStudent.inputCat("Enter "+myStudent.name+"'s Cat 2: ");
			}
			while(myStudent.cat2<0||myStudent.cat2>10
					);
			do{
				myStudent.cat3=myStudent.inputCat("Enter"+myStudent.name+"'s Cat 3: ");
			}
			while(myStudent.cat3<0||myStudent.cat3>10);
			do{
				myStudent.exam=myStudent.inputExam("Enter "+myStudent.name+"'s Exam: ");
			}
			while(myStudent.exam<0||myStudent.exam>70);
			sum=myStudent.cat1+myStudent.cat2+myStudent.cat3+myStudent.exam;
			myStudent.grade=myStudent.computeGrade(sum);
			myStudent.sum = sum ;
			arrayGrade[x] = myStudent;
			
		}
		myText.setText("UNSORTED LIST\n");
		myText.append("\tNAME\tCAT_01(10)\tCAT_02(10)\tCAT_03(10)\tEXAM(70)\tTOTAL\tGRADE\n");
		myText.append("==============================================================================================\n");
		for(int y=0;y<num;y++){
			myText.append((y+1)+".\t"+arrayGrade[y].name+"\t"+arrayGrade[y].cat1+"\t"+arrayGrade[y].cat2+"\t"+arrayGrade[y].cat3+"\t"
						+arrayGrade[y].exam+"\t"+arrayGrade[y].sum+"\t"+arrayGrade[y].grade+"\n");
		}
		myText.append("\n\t\t\t\tEND\t\t\t\n\n\n");
		Arrays.sort(arrayGrade);
		myText.append("SORTED LIST\n");
		for(int y=0;y<num;y++){
			myText.append((y+1)+".\t"+arrayGrade[y].name+"\t"+arrayGrade[y].cat1+"\t"+arrayGrade[y].cat2+"\t"+arrayGrade[y].cat3+"\t"
						+arrayGrade[y].exam+"\t"+arrayGrade[y].sum+"\t"+arrayGrade[y].grade+"\n");
		}
		
		
		JOptionPane.showMessageDialog(null,myText,"MARKS",JOptionPane.PLAIN_MESSAGE);
	}

}
