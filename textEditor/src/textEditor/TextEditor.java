package textEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.*;

public class TextEditor extends JPanel
{
	  TextEditorPanel panels; 
	  EventHandler evtHandler;
	  
	  private static final long serialVersionUID = 1L;
	  public ImageIcon icon;
	  public String fontName = "Serif";
	  public JMenuBar menuBar;
	  public JMenuBar fontType;
	  public JMenuItem play;
	  public JTextArea textArea;
	  public JScrollPane scroller;// = new JScrollPane(textArea);
	  public boolean saved=false;
	  
	  public TextEditor()
	  {
		  evtHandler = new EventHandler();
		  panels = new TextEditorPanel();
		  this.panels.board = this;
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
	    JMenuItem ariel = new JMenuItem("Ariel");
	    JMenuItem comic = new JMenuItem("Comic Sans MS");
	    JMenuItem georgia = new JMenuItem("Georgia");
	    JMenuItem lucida = new JMenuItem("Lucida Bright");
	    format.add(ariel);
	    ariel.addActionListener(this.evtHandler);
	    format.add(comic);
	    comic.addActionListener(this.evtHandler);
	    format.add(georgia);
	    georgia.addActionListener(this.evtHandler);
	    format.add(lucida);
	    lucida.addActionListener(this.evtHandler);
	    
	    JMenu view = new JMenu("view");
	    
	    JMenu help = new JMenu("help");
	    JMenuItem developer = new JMenuItem("Developer");
	    //developer.addActionListener(this.evtHandler);
	    JMenuItem abt = new JMenuItem("About");
	    //abt.addActionListener(this.evtHandler);
	    
	    help.add(developer);
	    help.add(abt);
	    
	    this.menuBar.add(file);
	    this.menuBar.add(edit);
	    this.menuBar.add(format);
	    this.menuBar.add(view);
	    this.menuBar.add(help);
	    
	    setLayout(null);
	    
	    this.menuBar.setBounds(0, 0, 1366, 18);
	    //this.gamePanel.setBounds(20, 20, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 50, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 50);
	    //this.scorePanel.setBounds(20, GamePanel.SQUARE_SIZE * GamePanel.BOARD_SIZE + 70, 424, 110);
	    
	    //add(this.gamePanel);
	    //add(this.scorePanel);
	    add(panels);
	    add(this.menuBar);
	    int x = getWidth()-20;
	    int y = getHeight()-2;
	    textArea = new JTextArea();
	    //scroller.setBounds(0, 19, 1000, 700);// x, y);//, getWidth(), getHeight());
	    //add(textArea);
	    setLayout(new BorderLayout());
	    
	    textArea.setFont( new Font(fontName, Font.PLAIN, 18 ));
        setBorder(BorderFactory.createLineBorder(Color.BLUE.brighter(), 20));
	    JScrollPane scroller = new JScrollPane(textArea);
	    add(scroller, BorderLayout.CENTER);
        
}
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  }
  
  public static void main(String[] args)
  {
    JFrame window = new JFrame("UnTitled - Newton's Text Editor");
    TextEditor content = new TextEditor();
    window.setContentPane(content);
    window.setLocation(10, 10);
    window.setDefaultCloseOperation(3);
    window.setSize(new Dimension(500, 600));
    window.setResizable(true);
    window.setVisible(true);
  }
}
