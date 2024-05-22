
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.table.*;

public class RenderTable extends JxFrame
{
   public RenderTable()
   {
      super("Simple table");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      JTable table = new JTable(new MusicModel());
      JScrollPane sp = new JScrollPane(table);
      table.setPreferredScrollableViewportSize(new Dimension(250,170));
      table.setDefaultRenderer(String.class, new ourRenderer());
      jp.add(sp);
      
      setSize(300,200);
      setVisible(true);
   }
   static public void main(String argv[])
   {
      new RenderTable();
   }
}


