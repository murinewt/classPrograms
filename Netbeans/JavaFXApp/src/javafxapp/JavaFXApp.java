/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class JavaFXApp extends Application
{
    int counter=0;
    int count=0;
public static void main(String[] args)
{
    launch(args);
}

Button btn;
Label lab;

@Override 
public void start(Stage primaryStage)
    {
    // Create the button
    btn = new Button();
    btn.setText("Click me please!");
    btn.setOnAction(e -> buttonClick());
    lab = new Label();
    lab.setText("clicked: "+counter+"  \nnot clicked: "+count);
    // Add the button to a layout pane
    BorderPane pane = new BorderPane();
    pane.setCenter(btn);
    pane.setBottom(lab);
    // Add the layout pane to a scene
    Scene scene = new Scene(pane, 300, 250);
    // Finalize and show the stage
    primaryStage.setScene(scene);
    primaryStage.setTitle("The Click Me App");
    primaryStage.show();
}
public void buttonClick()
{
    
if (btn.getText() == "Click me please!")
{
    counter++;
    btn.setText("You clicked me!");
    lab.setText("clicked: "+counter+ "  \nnot clicked: "+count);
}
else
{
    count++;
    btn.setText("Click me please!");
    lab.setText("clicked: "+counter+"  \nnot clicked: "+count);
}
}
}