import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
 

public class JListLDemo extends JxFrame
   implements ListSelectionListener
{
   JTextField text;
   JList list;

   public JListLDemo()
   {
      super("JList demo");   
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());

      //create text field
      text = new JTextField(20);
      jp.add("North", text);

      //create scroll pane
      JScrollPane sp = new JScrollPane();
      jp.add("Center", sp);                   //add to layout

      list= new JList(makeData()); //create list with data
      sp.getViewport().add(list);   //add list to scrollpane
      list.addListSelectionListener(this);
      
      setSize(200,200);
      setVisible(true);
   }  
   private Vector makeData()
   {
      Vector dlist = new Vector();  //create vector
      dlist.addElement("Anchovies");   //and add data
      dlist.addElement("Bananas");
      dlist.addElement("Cilantro");
      dlist.addElement("Doughnuts");
      dlist.addElement("Escarole");
      return dlist;
   }
   public void valueChanged(ListSelectionEvent e)
   {
      text.setText((String)list.getSelectedValue());
   }
   static public void main(String[] arv)
   {
      new JListLDemo();
   }
}
