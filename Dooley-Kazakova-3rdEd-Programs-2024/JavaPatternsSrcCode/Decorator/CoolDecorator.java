import java.awt.*;
import java.awt.event.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;


public class CoolDecorator extends Decorator
{
   boolean mouse_over;    //true when mose over button
   JComponent thisComp;

   public CoolDecorator(JComponent c)
   {
      super(c);
      mouse_over = false;
      thisComp = this;      //save this component
      //catch mouse movements in inner class
      c.addMouseListener(new MouseAdapter() 
      {
      public void mouseEntered(MouseEvent e) {
         mouse_over=true;     //set flag when mouse over
         thisComp.repaint();
         }
      public void mouseExited(MouseEvent e) {
         mouse_over=false;    //clear flag when mouse not over
         thisComp.repaint();
         }
      });

   }
   //paint the button
   public void paint(Graphics g)
   {
      super.paint(g);      //first draw the parent button
      if(! mouse_over)
         //if the mouse is not over the button
         //erase the borders
      {
         Dimension size = super.getSize();
         g.setColor(Color.lightGray);
         g.drawRect(0, 0, size.width-1, size.height-1);
         g.drawLine(size.width-2, 0, size.width-2, size.height-1);
         g.drawLine(0, size.height-2, size.width-2, size.height-2);
      }

   }
}
