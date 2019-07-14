/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

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
public class AddSubtract1 extends Application implements EventHandler <ActionEvent>{
    //int counter=0;
    
    public static void main(String[] args)
    {
        launch(args);
    }

    Button btn;
    Label lab;
    Button sub;
    int count=0;
    @Override 
    public void start(Stage primaryStage)
        {
        // Create the button
        btn = new Button();
        btn.setText("add");
        btn.setOnAction(this);
        
        sub = new Button();
        sub.setText("subtract");
        sub.setOnAction(this);
        
        lab = new Label();
        //lab.setText(" "+count);
        
        // Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setTop(btn);
        pane.setCenter(sub);
        pane.setBottom(lab);
        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 300, 250);
        // Finalize and show the stage
        primaryStage.setScene(scene);
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
    //lab.setText(Integer.toString(count));
    
    }
}