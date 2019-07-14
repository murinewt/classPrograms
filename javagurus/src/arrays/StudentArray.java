package arrays;

public class StudentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] students;
		students = new int[7];
		System.out.println("Array Length= "+students.length);
		
		for(int i=0;i<students.length;i++){
			students[i]=2*i;
		}
		System.out.println("Values Stored in an Array: ");
		for(int i=0;i<students.length;i++)
			System.out.println(students[i]);
	}

}
