package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
//import java.io.Writer;
import java.util.Scanner;

//import

public class FileManager {
	
	private PrintWriter writer;
	private FileReader reader;
	
	public FileManager(){
		
		writer = null;
		reader = null;
		
	}
	
	public String readFile(File fileName){
		
		String str = "";
		Scanner scanner = null;
		
		try{
			reader = new FileReader(fileName);
			scanner = new Scanner(reader);
			
			while(scanner.hasNext()){
				str += scanner.next();
				str += " ";
			}
			
		}catch(FileNotFoundException er){
			
			
		}finally{
			scanner.close();
		}
		
		return str;
		
	}
	
	public boolean writeFile(File fileName , String string){
		
		boolean checker = false; 
		
		try{
			//Writer write = new Writer(fileName);
			writer = new PrintWriter(fileName);
			
			writer.print(string);
			checker = true;
		}catch(FileNotFoundException re){
			
			checker = false;
		}
		finally{
			writer.flush();
			writer.close();
		}
		return checker;
		
	}
	

}
