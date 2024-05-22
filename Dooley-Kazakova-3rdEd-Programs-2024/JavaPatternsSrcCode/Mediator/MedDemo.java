
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
public class MedDemo extends JxFrame
   implements ActionListener
{
   KidList kidList;
   PickedKidsList picked;
   KTextField tx;
   MoveButton Move;
   ClearButton Clear;
   Mediator med;
   
   public MedDemo()
   {
      super("Mediator demo");
      
      Mediator med = new Mediator();
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());
      JPanel center = new JPanel();
      JPanel left = new JPanel();
      JPanel right = new JPanel();
      jp.add("Center", center);
      center.setLayout(new GridLayout(1,2));
      center.add(left);                           
      center.add(right);
      left.setBorder(new EmptyBorder(5,5,5,5));
      right.setBorder(new EmptyBorder(5,5,5,5));
      kidList = new KidList( med);
      left.setLayout(new BorderLayout());
      left.add("Center", kidList);
      
      
      right.setLayout(new BorderLayout());
      tx = new KTextField(med);

      Move = new MoveButton(this, med);
      Clear = new ClearButton(this, med);
      JPanel rtop = new JPanel();
      jp.add ("North", rtop);
      rtop.add(tx);
      rtop.add(Move);
      rtop.add(Clear);
      picked =new PickedKidsList(med);
      right.add("Center", picked);
   
      med.init();
      setSize(new Dimension(400,300));
      setVisible(true);
   }
   //---------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Command comd = (Command)e.getSource();
      comd.Execute();
   }
   //---------------------------------------
   static public void main(String argv[])
   {
      new MedDemo();
   }
}
