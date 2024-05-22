import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class SimpleJFC2 extends JxFrame
   implements ActionListener
{
   JButton OK, Quit;
   JPanel jp;
   Color color;

   public SimpleJFC2()
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
    OK = new JButton("OK",new ImageIcon("color.gif"));
    OK.setRolloverIcon(new ImageIcon("overColor.gif"));
    OK.setToolTipText("Change background color");
    Quit = new JButton("Quit", new ImageIcon("exit.gif")); 
    Quit.setToolTipText("Exit from program");
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
      new SimpleJFC2();
   }
}
