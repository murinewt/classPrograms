package exercise;

public class Question {
	
	public static void main(String [] args){
		me(null);
	}
	public static void me(String s){
		System.out.println("String");
	}
	public static void me(Object o){
		System.out.println("Object");
	}

}
