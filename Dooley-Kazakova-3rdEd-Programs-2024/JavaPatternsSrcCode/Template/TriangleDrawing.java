import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;

public class TriangleDrawing extends JxFrame
{
stdTriangle t, t1;
IsocelesTriangle it;

  public TriangleDrawing()
  {
  super("Draw triangles");
  TPanel tp = new TPanel();
  t = new stdTriangle(new Point(10,10), new Point(150,50), new Point(100, 75));
  it = new IsocelesTriangle(new Point(150,100), new Point(240,40), new Point(175, 150));
  t1 = new stdTriangle(new Point(150,100), new Point(240,40), new Point(175, 150));
  tp.addTriangle(t);
  tp.addTriangle(it);
 // tp.addTriangle(t1);
  
  getContentPane().add(tp);
  setSize(300, 200);
  setBackground(Color.white);
  setVisible(true);
  }
  static public void main(String[] arg)
  {
    new TriangleDrawing();
  }
}
//===========================
class TPanel extends JPanel
{
   Vector triangles;
   public TPanel()
   {
      triangles = new Vector();
   }
   public void addTriangle(Triangle t)
   {
      triangles.addElement(t);
   }
   public void paint(Graphics g)
   {
      for (int i = 0; i < triangles.size(); i++)
      {
         Triangle tngl = (Triangle)triangles.elementAt(i);
         tngl.draw(g);
      }
   }
}
