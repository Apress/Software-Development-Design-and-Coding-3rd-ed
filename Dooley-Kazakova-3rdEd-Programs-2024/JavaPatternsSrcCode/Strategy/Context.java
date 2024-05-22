import java.awt.*;
import java.util.*;

public class Context
{
 //this object selects one of the strategies
   //to be used for plotting
   private PlotStrategy plotStrategy;
   float x[], y[];
//---------------------------------
  public Context() { setLinePlot(); }
  public void setBarPlot() {plotStrategy = new BarPlotStrategy(); }
  public void setLinePlot() { plotStrategy = new LinePlotStrategy(); }
//---------------------------------
  public void plot() {
     plotStrategy.plot(x, y);
  }
//---------------------------------
  public void setPenColor(Color c) {
     plotStrategy.setPenColor(c);
  }
  //---------------------------------
  public void readData(String filename)
  {
     StringTokenizer tok;
     InputFile f = new InputFile(filename);
     Vector xv = new Vector();
     Vector yv = new Vector();
     String s ="";
     //read data into 2 Vectors
     while(s != null)
     {
        s =f.readLine();   //read a line at a time
        if(s != null)
        {
           tok = new StringTokenizer(s);  
           xv.addElement(tok.nextToken());   //x data
           yv.addElement(tok.nextToken());   //y data
        }
     }
     f.close();
     //copy data into two float arrays
     x = new float[xv.size()];
     y = new float[yv.size()];
     for (int i=0; i< xv.size(); i++)
     {
        x[i] = new Float((String)xv.elementAt(i)).floatValue();
        y[i] = new Float((String)yv.elementAt(i)).floatValue();
     }
  }
}

