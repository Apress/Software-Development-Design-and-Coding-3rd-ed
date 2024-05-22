import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class ToolButton extends JButton
{
   public ToolButton(Icon img)
   {
      super(img);
      setMargin(new Insets(0,0,0,0));
      setSize(25,25);
   }
}
