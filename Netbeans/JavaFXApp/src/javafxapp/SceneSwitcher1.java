/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

/**
 *
 * @author user
 */

import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
/**
 *
 * @author user
 */
public class SceneSwitcher1 extends Application implements EventHandler <ActionEvent>{
    //int counter=0;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    Scene scene,scene2;

    Button btn;
    Label lab;
    Button sub;
    int count=0;
    Button to2; 
    
    //scene 2
    int count2 =0;
    int counter=0;
    Button btn2;
    Label lab2;
    Button to1;
    
    Stage stage; 
    
    @Override 
    public void start(Stage primaryStage)
    {
        stage = primaryStage; 
        //scene 1
        // Create the button
        btn = new Button();
        btn.setText("add");
        btn.setOnAction(this);
        sub = new Button();
        sub.setText("subtract");
        sub.setOnAction(this);
        lab = new Label();
        to2 = new Button();
        to2.setText("switch!");
        to2.setOnAction(this);
        //lab.setText(" "+count);
        // Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setTop(btn);
        pane.setCenter(sub);
        pane.setBottom(lab);
        pane.setRight(to2);
        scene = new Scene(pane, 300, 250);
        
        
        //scene 2
        btn2 = new Button();
        btn2.setText("Click me please!");
        btn2.setOnAction(e -> buttonClick());
        lab2 = new Label();
        lab2.setText("clicked: "+counter+"  \nnot clicked: "+count);
        // Add the button to a layout pane
        to1 = new Button();
        to1.setText("switch!");
        to1.setOnAction(e -> switchScene2());
        BorderPane pane2 = new BorderPane();
        pane2.setCenter(btn2);
        pane2.setBottom(lab2);
        pane2.setRight(to1);
        // Add the layout pane to a scene
        scene2 = new Scene(pane2, 300, 250);
        
        
        // Add the layout pane to a scene
       
        // Finalize and show the stage
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Add Subtract");
        primaryStage.show();
    }
    @Override 
    public void handle(ActionEvent e) 
    {
        //lab.setText(Integer.toString(count));
    if (e.getSource()==btn) 
    {
        count++;
        lab.setText(""+count);
    }
    else if (e.getSource()==sub)
    {
            count--;
            lab.setText(""+count);
    }
    else if (e.getSource()==to2){
        switchScene();
    }
    //lab.setText(Integer.toString(count));
    
    }
    
    public void switchScene2(){
        stage.setScene(scene);
    }
    public void switchScene(){
        stage.setScene(scene2);
    }
    
    public void buttonClick()
        {

        if (btn2.getText() == "Click me please!")
        {
            counter++;
            btn2.setText("You clicked me!");
            lab2.setText("clicked: "+counter+ "  \nnot clicked: "+count2);
        }
        else
        {
            count2++;
            btn2.setText("Click me please!");
            lab2.setText("clicked: "+counter+"  \nnot clicked: "+count2);
        }
    }
}
