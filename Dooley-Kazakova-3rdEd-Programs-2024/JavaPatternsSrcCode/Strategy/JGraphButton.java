import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;


public class JGraphButton extends JButton implements Command
{
   Context context;
   public JGraphButton(ActionListener act, Context ctx)
   {
   super("Line graph");
   addActionListener(act);
   context  = ctx;
   }
   //-------------------------------
   public void Execute()
   {
      context.setPenColor(Color.red); //set color of plot
      context.setLinePlot();        //set kind of plot
      context.readData("data.txt"); //read the data
      context.plot();               //plot the data
   }
}
