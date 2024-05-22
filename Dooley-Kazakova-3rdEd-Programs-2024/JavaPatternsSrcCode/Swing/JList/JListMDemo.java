import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
 

public class JListMDemo extends JxFrame
   implements ActionListener
{
   JTextField text;
   JList list;
   JButton Add;
   JListData ldata;

   public JListMDemo()
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

      ldata = new JListData();
      list= new JList(ldata); //create list with data
      sp.getViewport().add(list);   //add list to scrollpane
      
      setSize(200,200);
      setVisible(true);
   }  
   
   public void actionPerformed(ActionEvent e)
   {
      ldata.addElement(text.getText());
   }
   static public void main(String[] arv)
   {
      new JListMDemo();
   }
}
//======================================
class JListData extends AbstractListModel {
   private Vector dlist;	//the color name list
   
   public JListData()    {
      dlist = new Vector();
      makeData();
   }
   public int getSize()    {
      return dlist.size();
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
   public Object getElementAt(int index)    {
      return dlist.elementAt(index);
   }
  //add string to list and tell the list about it
   public void addElement(String s)    {
      dlist.addElement(s);
      fireIntervalAdded(this, dlist.size()-1, dlist.size());
   }
}

