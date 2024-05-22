
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class ActionToolBar extends JToolBar
{
   public ActionToolBar()
   {
   setFloatable(false);
   }
   public void add(Action act, String tip)
   {
      JButton button = super.add(act);
      button.setText("");
      button.setToolTipText(tip);
      button.setMargin(new Insets(0,0,0,0));
   }
}
