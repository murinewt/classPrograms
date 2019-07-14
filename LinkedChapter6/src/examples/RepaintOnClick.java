package examples;

import java.awt.Component;
import java.awt.event.*;
/**
* An object of type RepaintOnClick is a MouseListener that
* will respond to a mousePressed event by calling the repaint()
* method of the source of the event. That is, a RepaintOnClick
* object can be added as a mouse listener to any Component;
* when the user clicks that component, the component will be
* repainted.
*/
public class RepaintOnClick implements MouseListener {
	public void mousePressed(MouseEvent evt) {
		Component source = (Component)evt.getSource();
		source.repaint(); // Call repaint() on the Component that was clicked.
	}
	public void mouseClicked(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
	public void mouseEntered(MouseEvent evt) { }
	public void mouseExited(MouseEvent evt) { }
}