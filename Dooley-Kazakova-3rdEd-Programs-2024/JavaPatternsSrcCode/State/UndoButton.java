
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class UndoButton extends JButton implements Command
{
   Mediator med;

  public UndoButton(ActionListener act, Mediator md)
  {
  super("U");
  //setSize(new Dimension(25,25));
  setMargin(new Insets(5,12,5,12));
  setToolTipText("Undo");
  addActionListener(act);
  med = md;
  }
  //-------------------------------------------
  public void Execute()
  {
     med.undo();
  }     
}

