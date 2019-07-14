package filecreate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DoPayroll {

	public static void main(String[] args)
			throws IOException {
	Scanner diskScanner = new Scanner(new File ("F:\\Java\\helloworld\\src\\filecreate\\java.txt"));
	for (int x=0;x<3;x++)
	{
		payOneEmployee(diskScanner);
	}
	System.out.println();
	FullTimeEmployee ftEmployee = new FullTimeEmployee();
	ftEmployee.setName("Barry Burd");
	ftEmployee.setJobTitle("CEO");
	ftEmployee.setWeeklySalary(5000.00);
	ftEmployee.setBenefitDeduction(500.00);
	ftEmployee.cutCheck(ftEmployee.findPaymentAmount());
	System.out.println();
	PartTimeEmployee ptEmployee = new PartTimeEmployee();
	ptEmployee.setName("Steve Surace");
	ptEmployee.setJobTitle("Driver");
	ptEmployee.setHourlyRate(7.53);
	ptEmployee.cutCheck(ptEmployee.findPaymentAmount(10));
	System.out.println();
	PartTimeEmployee pt1Employee = new PartTimeEmployee();
	pt1Employee.setName("Chris Apelian");
	pt1Employee.setJobTitle("Computer Book Author");
	pt1Employee.setHourlyRate(7.53);
	pt1Employee.cutCheck(ptEmployee.findPaymentAmount(50));
	System.out.println();
	PartTimeWithOver ptoEmployee = new PartTimeWithOver();
	ptoEmployee.setName("Steve Surace");
	ptoEmployee.setJobTitle("Driver");
	ptoEmployee.setHourlyRate(7.53);
	ptoEmployee.cutCheck
	(ptoEmployee.findPaymentAmount(50));
	}
	static void payOneEmployee(Scanner aScanner){
	Employee anEmployee = new Employee();
	anEmployee.setName(aScanner.nextLine());
	anEmployee.setJobTitle(aScanner.nextLine());
	anEmployee.cutCheck(aScanner.nextDouble());
	aScanner.nextLine();
	}
}