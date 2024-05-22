import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
//--------------------------------------------
public class PlotPanel extends JPanel
{
   float xfactor, yfactor;
   int xpmin, ypmin, xpmax, ypmax;
   float minX, maxX, minY, maxY;
   float x[], y[];
   Color color;
//--------------------------------------------
 public void setBounds(float minx, float miny, float maxx, float maxy)
  {
     minX=minx;
     maxX= maxx;
     minY=miny;
     maxY = maxy;
  }                                           
//--------------------------------------------
 public void plot(float[] xp, float[] yp, Color c)
 {
  x = xp;      //copy in the arrays
  y = yp;
  color = c;   //and color
  
  //compute bounds and sclaing factors
  int w = getWidth() - getInsets().left - getInsets().right;
  int h = getHeight() - getInsets().top - getInsets().bottom;
    
  xfactor = (0.9f * w) / (maxX - minX);
  yfactor = (0.9f * h)/ (maxY - minY);

  xpmin = (int)(0.05f * w);
  ypmin = (int)(0.05f * h);
  xpmax = w - xpmin;
  ypmax = h - ypmin;
  repaint();      //this causes the actual plot
 }
//--------------------------------------
protected int calcx(float xp)
{
   return (int)((xp-minX) * xfactor + xpmin);
}
//--------------------------------------
protected int calcy(float yp)
{
   int ypnt = (int)((yp-minY) * yfactor);
   return ypmax - ypnt;
}

}

