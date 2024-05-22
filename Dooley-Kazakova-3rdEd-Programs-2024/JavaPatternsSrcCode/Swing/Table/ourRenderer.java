
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.table.*;

public class ourRenderer extends JLabel implements TableCellRenderer
{
   Font bold, plain;
  public ourRenderer()
  {
     super();
     setOpaque(true);
     setBackground(Color.white);
     bold = new Font("SansSerif", Font.BOLD, 12);
     plain = new Font("SansSerif", Font.PLAIN, 12);
     setFont(plain);
  }
  public Component getTableCellRendererComponent(JTable jt, Object value, boolean isSelected,
       boolean hasFocus, int row, int column)
        {
          setText((String)value);
          if(row ==1 && column==1)
          {
             setFont(bold);
             setForeground(Color.red);
          }
          else
          {
             setFont(plain);
            setForeground(Color.black);
          }
        return this;
       }
  }
                                       
