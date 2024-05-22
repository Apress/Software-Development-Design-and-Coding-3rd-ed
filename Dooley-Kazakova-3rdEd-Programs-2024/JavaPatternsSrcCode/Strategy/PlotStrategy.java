import java.awt.*;
import java.awt.event.*;
//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
//this is the abstact base class that
//concrete plot strategies are derived from

public abstract class PlotStrategy extends JFrame
{
  protected float[] x, y;
  protected float minX, minY, maxX, maxY;
  protected int width, height;
  protected Color color;
  
  public PlotStrategy(String title)
  {
     super(title);
     width = 300;
     height =200;
     color = Color.black;
     addWindowListener(new WindAp(this));
  }
  //--------------------------------------
  public abstract void plot(float xp[], float yp[]);
  //--------------------------------------
  public void setSize(Dimension sz)
  {
     width = sz.width;
     height = sz.height;
  }
  //--------------------------------------
  public void setPenColor(Color c)
  {
     color = c;
  }
  //--------------------------------------
  public void findBounds()
  {
     minX = minY = Float.MAX_VALUE;
     maxX = maxY = Float.MIN_VALUE;

     for(int i=0; i < x.length; i++)
     {
        if(x[i] > maxX)
           maxX = x[i];
        if(x[i] < minX)
           minX = x[i];

        if(y[i] > maxY)
           maxY = y[i];
        if(y[i] < minY)
           minY = y[i];
     }
  }
}
//===================================
class WindAp extends WindowAdapter
{
   JFrame fr;
   public WindAp(JFrame f)
   {
      fr=f;
   }
   public void WindowClosing(WindowEvent e)
   {
    fr.setVisible(false);
   }
}
