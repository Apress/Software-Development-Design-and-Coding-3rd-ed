import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KidList extends JawtList
   implements ListSelectionListener
{
   KidData kdata;
   Mediator med;

  public KidList(Mediator md)
  {
   super(20);
   kdata = new KidData ("50free.txt");
   fillKidList();
   med = md;
   med.registerKidList(this);
   addListSelectionListener(this);
  }
    
//----------------------------------
  public void valueChanged(ListSelectionEvent ls)
  {
     JList obj = (JList)ls.getSource();
     if (obj.getSelectedIndex() >= 0)
         med.select();
  }
  //----------------------------------
  private void fillKidList()
   {
      Enumeration ekid = kdata.elements();
      while (ekid.hasMoreElements())
         {
         Kid k =(Kid)ekid.nextElement();
         add(k.getFrname()+" "+k.getLname());
         }
   }
}

