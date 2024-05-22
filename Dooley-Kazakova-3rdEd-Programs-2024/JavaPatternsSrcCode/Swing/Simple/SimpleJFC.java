import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class SimpleJFC extends JxFrame
   implements ActionListener
{
   JButton OK, Quit;
   JPanel jp;
   Color color;

   public SimpleJFC()
   {
    super("Simple JFC Program");
    color = Color.yellow;
    setGUI();
   }
   //-------------------------------------------
   private void setGUI()
   {
    jp = new JPanel();
    getContentPane().add(jp);
    //create and add buttons
    OK = new JButton("OK");
    Quit = new JButton("Quit"); 
    OK.addActionListener(this);
    Quit.addActionListener(this);
    
    jp.add(OK);
    jp.add(Quit);

    setSize(new Dimension(250,100));
    setVisible(true);
   }
   //-------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if(obj == OK)
         switchColors();
      if(obj == Quit)
         System.exit(0);
   }
   //------------------------------------------
   private void switchColors()
   {
      if(color == Color.green)
         color = Color.yellow;
      else
         color = Color.green;
      jp.setBackground(color);
      repaint();
   }
   //-------------------------------------------
   static public void main(String[] argv)
   {
      new SimpleJFC();
   }
}
