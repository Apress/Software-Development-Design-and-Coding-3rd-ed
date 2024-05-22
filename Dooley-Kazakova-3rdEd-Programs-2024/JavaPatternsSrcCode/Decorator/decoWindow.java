import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;


public class decoWindow extends JxFrame
   implements ActionListener
{
   JButton Quit;
   public decoWindow()
   {
      super ("Deco Button");
      JPanel jp = new JPanel();
      
      getContentPane().add(jp);
      jp.add( new CoolDecorator(new JButton("Cbutton")));
      jp.add( new SlashDecorator(new CoolDecorator(new JButton("Dbutton"))));
      //jp.add( new CoolDecorator(new JButton("Dbutton")));
      jp.add(Quit = new JButton("Quit"));
      Quit.addActionListener(this);
      setSize(new Dimension(200,100));
      
      setVisible(true);
      Quit.requestFocus();
   }
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
   static public void main(String argv[])
   {
      new decoWindow();
   }
}
