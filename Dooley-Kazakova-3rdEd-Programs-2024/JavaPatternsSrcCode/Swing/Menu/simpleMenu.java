import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class simpleMenu extends JxFrame
{
   public simpleMenu()
   {
   super("Simple Menu");
   JMenuBar mbar = new JMenuBar();
   setJMenuBar(mbar);
   JMenu mFile = new JMenu("File");
   mbar.add(mFile);
   JMenuItem Open = new JMenuItem("Open");
   JMenuItem Exit = new JMenuItem("Exit");
   mFile.add(Open);
   mFile.addSeparator();
   mFile.add(Exit);
   setSize(100,200);
   setVisible(true);
   }
   static public void main(String argv[])
   {
      new simpleMenu();
   }
}
