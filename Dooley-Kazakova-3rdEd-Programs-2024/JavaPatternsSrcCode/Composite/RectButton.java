import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class RectButton extends JButton implements Command
{
   Mediator med;

  public RectButton(ActionListener act, Mediator md)
  {
  super("R");
  setBorder(new EmptyBorder(0,0,0,0));
  addActionListener(act);
  med = md;
  }
  public void Execute()
  {
   
  }
  
}

