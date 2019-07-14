package library;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import java.util.*;

public class ReturnBook extends JFrame{
/**
 *
 * @author murinewt
 */
	private static final long serialVersionUID = 1L;
    static String BookNameStr="";
    JTextField BookName = new JTextField(10);
    //JTextField StudentName = new JTextField(10);
    public JButton submit = new JButton("Next Student"); 
    JButton display = new JButton("Display Cost");
    JButton Total = new JButton("Print");
    JButton borrow = new JButton("Borrow Book");
    JTextArea output = new JTextArea(20,35);
    //JTextArea outputBook = new JTextArea(20,40);
    JTextArea outputStudent = new JTextArea(20,45);
    JTextField change = new JTextField(10);
    JLabel label = new JLabel();
    JButton delete = new JButton("Delete Record");
    //JScrollPane scroll = new JScrollPane(outputBook);
    JScrollPane scroll1 = new JScrollPane(output);
    JScrollPane scroll2 = new JScrollPane(outputStudent);
    
    String line = null;
    static String BookName1 = "";
    static String BookName2 = "";
    
    public static void main(String [] args) throws IOException{
    	//readData("Qwerty");
    	//readDate("Newton Murithi");
    	new ReturnBook();
    }

    public ReturnBook() throws IOException{
        getContentPane().setBackground(Color.PINK);
        setLayout(new FlowLayout());
        setResizable(true);
        setLocation(200,50);
        setSize(1050, 650);
        setTitle("Library: Return Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new Label("Book Name or Student Name"));
        add(BookName);
        //add(new Label("Name of Student"));
        //add(StudentName);
        add(display);
        display.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	String nameOrBook = BookName.getText();
                	readDate(nameOrBook);
                }
            });
        add(Total);
        Total.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	String nameOrBook = BookName.getText();
                	
                	try {
						//readStudents();
                		if(printOut(nameOrBook)){
                			maxBook();	
                			delUser();
                			JOptionPane.showMessageDialog(null,"Success!!","Success Message", JOptionPane.INFORMATION_MESSAGE);
                		}
                		
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            });
        add(borrow);
        borrow.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                	try {
						new BorrowBook();
						dispose();
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
        readStudents();
        output();
        //scroll.add(outputBook);
        add(scroll2);
        output.setEditable(false);
        add(submit);
        submit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //new Customer
                    label.setText("");
                    BookName.setText("");
                    //StudentName.setText("");
                    change.setText("0");
                    //outputBook.setText("");
                    //outputStudent.setText("");
                    //outputStudent.append("Student Name\tBook Returned\t\tDate\n\n");
                    try {
                    	readStudents();
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
        //add(scroll1);

    	//outputStudent.append("Student Name\tBook Borrowed\t\tDate\n\n");
        add(scroll1);
        output.setEditable(false);
        outputStudent.setEditable(false);
        setVisible(true);
    }
    public void readDate(String studentName){
    	File books = new File("E://file//studentLentBooks.txt");
    	//String sxd=readLine(books);
    	//System.out.println(sxd);
    	String [] splitLine = new String[3];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    			if(line.contains(studentName))
    				splitLine=line.split("\t");
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    	//System.out.println(splitLine[2]);
    	String date2 = splitLine[2];
    	Date newDate = new Date();
    	Date old = null;
    	try{
    		DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
    		old = (Date)df.parse(date2);
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	long diff = newDate.getTime()-old.getTime();
    	//System.out.println(diff);
    	//long diffSecond = diff/1000%60;
    	float diffMin = diff/(60*1000)%60;
    	float diffHour = diff/(60*60*1000)%24;
    	int diffDays = (int)((newDate.getTime()-old.getTime())/(1000*60*60*24));
    	/*if(diffDays>1){
    		System.out.println(diffDays+" Days");
    		System.out.println(diffHour+" Hours");
    		System.out.println(diffMin+" Minutes");
    		System.out.println(diffSecond+" Seconds");
    	}
    	else{
    		//System.out.println(newDate+","+new SimpleDateFormat("HH:mm:ss MM/dd/yyyy").format(old));
    		System.out.println(diffHour+" Hours");
    		System.out.println(diffMin+" Minutes");
    		System.out.println(diffSecond+" Seconds");
    	}*/
    	Date date= new Date();
    	output.setText(" ");
        output.append("      "+date+"\n");
        output.append("\nRates: Shs.30 per day for 5 days; \n      thereafter Shs. 2.50 per hour\n");
        output.append("\nName:"+splitLine[1]+"\n");
        output.append("      "+"Name of Book: "+splitLine[0]);
        output.append("\n      Days: "+diffDays+"\n      Hours: "+diffHour+"\n      Minutes: "+diffMin);
        if(diffDays<=5){
        	double shs=diffDays*30+diffHour*1.25+(diffMin/60)*1.25;
        	output.append("\n\nTotal Cost: Shs. "+String.format("%.2f", shs));
        }
        else{
        	double shs=5*30+(diffDays-5)*60+diffHour*2.5+diffMin/60*2.5;
        	output.append("\n\nTotal Cost: Shs. "+String.format("%.2f", shs));
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
        output.append("\t"+date+"\n");
        output.append("\tName:\n");
        output.append("\t"+"You Returned \n\n");
        output.append("      "+"Name of Book\t\t\n"); 
        
    }
    public Boolean PrintIt(String studentName) throws Exception{
    	String pri= output.getText();
    	File books = new File("E://file//studentLentBooks.txt");
    	String [] splitLine = new String[3];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    			if(line.contains(studentName))
    				splitLine=line.split("\t");
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    	
    	FileOutputStream fileOut = new FileOutputStream("E://file//"+splitLine[0]+".txt");
    	@SuppressWarnings("resource")
		PrintWriter pw = new PrintWriter(fileOut);
    	pw.println(pri);
    	return true;
    }
   /* public Boolean printOut(String studentOrBook){
    	try {
			printO(studentOrBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    }*/
    public Boolean printOut(String studentName) throws Exception{
    	//String print = " ";
    	
    	File books = new File("E://file//studentLentBooks.txt");
    	String [] splitLine = new String[3];
    	String [] splitLine1 = new String[2];
    	Scanner in = null;
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    			if(line.contains(studentName)){
    				splitLine=line.split("\t");
    				splitLine1=line.split("#");
    			}
    		}
    		//System.out.println(splitLine[1]+" print out");
    		//System.out.println(splitLine1[0]+" print out");
			BookName1=splitLine1[0];
			BookName2=splitLine[1];
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    	
    	String date2 = splitLine[2];
    	Date newDate = new Date();
    	Date old = null;
    	try{
    		DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
    		old = (Date)df.parse(date2);
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	long diff = newDate.getTime()-old.getTime();
    	//System.out.println(diff);
    	//long diffSecond = diff/1000%60;
    	float diffMin = diff/(60*1000)%60;
    	float diffHour = diff/(60*60*1000)%24;
    	int diffDays = (int)((newDate.getTime()-old.getTime())/(1000*60*60*24));
    	
    	Date date= new Date();
    	//output.setText(" ");
    	//print.
        String shss=" ";
        if(diffDays<=5){
        	double shs=diffDays*30+diffHour*1.25+(diffMin/60)*1.25;
        	 shss= ("\n\nTotal Cost: Shs. "+String.format("%.2f", shs));
        }
        else{
        	double shs=5*30+(diffDays-5)*60+diffHour*2.5+diffMin/60*2.5;
        	shss = ("\n\nTotal Cost: Shs. "+String.format("%.2f", shs));
        }
    	
            BufferedWriter bw=null;
            try{
                bw = new BufferedWriter(new FileWriter("E://file//"+splitLine[1]+".txt",true));
               
             bw.write(" "+date);
             bw.newLine();
             bw.append("Rates: Shs.30 per day for 5 days; \n      thereafter Shs. 2.50 per hour\n");
             bw.newLine();
             bw.append("\nName:"+splitLine[1]+"\n"+"      "+"Name of Book: "+splitLine[0]);
             bw.newLine();
             bw.append("\n      Days: "+diffDays+"\n      Hours: "+diffHour+"\n      Minutes: "+diffMin);
             bw.newLine();
             bw.append(shss);
                bw.flush();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            getContentPane().repaint();
		return true;
            
        
    }
    public void delUser(){
    	File books = new File("E://file//studentLentBooks.txt");
    	//String [] splitLine = new String [2];
    	Scanner in = null;
    	String user=BookName2;
    	//System.out.println(BookName1+" --- main system");
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    		
    			if(line.contains(user)){
    				//splitLine=line.split("#");
    				//line.replaceAll(line, "");
    		    	try{
    		    		BufferedReader book = new BufferedReader(new FileReader("E://file//studentLentBooks.txt"));
    		    		String line1;
    		    		StringBuffer inputBuffer = new StringBuffer();
    		    		
    		    		while((line1 = book.readLine())!=null){
    		    			inputBuffer.append(line1);
    		    			inputBuffer.append("\n");
    		    		}
    		    		String inputStr= inputBuffer.toString();
    		    		
    		    		book.close();
    		    		String inputStr1= inputStr.replace(line+"\n","");
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
    		}
    	}catch(Exception ex)
    	{
    		System.out.println(ex);
    	}
    }
    public void maxBook(){
    	File books = new File("E://file//book.txt");
    	String [] splitLine = new String [2];
    	Scanner in = null;
    	String bookName=BookName1;
    	//System.out.println(BookName1+" --- main system");
    	try{
    		in= new Scanner(books);
    		while(in.hasNext())
    		{
    			String line =in.nextLine();
    		
    			if(line.contains(bookName)){
    				splitLine=line.split("#");
    				//System.out.println(splitLine[0]);
		        	//System.out.println(splitLine[1]);
		        	//System.out.println(splitLine[2]);
		        	//System.out.println(splitLine[3]);
    				int numBook = Integer.parseInt(splitLine[1]);
    		    	int newNum=numBook+1;
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
    		    		//String inputStr1= inputStr.replace(numBook+"",newNum+"");
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
    	
    	
    	//return splitLine[1];
    }
    
}