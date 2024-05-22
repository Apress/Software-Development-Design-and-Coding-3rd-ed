import java.awt.*;
import java.awt.event.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;


public class Decorator extends JComponent
{
   public Decorator(JComponent c)
   {
      setLayout(new BorderLayout());
      add("Center", c);
   }
}



