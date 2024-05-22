import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class FileButton extends ActionButton
{

   JFrame fr;
   public FileButton(String caption, Icon img, JFrame frm)
   {
     super(caption, img);
     fr = frm;
   }
   public void actionPerformed(ActionEvent e)
   {
      FileDialog fdlg = new FileDialog(fr, "Open File", FileDialog.LOAD);
      //JFileChooser fdlg = new JFileChooser();
      //fdlg.showOpenDialog(fr);
   }
}
