
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class PickButton extends JToggleButton implements Command
{
   Mediator med;

  public PickButton(ActionListener act, Mediator md)
  {
  super(new ImageIcon("arrow.gif"));
  setSize(new Dimension(35,35));
  setBorderPainted(true);
  setMargin(new Insets(0,0,0,0));
  setToolTipText("Select drawing element");
  addActionListener(act);
  med = md;
  med.registerArrowButton(this);
  }
//-------------------------------------------
  public void Execute()
  {
     med.startArrow();
  }
  
}

