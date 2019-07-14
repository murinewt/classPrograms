/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class BorrowBook extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }
    String line = null;
    TextArea textBook;
    String lines="";
    //ScrollPane scroll;
    TextArea students;
    Button sendToText,refresh;
    TextArea name;
    
    @Override
    public void start(Stage primaryStage) throws IOException {//throws Exception {
        textBook = new TextArea();
        students  = new TextArea(); 
        sendToText = new Button();
        name = new TextArea();
        refresh = new Button();
        readStudents();
        readBooks();
        
        //textBook.
        //textBook.setText(line);
        sendToText.setText("add student");
        sendToText.setOnAction(e -> {
            try {
                studentsToText();
            } catch (IOException ex) {
                Logger.getLogger(BorrowBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        refresh.setText("refresh");
        refresh.setOnAction(e -> {
            try {
                start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(BorrowBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //scroll = new ScrollPane();
        BorderPane pane = new BorderPane();
        //scroll.setContent(textBook);
        pane.setLeft(textBook);
        textBook.setEditable(false);
        pane.setCenter(students);
        pane.setRight(sendToText);
        pane.setTop(name);
        pane.setBottom(refresh);
        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 800, 550);
        // Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Borrow Books App");
        //createFile();
        primaryStage.show();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void readBooks() throws IOException{
        File books = new File("E://file//books.txt");
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(books);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //line = " "+"";
                textBook.appendText(line+"\n");
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
    
    private void studentsToText() throws IOException{
        String lent;
        lent = name.getText();
        BufferedWriter bw=null;
        try{
            bw = new BufferedWriter(new FileWriter("E://file//studentLentBooks.txt",true));
           
         bw.write(lent);
            bw.newLine();
            bw.flush();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    public void readStudents()throws IOException{
        File books = new File("E://file//studentLentBooks.txt");
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(books);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((lines = bufferedReader.readLine()) != null) {
                //line = " "+"";
                students.appendText(lines+"\n");
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
    private static void createFile(String message) throws IOException
    {
        int x=1;
          File file = new File("E://file//receipt No "+x+".txt");
  
          //Create the file
          if (file.createNewFile()){
            System.out.println("File is created!");
          }else{
            System.out.println("File already exists.");
          }
           
          //Write Content
          FileWriter writer = new FileWriter(file);
          writer.write(message);
          writer.close();
    }
    
}
