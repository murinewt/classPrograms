/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class JavaFX extends Application
{
public static void main(String[] args)
{
launch(args);
}
Button btn;
@Override public void start(Stage primaryStage)
{
// Create the button
btn = new Button();
btn.setText("Click me please!");
btn.setOnAction( new EventHandler<ActionEvent>(){
    
    @Override
    public void handle(ActionEvent t) {
        buttonClick();
    }
    
});
// Add the button to a layout pane
BorderPane pane = new BorderPane();
pane.setCenter(btn);
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
btn.setText("You clicked me!");
}
else
{
btn.setText("Click me please!");
}
}
}