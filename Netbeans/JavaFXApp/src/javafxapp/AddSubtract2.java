/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp;

/**
 *
 * @author user
 */import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*; 
public class AddSubtract2 extends Application
implements EventHandler <ActionEvent> 
{
public static void main(String[] args) 
{
launch(args);
}
Button btnAdd; 
Button btnSubtract;
Label lbl;
int iCounter = 0; 
@Override public void start(Stage primaryStage) 
{
// Create the Add button
btnAdd = new Button(); 
btnAdd.setText("Add");
btnAdd.setOnAction(this); 
// Create the Subtract button
btnSubtract = new Button();
btnSubtract.setText("Subtract");
btnSubtract.setOnAction(this);
// Create the Label ➝33
lbl = new Label();
lbl.setText(Integer.toString(iCounter));
// Add the buttons and label to an HBox pane
HBox pane = new HBox(10);
pane.getChildren().addAll(lbl, btnAdd, btnSubtract);
// Add the layout pane to a scene
Scene scene = new Scene(pane, 200, 75);
// Add the scene to the stage, set the title
// and show the stage
primaryStage.setScene(scene);
primaryStage.setTitle("Add/Sub");
primaryStage.show();
}
@Override public void handle(ActionEvent e) 
{
if (e.getSource()==btnAdd)
{
iCounter++;
}
else
{
if (e.getSource()==btnSubtract) 
{
iCounter--;
}
}
lbl.setText(Integer.toString(iCounter)); 
}
}