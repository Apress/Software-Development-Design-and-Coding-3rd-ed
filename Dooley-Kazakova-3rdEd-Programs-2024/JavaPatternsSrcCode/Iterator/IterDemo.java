
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
public class IterDemo extends JxFrame
   implements ActionListener
{
   JawtList kidList, kidClubList;
   JTextField tx;
   JButton Get;
   KidData kdata;

   public IterDemo()
   {
      super("Enumeration demo");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new GridLayout(1,2));
      JPanel left = new JPanel();
      JPanel right = new JPanel();
      jp.add(left);
      jp.add(right);
      left.setBorder(new EmptyBorder(5,5,5,5));
      right.setBorder(new EmptyBorder(5,5,5,5));
      kidList = new JawtList(20);
      left.setLayout(new BorderLayout());
      left.add("Center", kidList);

      right.setLayout(new BorderLayout());
      tx = new JTextField(10);
      Get = new JButton("Get");
      Get.addActionListener(this);
      JPanel rtop = new JPanel();
      right.add ("North", rtop);
      rtop.add(tx);
      rtop.add(Get);
      kidClubList = new JawtList(20);
      right.add("Center",kidClubList);
      kdata = new KidData ("50free.txt");   
      fillKidList();
      setSize(new Dimension(400,300));
      setVisible(true);
   }
   //---------------------------------------
   private void fillKidList()
   {
      Enumeration ekid = kdata.elements();
      while (ekid.hasMoreElements())
         {
         Kid k =(Kid)ekid.nextElement();
         kidList.add(k.getFrname()+" "+k.getLname());
         }
   }
   //---------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      String club = tx.getText();
      if(club.trim().length() > 0)
      {
         Enumeration eclub = kdata.kidsInClub(club);
         while(eclub.hasMoreElements())
         {
         Kid k =(Kid)eclub.nextElement();
         kidClubList.add(k.getFrname()+" "+k.getLname());
         }
      }
   }
   //---------------------------------------
   static public void main(String argv[])
   {
      new IterDemo();
   }
}
