import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;

public class LinePlotPanel extends PlotPanel
{

//--------------------------------------
public void paint(Graphics g)
{
   int xp = calcx(x[0]);      //get first point
   int yp = calcy(y[0]);
   g.setColor(Color.white);   //flood background
   g.fillRect(0,0,getWidth(), getHeight());
   g.setColor(Color.black);
   
   //draw bounding rectangle
   g.drawRect(xpmin, ypmin, xpmax, ypmax);
   g.setColor(color);
   
   //draw line graph
   for(int i=1; i< x.length; i++)
   {
      int xp1 = calcx(x[i]);
      int yp1 = calcy(y[i]);
      g.drawLine(xp, yp, xp1, yp1);
      xp = xp1;
      yp = yp1;
   }
}

}
