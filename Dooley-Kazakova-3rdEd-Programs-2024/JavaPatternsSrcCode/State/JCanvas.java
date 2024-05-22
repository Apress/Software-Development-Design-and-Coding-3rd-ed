import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class JCanvas extends JPanel
{
   Mediator med;
   public JCanvas(Mediator md)
   {
      med = md;
      med.registerCanvas(this);
      setBackground(Color.white);
   }
   public void paint(Graphics g)
   {
      super.paint(g);
      med.reDraw(g);
   }
}
