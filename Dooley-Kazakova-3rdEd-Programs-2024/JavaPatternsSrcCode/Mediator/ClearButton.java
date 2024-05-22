import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ClearButton extends JButton implements Command
{
   Mediator med;

   public ClearButton(ActionListener act, Mediator md)
   {
      super("Clear");
      addActionListener(act);
      med = md;
      med.registerClear(this);
   }
   public void Execute()
   {
      med.Clear();
   }
}
