import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;


public class StateDraw extends JxFrame
   implements ActionListener
{
   JToolBar tbar;
   Mediator med;
//-------------------------------------------
 public StateDraw()
 {
    super("State Drawing");
    JPanel jp = new JPanel();
    getContentPane().add(jp);
    med = new Mediator();

    jp.setLayout(new BorderLayout());
    tbar = new JToolBar();
    tbar.setFloatable(false);
    jp.add("North", tbar);
    PickButton pick = new PickButton(this, med);
    tbar.add(pick);
    tbar.addSeparator();
    RectButton rect = new RectButton(this, med);
    tbar.add(rect);
    FillButton fill = new FillButton(this,med);
    tbar.add(fill);
    CircleButton circ = new CircleButton(this, med);
    tbar.add(circ);
    tbar.addSeparator();
    ClearButton clr = new ClearButton(this, med);
    tbar.add(clr);

    JCanvas canvas = new JCanvas(med);
    jp.add("Center", canvas);
    
    MouseApp map = new MouseApp(med);
    canvas.addMouseListener(map);
    MouseMoveApp mvap = new MouseMoveApp(med);
    canvas.addMouseMotionListener(mvap);
    setSize(new Dimension(400,300));
    setVisible(true);
    
 }
 
 //-------------------------------------------
 public void actionPerformed(ActionEvent e)
 {
    Command comd = (Command)e.getSource();
     comd.Execute();
 }
 //-------------------------------------------
static public void main(String[] argv)
{
   new StateDraw();
}
}
//==============================
class MouseApp extends MouseAdapter
{
   Mediator med;
   public MouseApp(Mediator md)
   {
      super();
      med = md;
   }
   public void mousePressed(MouseEvent e)
   {
      med.mouseDown(e.getX(), e.getY());
   }
   public void mouseReleased(MouseEvent e)
   {
      med.mouseUp(e.getX(), e.getY());
   }
}
//-------------------------------------------
class MouseMoveApp extends MouseMotionAdapter
{
   Mediator med;
   public MouseMoveApp(Mediator md)
   {
      super();
      med = md;
   }
   public void mouseDragged(MouseEvent e)
   {
      med.mouseDrag(e.getX(), e.getY());
   }
}
