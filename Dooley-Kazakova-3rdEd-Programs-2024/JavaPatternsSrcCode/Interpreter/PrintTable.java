
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.tree.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.table.*;

public class PrintTable extends JScrollPane
{
   JTable table;
   prodModel pmodel;

   public PrintTable()
   {
      pmodel = new prodModel();
      table = new JTable(pmodel);
      getViewport().add(table);
   }
   public void setDims(int r, int c)
   {
      pmodel.setSize(r, c);
   }
   
   public void setValueAt(Object obj, int row, int col)
   {
      pmodel.setValueAt(obj, row, col);
   }
}
//==========================================
class prodModel implements TableModel
{
   int rows, columns;
   Vector columnList;

   public prodModel()
   {
      columns = 0;
      rows = 0;
   }
//-----------------------------------------
   public void setSize(int r, int cols)
   {
      columns = cols;
      rows = r;
      columnList = new Vector(columns);
      for(int i = 0; i < columns; i++)
      {
         Vector v = new Vector(r);
         for (int j = 0; j < r; j++)
            v.addElement("");
         columnList.addElement(v);
      }
   }
  //----------------------------------------- 
  public void setValueAt(Object obj, int row, int col)
   {
   
      Vector v = (Vector)columnList.elementAt(col);
      v.setElementAt(obj, row);
   }
  //-----------------------------------------
   public int getColumnCount()
   {
      return columns;
   }
   //-----------------------------------------
   public int getRowCount()
   {
      return rows;
   }
   //-----------------------------------------
   public Object getValueAt(int row, int col)
   {
      Vector v = (Vector)columnList.elementAt(col);
      System.out.println(row+" "+v.elementAt(row));
      return v.elementAt(row);
   }
   //-----------------------------------------
   public Class getColumnClass(int c)
   {
      return (new String("")).getClass();
   }

   public boolean isCellEditable(int r, int c){return false;}
   public String getColumnName(int c){return "";}
   public void addTableModelListener(TableModelListener tbm){}
   public void removeTableModelListener(TableModelListener tbm){}
}
