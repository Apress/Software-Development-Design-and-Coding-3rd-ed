import java.awt.*;
import java.awt.event.*;
import java.util.*;
//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.tree.*;
import com.sun.java.swing.border.*;

//this is a simple adapter class to
//convert List awt methods to Swing methods

public class JclassAwtList extends JList
   implements ListSelectionListener, awtList
{
   private JListData listContents;
//-----------------------------------------
   public JclassAwtList(int rows)
   {
      listContents = new JListData();
      setModel(listContents);
      setPrototypeCellValue("Abcdefg Hijkmnop");     
   }
//-----------------------------------------
   public void add(String s)
   {
      listContents.addElement(s);
   }
//-----------------------------------------
   public void remove(String s)
   {
      listContents.removeElement(s);
   }
//-----------------------------------------
   public String[] getSelectedItems()
   {
      Object[] obj = getSelectedValues();
      String[] s = new String[obj.length];
      for (int i =0; i<obj.length; i++) 
            s[i] = obj[i].toString();
      return s;
   }
//-----------------------------------------
   public void valueChanged(ListSelectionEvent e)
   {
   }
   
}
//  =========================================
class JListData extends AbstractListModel
{
   private Vector data;
//-----------------------------------------
   public JListData()
   {
      data = new Vector();
   }
//-----------------------------------------
   public int getSize()
   {
      return data.size();
   }
//-----------------------------------------
   public Object getElementAt(int index)
   {
      return data.elementAt(index);
   }
//-----------------------------------------
   public void addElement(String s)
   {
      data.addElement(s);
      fireIntervalAdded(this, data.size()-1, data.size());
   }
//-----------------------------------------
   public void removeElement(String s)
   {
      data.removeElement(s);
      fireIntervalRemoved(this, 0, data.size());
   }
}

