import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;

public class BarPlotPanel extends PlotPanel
{
   Color[] colors;
//--------------------------------------
 public BarPlotPanel()
 {
    colors = new Color[6];
    colors[0] = Color.red;
    colors[1] = Color.blue;
    colors[2] = Color.green;
    colors[3] = new Color(0xff8000);
    colors[4] = Color.lightGray;
    colors[5] = Color.yellow;
 }
//--------------------------------------
public void paint(Graphics g)
{
   int xp, yp ;

   int ypm = (int)(ypmax * 1.05f);
   g.setColor(Color.white);
   g.fillRect(0,0,getWidth(), getHeight());
   g.setColor(Color.black);
   g.drawRect(xpmin, ypmin, xpmax, ypm - ypmin);
   g.setColor(colors[0]);
   
   for(int i=0; i< x.length; i++)
   {
      g.setColor(colors[i]);     
      xp = calcx(x[i]);
      yp = calcy(y[i]);
      g.fillRect(xp, yp, calcx(1.0f), ypm-yp);
   }
}

}
