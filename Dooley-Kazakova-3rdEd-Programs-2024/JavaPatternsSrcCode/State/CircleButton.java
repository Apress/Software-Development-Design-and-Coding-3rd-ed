
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class CircleButton extends JToggleButton implements Command
{
   Mediator med;

  public CircleButton(ActionListener act, Mediator md)
  {
  super(" ");
  setSize(new Dimension(35,35));
  setBorderPainted(true);
  setMargin(new Insets(5,12,5,12));
  setToolTipText("Draw circle");
  addActionListener(act);
  med = md;
  med.registerCircleButton(this);
  }
//--------------------------------
  public Dimension getPreferredSize()
  {
     return new Dimension(35,35);
  }
//--------------------------------
  public void paint(Graphics g)
  {
     super.paint(g);
     int h = getHeight();
     int w = getWidth();
     g.setColor(Color.black);
     g.drawArc(2,2,h-4,h-4,0,360);
  }
//-------------------------------------------
  public void Execute()
  {
     med.startCircle();
  }
  
}

