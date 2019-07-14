package snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressWarnings("unused")
public class FileManager
{
  public int[] array;
  public GamePanel panel;
  DocumentBuilder docReader;
  Document xmldoc;
  public byte[][] board;
  public PrintWriter write;
  public File f;
  public boolean b;
  
  public FileManager(File file, boolean overWrite)
  {
    this.f = file;
    this.b = overWrite;
    this.array = new int[5];
    this.board = new byte[GamePanel.BOARD_SIZE][GamePanel.BOARD_SIZE];
  }
  
  public boolean writeScore()
  {
    try
    {
      if ((this.f.exists()) && (this.f != null))
      {
        FileWriter writer = new FileWriter(this.f, this.b);
        this.write = new PrintWriter(writer);
      }
    }
    catch (FileNotFoundException er)
    {
      this.panel.message = "Cannot update file";
      return false;
    }
    catch (IOException e)
    {
      this.panel.message = "Cannot update file";
      return false;
    }
    if (this.write != null)
    {
      this.write.println("<?xml version=\"1.0\"?>");
      this.write.println("<snakegame version=\"1.0\"> ");
      this.write.println("<scores>");
      for (int j = 0; j < this.array.length; j++) {
        this.write.println("  <score level = \"0\"  value ='" + this.array[j] + "'/>");
      }
      this.write.println("</scores>");
      this.write.println("</snakegame>");
      this.write.flush();
      this.write.close();
      return true;
    }
    return false;
  }
  
  public void readFile()
  {
    try
    {
      this.docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      this.xmldoc = this.docReader.parse(this.f);
    }
    catch (FileNotFoundException er)
    {
      this.panel.message = "Cannot update file";
      return;
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
      return;
    }
    catch (SAXException e)
    {
      e.printStackTrace();
      return;
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return;
    }
    Element rootElement = this.xmldoc.getDocumentElement();
    NodeList nodes = rootElement.getChildNodes();
    
    int a = 0;
    for (int i = 0; i < nodes.getLength(); i++) {
      if ((nodes.item(i) instanceof Element))
      {
        Element element = (Element)nodes.item(i);
        if (element.getTagName().equals("scores"))
        {
          NodeList scoreNodes = element.getChildNodes();
          for (int j = 0; j < scoreNodes.getLength(); j++) {
            if ((scoreNodes.item(j) instanceof Element))
            {
              Element scoreE = (Element)scoreNodes.item(j);
              if (scoreE.getTagName().equals("score"))
              {
                int k = Integer.parseInt(scoreE.getAttribute("value"));
                
                this.array[a] = k;
                a++;
              }
            }
          }
        }
      }
    }
    sort();
  }
  
  public void sort()
  {
    for (int i = 0; i < this.array.length; i++) {
      for (int j = this.array.length - 1; j > i; j--) {
        if (this.array[j] > this.array[(j - 1)])
        {
          int temp = this.array[j];
          this.array[j] = this.array[(j - 1)];
          this.array[(j - 1)] = temp;
        }
      }
    }
  }
  
  public boolean checkIfAHighScore(int i)
  {
    if (this.array[4] < i)
    {
      this.panel.message += "  (A high Score )";
      return true;
    }
    return false;
  }
  
  public void InsertScore(int k)
  {
    this.array[4] = k;
  }
  
  public void print()
  {
    for (int i = 0; i < this.array.length; i++) {
      System.out.print(this.array[i] + "    ");
    }
    System.out.println();
  }
}
