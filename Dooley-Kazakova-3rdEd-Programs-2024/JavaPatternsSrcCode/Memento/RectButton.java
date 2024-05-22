import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class RectButton extends JToggleButton implements Command
{
   Mediator med;

  public RectButton(ActionListener act, Mediator md)
  {
  super("R");
  //setSize(new Dimension(25,25));
  //setBorder(new EmptyBorder(5,5,5,5));
  setToolTipText("Draw rectangle");
  addActionListener(act);
  med = md;
  med.registerRectButton(this);
  }
//-------------------------------------------
  public void Execute()
  {
     if (isSelected()) 
        {
        med.startRectangle();
        }
  }
  
}

