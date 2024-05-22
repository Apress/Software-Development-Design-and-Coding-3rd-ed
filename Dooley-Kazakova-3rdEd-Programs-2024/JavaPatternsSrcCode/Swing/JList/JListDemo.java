import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
 

public class JListDemo extends JxFrame
{
   public JListDemo()
   {
      super("JList demo");   
      JPanel jp = new JPanel();
    
      getContentPane().add(jp);
      JScrollPane sp = new JScrollPane();
      jp.add(sp);
      Vector dlist = new Vector();
      dlist.addElement("Anchovies");
      dlist.addElement("Bananas");
      dlist.addElement("Cilantro");
      dlist.addElement("Doughnuts");
      dlist.addElement("Escarrole");
      JList list= new JList(dlist);
      sp.getViewport().add(list);
      
      setSize(200,200);
      setVisible(true);
   }
   static public void main(String[] arv)
   {
      new JListDemo();
   }
}
