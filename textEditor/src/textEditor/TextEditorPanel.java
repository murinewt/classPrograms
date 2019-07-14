package textEditor;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextEditorPanel extends JPanel {

	/**
	 * 
	 */
	EventHandler evtHandler;
	
	boolean write;
	TextEditor board;
	private static final long serialVersionUID = 1L;

	public JMenuBar menuBar;
    public JMenuItem play;
	 
	 public void newPanel(){
		 write = false;
	 }
	 public static void main(String[] args) {
	        JFrame window = new JFrame("Text Editor");
	        TextEditorPanel content = new TextEditorPanel();
	        window.setContentPane(content);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setLocation(120,70);
	        window.setSize(400,250);
	        window.setVisible(true);
	    }

	    //---------------------------------------------------------------------

	    public TextEditorPanel() {
	        
	        /*String text = "So, naturalists observe, a flea\n"
	            + "Has smaller fleas that on him prey;\n"
	            + "And these have smaller still to bite 'em;\n"
	            + "And so proceed ad infinitum.\n\n"
	            + "                              --Jonathan Swift";*/
	    	evtHandler = new EventHandler();
			  //panels = new TextEditorPanel();
			  //this.panels.board = this;
		    setBackground(new Color(0, 0, 139, 110));
		    
		    this.menuBar = new JMenuBar();
		    this.menuBar.setBackground(new Color(220, 220, 220, 200));
		    
		    this.menuBar.setFont(new Font("optima", 2, 12));
		    
		    JMenu file = new JMenu("File");
		    
		    JMenuItem newPad = new JMenuItem("New");
		    newPad.addActionListener(this.evtHandler);
		    JMenuItem open = new JMenuItem("Open");
		    open.addActionListener(this.evtHandler);
		    JMenuItem save = new JMenuItem("Save");
		    save.addActionListener(this.evtHandler);
		    JMenuItem saveAs = new JMenuItem("Save As");
		    //saveAs.addActionListener(this.evtHandler);
		    JMenuItem print = new JMenuItem("Print");
		    //print.addActionListener(this.evtHandler);
		    JMenuItem quit = new JMenuItem("Exit");
		    quit.addActionListener(this.evtHandler);
		    
		    file.add(newPad);
		    file.add(open);
		    file.add(save);
		    file.add(saveAs);
		    file.add(print);
		    file.add(quit);
		    
		    JMenu edit = new JMenu("edit");
		    
		    JMenuItem undo = new JMenuItem("undo");
		    //undo.addActionListener(this.evtHandler);
		    JMenuItem cut = new JMenuItem("cut");
		    //cut.addActionListener(this.evtHandler);
		    JMenuItem copy = new JMenuItem("copy");
		    //copy.addActionListener(this.evtHandler);
		    JMenuItem paste = new JMenuItem("paste");
		    //paste.addActionListener(this.evtHandler);
		    JMenuItem find = new JMenuItem("find");
		    //find.addActionListener(this.evtHandler);
		    JMenuItem findNext = new JMenuItem("find Next");
		    //findNextlevel5.addActionListener(this.evtHandler);
		    JMenuItem replace = new JMenuItem("replace");
		    //replace.addActionListener(this.evtHandler);
		    JMenuItem time = new JMenuItem("time");
		    //time.addActionListener(this.evtHandler);
		    
		    edit.add(undo);
		    edit.add(cut);
		    edit.add(copy);
		    edit.add(paste);
		    edit.add(find);
		    edit.add(findNext);
		    edit.add(replace);
		    edit.add(time);
		    
		    JMenu format = new JMenu("format");
		    
		    JMenu view = new JMenu("view");
		    
		    JMenu help = new JMenu("help");
		    JMenuItem developer = new JMenuItem("Developer");
		    //developer.addActionListener(this.evtHandler);
		    JMenuItem abt = new JMenuItem("About");
		    //abt.addActionListener(this.evtHandler);
		    
		    help.add(developer);
		    help.add(abt);
		    
		    menuBar.add(file);
		    menuBar.add(edit);
		    menuBar.add(format);
		    menuBar.add(view);
		    menuBar.add(help);
		    
		    //setLayout(null);
		    
		    this.menuBar.setBounds(0, 0, 1366, 18);
		    //this.menuBar.setMargin(new Insets(0,0,0,0));
		    add(this.menuBar);
	        JTextArea textArea = new JTextArea();
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        
	        //textArea.setText(text);
	        textArea.setFont( new Font("Serif", Font.PLAIN, 24 ));
	        textArea.setMargin( new Insets(30,30,30,30));//,7,7,7) );
	        
	        setLayout(new BorderLayout());
	        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	        add(scrollPane);//, BorderLayout.CENTER);
	        
	    }

	 
	 public void paintComponent(Graphics g)
	 {
		 
	 }
}