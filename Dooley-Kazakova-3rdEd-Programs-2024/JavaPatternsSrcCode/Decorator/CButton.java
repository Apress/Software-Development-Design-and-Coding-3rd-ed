import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class CButton extends JButton
{
   private boolean mouse_over = false;
   CButton thisbutton;

   public CButton(String caption)
   {
      super(caption);
      thisbutton = this;
      addMouseListener(new MouseAdapter() 
      {
      public void mouseEntered(MouseEvent e) {mouse_over=true;thisbutton.repaint();}
      public void mouseExited(MouseEvent e) {mouse_over=false;thisbutton.repaint();}
      });

   }
   public void paint(Graphics g)
   {
      super.paint(g);
      if(! mouse_over)
      {
         Dimension size = getSize();
         g.setColor(Color.lightGray);
         g.drawRect(0, 0, size.width-1, size.height-1);
         g.drawLine(size.width-2, 0, size.width-2, size.height-1);
         g.drawLine(0, size.height-2, size.width-2, size.height-2);
      }
   }
}
