package GUIProg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CompanyDetails extends JFrame 
							implements ActionListener{
	
	String[] religionString={"Christian","Muslim","Hindu","Budhist","Aethist"};
	String[] departmentString={"IT","Management","GIS","Accounts"};
	String[] maritalStatusString={"Single","Married"};
	JTextField nameTxt = new JTextField(10);
	JTextField surnameTxt = new JTextField(10);
	JTextField ageTxt = new JTextField(2);
	JCheckBox male = new JCheckBox("Male");
	JCheckBox female = new JCheckBox("Female");
	JTextArea output = new JTextArea(6,30);
	JButton ok = new JButton("OK");
	JComboBox<String> religion = new JComboBox<>(religionString);
	JComboBox<String> department = new JComboBox<>(departmentString);
	JComboBox<String> maritalStatus= new JComboBox<>(maritalStatusString);
	JTextField basicSalary = new JTextField(8);

	public static void main(String[] args) {
		new CompanyDetails();

	}
	 public CompanyDetails(){
		 setLayout(new FlowLayout());
		 setSize(680, 300);
		 setTitle("Employee Details");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 add(new Label("Type your Name: "));
		 add(nameTxt);
		 add(new Label("Type your Surname: "));
		 add(surnameTxt);
		 add(new Label("  Type your Age: "));
		 add(ageTxt);
		 add(new Label(" Tick as Appropriate: "));
		 add(new Label(" Gender: "));
		 add(male);
		 add(female);
		 add(new Label(" Religion: "));
		 add(religion);
		 add(new Label(" Marital Status: "));
		 add(maritalStatus);
		 add(new Label(" Department: "));
		 add(department);
		 add(new Label(" Basic Salary: "));
		 add(basicSalary);
		 add(new Label("Submit? "));
		 add(ok);
		 ok.addActionListener(this);
		 add(output);
		 output.setEditable(false);
		 setVisible(true); 
	 }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = surnameTxt.getText();
		int age = Integer.parseInt(ageTxt.getText());
		int salary=Integer.parseInt(basicSalary.getText());
		
		if(!male.isSelected()&&!female.isSelected()){
			String messo="please you haven't selected your gender ";
			output.setText(messo);
		}
		else if(male.isSelected()&&female.isSelected()){
			String messo="please select one Gender ";
			output.setText(messo);
		}
		else if(age<=0||age>120){
			String messo="age should be between 1 and 120";
			output.setText(messo);
		}
		else{
			String statusMarital =(String)maritalStatus.getSelectedItem();
			String title;
			if(statusMarital=="Single" && male.isSelected()){
				title = "Master ";
			}
			else if(statusMarital=="Single" && !male.isSelected()){
				title = "Miss ";
			}
			else if(statusMarital=="Married" && male.isSelected()){
				title = "Mr. ";
			}
			else if(statusMarital=="Married" && !male.isSelected()){
				title = "Mrs. ";
			}
			else{
				title = "please you haven't selected your gender ";
			}
			
			String religionName=(String) religion.getSelectedItem();
			String nameString;
			
			if("Aethist" == religionName){
				nameString = " you are an "+religionName;
			}
			else{
				nameString = " you are a "+religionName;
			}
			String departmentname=(String) department.getSelectedItem();
			String message="Hello "+title+name+" you are of "+departmentname+" department. \n"
					+ "And "+nameString+"\nYou earn a basic salary of "+salary;
			output.setText(message);
		}
	}
}
