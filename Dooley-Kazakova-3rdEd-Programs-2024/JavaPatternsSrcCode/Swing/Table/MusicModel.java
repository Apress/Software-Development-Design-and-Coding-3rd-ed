
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.table.*;

class MusicModel extends AbstractTableModel
{
  
   String[] columnNames = {"Composer", "Title", "Orchestral"};

   Object[] [] musicData = {
   {"Tschaikovsky", "1812 Overture", new Boolean(true)},
   {"Stravinsky", "Le Sacre", new Boolean(true)},
   {"Lennon","Eleanor Rigby", new Boolean(false)},
   {"Wagner", "Gotterdammerung", new Boolean(true)}
   };

   int rowCount, columnCount;                  
   //------------------------------------------
   public MusicModel()
   {
      rowCount = 4;
      columnCount =3;
   }
   //------------------------------------------
   public String getColumnName(int col)
   {
      return columnNames[col];
   }
   //------------------------------------------
   public int getRowCount(){return rowCount;}
   public int getColumnCount(){return columnCount;}
   //------------------------------------------
   public Class getColumnClass( int col)
   {
      return getValueAt(0, col).getClass();
   }
   //------------------------------------------
   public boolean isCellEditable(int row, int col)
   {
      return (col > 1);
   }
   //------------------------------------------
   public void setValueAt(Object obj, int row, int col)
   {
      musicData[row][col] = obj;
        fireTableCellUpdated(row, col);
    
   }
   //------------------------------------------
   public Object getValueAt(int row, int col)
      {
         return musicData[row][col];
      }

}
