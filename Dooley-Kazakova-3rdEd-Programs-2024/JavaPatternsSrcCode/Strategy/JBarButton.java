import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;

public class JBarButton extends JButton implements Command
{
   Context context;

   public JBarButton(ActionListener act, Context ctx)
   {
   super("Bar graph");
   addActionListener(act);
   context = ctx;
   }
   public void Execute()
   {
      context.readData("data.txt");
      context.setBarPlot();
      context.plot();
   }
}
