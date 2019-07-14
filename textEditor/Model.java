package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// this class will deal with text only
/*
 * it will perform file reading, writing, searching for words, word replacement
 */
public class Model {
	
	private File file;
	private String fileContent;
	private boolean isSaved;
	private FileManager fileManager;
	
	private class FileNotSupportedException extends IOException{
		
		public FileNotSupportedException(String message){
			super(message);
			
		}
		
		
	}
	
	public Model(){
		fileContent = "";
		isSaved = false;
		fileManager = new FileManager();
		file = null;
	}
	
	public boolean save(){
		if(file != null){
			isSaved = true;
			return fileManager.writeFile(file, fileContent);
			
		}
		
		return false;
		
	}
	
	public void open() throws FileNotSupportedException{
		
		fileContent = fileManager.readFile(file);	
	}
	
	public boolean isFileSaved(){
		return isSaved;
	}
	
	
	public ArrayList<Integer>  findString(String str , int findPosition){
		
		ArrayList<Integer> stringPosition = new ArrayList<Integer>();
		
		if(fileContent.equals("") || fileContent == null|| fileContent.length() <= findPosition){
			return null;
		}
		
		else{
			
			
			
			int stringPos = fileContent.indexOf(str,findPosition);
			
			int stringEnd = str.length();
			
			stringPosition.add(stringPos);
			stringPosition.add(stringEnd + stringPos);
		}
		
		return stringPosition;	
	}
	
	public boolean findAndReplace(String str , String replacer , int findPosition ){
		
		ArrayList<Integer> arrayList = findString(str, findPosition);
		
		if(arrayList != null){
			
			String stri = fileContent.substring(0 , arrayList.get(1)).replace(str,replacer);
			String str3 = fileContent.substring(arrayList.get(1) );
			fileContent = stri + str3;
			save();
			
			return true;
		}
		
		return false;		
	}
	
	
	public static void main(String [] args){
		
		Model model = new Model();
		model.file = new File("D:\\My notes\\others\\yellowbook.txt");
		
		try{
			model.open();
		}
		catch(FileNotSupportedException er){
			System.out.println("File not supported");
		}
		
		System.out.println(model.fileContent);
		
		ArrayList<Integer> arrayList = model.findString("Tim", 0);
		for(int i = 0 ; i < arrayList.size() ; i ++){
			
			System.out.println(arrayList.get(i));
			
		}
		
		
		
		if(model.findAndReplace( "Newton","Michael", 0)){
			System.out.println("Newton added");
		}
		
		try{
			model.open();
		}
		catch(FileNotSupportedException er){
			System.out.println("File not supported");
		}
		
		System.out.print(model.fileContent);
		
		
		
		
		
	}
	

}
