import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class ExitButton extends ActionButton
{

   JFrame fr;
   public ExitButton(String caption, Icon img, JFrame frm)
   {
     super(caption, img);
     fr = frm;
   }
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
}
