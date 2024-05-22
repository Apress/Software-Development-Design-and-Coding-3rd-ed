import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
 

public class JListADemo extends JxFrame
   implements ActionListener
{
   JTextField text;
   JList list;
   JButton Add;
   Vector dlist;

   public JListADemo()
   {
      super("JList demo");   
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());

      //create text field
      text = new JTextField(20);
      jp.add("North", text);
      //Add button
      Add = new JButton("Add");
      JPanel p = new JPanel();
      jp.add("South", p);
      p.add(Add);
      Add.addActionListener(this);
      //create scroll pane
      JScrollPane sp = new JScrollPane();
      jp.add("Center", sp);                   //add to layout

      list= new JList(makeData()); //create list with data
      sp.getViewport().add(list);   //add list to scrollpane
      
      setSize(200,200);
      setVisible(true);
   }  
   private Vector makeData()
   {
      dlist = new Vector();  //create vector
      dlist.addElement("Anchovies");   //and add data
      dlist.addElement("Bananas");
      dlist.addElement("Cilantro");
      dlist.addElement("Doughnuts");
      dlist.addElement("Escarole");
      return dlist;
   }
   public void actionPerformed(ActionEvent e)
   {
      dlist.addElement(text.getText());
      list.setListData(dlist);
      list.repaint();
   }
   static public void main(String[] arv)
   {
      new JListADemo();
   }
}
