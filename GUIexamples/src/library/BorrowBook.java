package library;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.Date;
import java.util.*;

public class BorrowBook extends JFrame{
/**
 *
 * @author murinewt
 */
	private static final long serialVersionUID = 1L;
    static String BookNameStr="";
    JTextField BookName = new JTextField(10);
    JTextField StudentName = new JTextField(10);
    public JButton submit = new JButton("Next Student"); 
    JButton display = new JButton("Display");
    JButton Print = new JButton("Print");
    JButton Total = new JButton("Total Students");
    JButton returnB = new JButton("Return Book");
    JTextArea output = new JTextArea(20,40);
    JTextArea outputBook = new JTextArea(20,40);
    JTextArea outputStudent = new JTextArea(14,60);
    //JTextField change = new JTextField(10);
    JLabel label = new JLabel();
    JButton delete = new JButton("Delete Record");
    JScrollPane scroll = new JScrollPane(outputBook);
    JScrollPane scroll1 = new JScrollPane(output);
    JScrollPane scroll2 = new JScrollPane(outputStudent);
    
    String line = null;
    
    public static void main(String [] args) throws IOException{
    	//readData("Qwerty");
    	//bookNum("84");
    	//readDate("Gatwiri");
    	//replaceBracket();
    	//bookNum("Pride and Prejudice by Jane Austen");
    	//minBook("Pride and Prejudice by Jane Austen");
    	new BorrowBook();
    }

    public BorrowBook() throws IOException{
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setResizable(true);
        setLocation(200,50);
        setSize(1050, 650);
        setTitle("Library: Borrow Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new Label("Book Name"));
        add(BookName);
        add(new Label("Name of Student"));
        add(StudentName);
        add(display);
        display.addActionListener(new ActionListener()
        	{
	        	@Override
	            public void actionPerformed(ActionEvent e) {

                	Date date= new Date();
                	String dateDate = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy").format(date);
                	//Date date1= date1.parse(arg0)
                    String StudentNameString="";
                    
	        		BookNameStr = bookNum(BookName.getText());
                    
                    StudentNameString = StudentName.getText();
                    
                    output.append("      "+BookNameStr+"\t"+StudentNameString+"\t"+dateDate+"\n");
	        	}
        	});
        add(Print);
        Print.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	Date date= new Date();
                	String dateDate = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy").format(date);
                	//Date date1= date1.parse(arg0)
                    String StudentNameString="";
                    if(BookName.getText().isEmpty()&&StudentName.getText().isEmpty()){
                    	
                    }
                    else{
                    try{
                    	BookNameStr = bookNum(BookName.getText());
                       
                        StudentNameString = StudentName.getText();
                        
                        //output.append("      "+BookNameStr+"\t"+StudentNameString+"\t"+dateDate+"\n");
                        BookName.setText("");
                        StudentName.setText("");
                        String lent;
                        lent = BookNameStr+"\t"+StudentNameString+"\t"+dateDate;
                        BufferedWriter bw=null;
                        try{
                            bw = new BufferedWriter(new FileWriter("E://file//studentLentBooks.txt",true));
                           
                         bw.write(lent);
                            bw.newLine();
                            bw.flush();
                            minBook(BookNameStr);
                            
                            JOptionPane.showMessageDialog(null,"Success!!","Success Message", JOptionPane.INFORMATION_MESSAGE);
                            
                        }catch(IOException ioe){
                            ioe.printStackTrace();
                        }
                        getContentPane().repaint();
                        ouputBooks();
                        output();
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    
                }}
            });
        add(returnB);
        returnB.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	try {
						new ReturnBook();
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
        add(Total);
        Total.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	try {
						readStudents();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
        add(delete);
        delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                output.setText("");
                try {
					output();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        //add(outputBook);
        ouputBooks();
        output();
        //scroll.add(outputBook);
        add(scroll);
        output.setEditable(false);
        add(submit);
        submit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //new Customer
                    label.setText("");
                    BookName.setText("");
                    StudentName.setText("");
                    //change.setText("0");
                    outputBook.setText("");
                    outputStudent.setText("");
                    outputStudent.append("Book Borrowed\t\t\tStudent Name\t\tDate\n\n");
                    try {
						ouputBooks();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    output.setText("");
                    
                    try {
						output();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    add(label);
                }
            }
        );    
        add(scroll1);
        output.setEditable(false);
        outputBook.setEditable(false);
        outputStudent.setEditable(false);
    	outputStudent.append("Student Name\tBook Borrowed\t\tDate\n\n");
        add(scroll2);
        output.setEditable(false);
        
        setVisible(true);
    }
    public static String bookNum(String number){
    	File books = new File("E://file//book.txt");
    	String [] splitLine = new String[3];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		try{
    			int num = Integer.parseInt(number);
    			while(in.hasNext())
        		{
        			String line =in.nextLine();
        			splitLine=line.split(".@");
        			if(splitLine[0].contains(num+"")){
        				in.close();
        				return splitLine[1];
        			}
        			
        		}
    		}catch(Exception ex)
        	{
        		System.out.println(ex);
        	}
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    			if(line.contains(number))
    				splitLine=line.split(".@");
    			
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    	//System.out.println(splitLine[1]);
    	return splitLine[1];
    }
    public static void minBook(String bookName){
    	File books = new File("E://file//book.txt");
    	String [] splitLine = new String[2];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    		
    			if(line.contains(bookName)){
    				splitLine=line.split("#");
    				int numBook = Integer.parseInt(splitLine[1]);
    		    	int newNum=numBook-1;
    		    	System.out.println(splitLine[0]);
    		    	//line.replaceAll(numBook+"", newNum+"");
    		    	try{
    		    		BufferedReader book = new BufferedReader(new FileReader("E://file//book.txt"));
    		    		String line1;
    		    		StringBuffer inputBuffer = new StringBuffer();
    		    		
    		    		while((line1 = book.readLine())!=null){
    		    			inputBuffer.append(line1);
    		    			inputBuffer.append("\n");
    		    		}
    		    		String inputStr= inputBuffer.toString();
    		    		
    		    		book.close();
    		    		String inputStr1= inputStr.replace(splitLine[0]+"#"+numBook+"",splitLine[0]+"#"+newNum+"");
    		    		//String getDate = inputStr.trim();
    		    		//System.out.println(inputStr);
    		    		//System.out.println(inputStr1);
    		    		FileOutputStream fileOut = new FileOutputStream("E://file//book.txt");
    		    		fileOut.write(inputStr1.getBytes());
    		    		fileOut.close();
    		    	}catch(Exception e){
    		    		System.out.println(e);
    		    	}
    			}
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    	//System.out.println(splitLine[0]);
    	
    	
    	//return splitLine[1];
    }
    /*public static void replaceBracket(){
    	try{
    		BufferedReader book = new BufferedReader(new FileReader("E://file//booksy.txt"));
    		String line;
    		StringBuffer inputBuffer = new StringBuffer();
    		
    		while((line = book.readLine())!=null){
    			inputBuffer.append(line);
    			inputBuffer.append('\n');
    		}
    		String inputStr= inputBuffer.toString();
    		
    		book.close();
    		String inputStr1= inputStr.replace(')', '\n');
    		//String getDate = inputStr.trim();
    		System.out.println(inputStr);
    		System.out.println(inputStr1);
    		FileOutputStream fileOut = new FileOutputStream("E://file//booksy1.txt");
    		fileOut.write(inputStr1.getBytes());
    		fileOut.close();
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	/*File books = new File("E://file//book.txt");
    	//String [] splitLine = new String[3];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    			if(line.contains("(")){
    				line.replace('(', '*');
    			System.out.println("Good");}
    				//splitLine=line.split("#");
    			if(line.contains(")")){
    				line.replace(')', ' ');
    			System.out.println("Gooder");}
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}*/
    	/*try{
    		BufferedReader book = new BufferedReader(new FileReader("E://file//books - Copy.txt"));
    		String line;
    		StringBuffer inputBuffer = new StringBuffer();
    		String inputStr="";
    		while((line = book.readLine())!=null){
    			inputBuffer.append(line);
    			inputBuffer.append('\n');
    		}
    		
    			inputStr = inputBuffer.toString();
    		
    		//book.close();
    		//String inputStr1= inputStr.replace(')', '\n');
    		inputStr = inputStr.replace('(', '*');
    		//String getDate = inputStr.trim();
    		
    		
            //}
    		System.out.println(inputStr);
    		BufferedWriter bw=new BufferedWriter(new FileWriter("E://file//books - Copy.txt",true));
            
            bw.write(inputStr);
               bw.newLine();
               bw.flush();
               bw.close();
    		//System.out.println(inputStr1);
    		//FileOutputStream fileOut = new FileOutputStream("E://file//book.txt");
    		//fileOut.write(inputStr.getBytes());
    		//fileOut.close();
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	//System.out.println(splitLine[1]);
    	//return splitLine[1];/
    }*/
    public static void readData(String replaceWith){
    	//File books = new File("E://file//studentLentBooks.txt");
    	//String sxd=readLine(books);
    	//System.out.println(sxd);
    	try{
    		BufferedReader book = new BufferedReader(new FileReader("E://file//studentLentBooks.txt"));
    		String line;
    		StringBuffer inputBuffer = new StringBuffer();
    		
    		while((line = book.readLine())!=null){
    			inputBuffer.append(line);
    			inputBuffer.append('\n');
    		}
    		String inputStr= inputBuffer.toString();
    		
    		book.close();
    		String inputStr1= inputStr.replace(replaceWith, "Newton");
    		//String getDate = inputStr.trim();
    		//System.out.println(inputStr);
    		//System.out.println(inputStr1);
    		FileOutputStream fileOut = new FileOutputStream("E://file//studentLentBooks.txt");
    		fileOut.write(inputStr1.getBytes());
    		fileOut.close();
    	}catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    public void readStudents()throws IOException{
        String lines ="";
    	File books = new File("E://file//studentLentBooks.txt");

    	outputStudent.setText("");
    	outputStudent.append("Book Borrowed\t\t\tStudent Name\t\tDate\n\n");
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(books);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((lines = bufferedReader.readLine()) != null) {
                //line = " "+"";
                outputStudent.append(lines+"\n");
                //System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                books + "'");                
        }
    }
    
    public void output() throws IOException{
        Date date= new Date();
        output.setText("");
        output.append("\t"+date+"\n");
        output.append("\t"+"You Ordered: \n\n");
        output.append("      "+"Book Name\t\t\t\tStudent Name\t\tDate\n"); 
        
    }
    public void ouputBooks() throws IOException{
        output.setText("");
        outputBook.append("Books  Offered  At The Library\nName Of The Book\n");
        File books = new File("E://file//book.txt");
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(books);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	outputBook.append(line+"\n");
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                books + "'");                
        }
    }
}