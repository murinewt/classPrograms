/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
/**
 *
 * @author user
 */
public class HelloName extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init(Graphics g) {
        // TODO start asynchronous download of heavy resources
       // g.drawLine(20,10,50,10);
	//g.drawLine(20,10,20,30);
        //g.drawLine(50,10,20,30);
	g.drawString("Hello World!",40, 50);
	g.drawString("Newton",80, 70);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
