package grade;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.Arrays;
import java.util.Comparator;

public class LectGradeTwo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JTextArea myText= new JTextArea();
		Grading my=new Grading();
		int num=0; 
		do{
			num=my.numOfStudents();
		}while(num<0||num>20);
		Grading [][] arrayGrade= new Grading[num][9];
		Grading [] arrayGrade2=new Grading[num];
		double sum=0;
		new Comparator<Grading[]>(){
			@Override
			public int compare(Grading[]a,Grading[]b){
				return a[0].compareTo(b[0]);
			}
		};
		
		for(int x=0;x<num;x++)
		{
			int y=1;
			Grading myStudent=new Grading();
			do{
			myStudent.name=myStudent.inputName();
			//arrayGrade[x][0]=myStudent.name;
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
			arrayGrade2[x] = myStudent;
			arrayGrade[x][y]=arrayGrade2[x];
			y++;
		}
		Arrays.sort(arrayGrade2);
		for(int x=0;x<num;x++){
			int y=0;
			arrayGrade[x][y]=arrayGrade2[x];
			y++;
		}
			
		myText.setText("\tNAME\tCAT_01(10)\tCAT_02(10)\tCAT_03(10)\tEXAM(70)\tTOTAL\tGRADE\n");
		myText.append("==============================================================================================\n");
		for(int y=0;y<num;y++){
			int x=1;
			myText.append((y+1)+".\t"+arrayGrade[y][x].name+"\t"+arrayGrade[y][x].cat1+"\t"+arrayGrade[y][x].cat2+"\t"+arrayGrade[y][x].cat3+"\t"
						+arrayGrade[y][x].exam+"\t"+arrayGrade[y][x].sum+"\t"+arrayGrade[y][x].grade+"\n");
			x++;
		}
		myText.append("\n\t\t\t\tEND\t\t\t");
		JOptionPane.showMessageDialog(null,myText,"MARKS",JOptionPane.PLAIN_MESSAGE);
	}

}
