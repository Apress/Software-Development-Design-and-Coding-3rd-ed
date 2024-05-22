import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
//-----------------------------------
public class InterpDemo extends JxFrame
   implements ActionListener
{
   JButton Go;
   JTextField tx;
   KidData kdata;
   JawtList ptable;

  public InterpDemo()
  {
     super("Interpreter Demo");
     tx= new JTextField(20);
     Go = new JButton("Go");
     
     JPanel p = new JPanel();
     getContentPane().add(p);
     p.setLayout(new BorderLayout());
     JPanel np = new JPanel();
     p.add("North", np);
     np.add(tx);
     np.add(Go);
     Go.addActionListener(this);
     ptable = new JawtList(20);
     p.add("Center", ptable);

     kdata = new KidData("50free.txt");

     setSize(new Dimension(400,200));
     setVisible(true);
  }
  //----------------------------------------
  public void actionPerformed(ActionEvent e)
  {
     Parser p =  new Parser(tx.getText());
     p.setData(kdata, ptable);
     p.Execute();
  }
  //----------------------------------------
  static public void main(String argv[])
  {
     new InterpDemo();
  }
}

