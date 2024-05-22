//demonstrates use of the Action object
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class xMenu extends JxFrame
{
   JPanel jp;            
   JMenuItem menuitem;
   JToolBar toolbar;

   public xMenu()
   {
   super("Extended Menu");
   JMenuBar mbar = new JMenuBar();  //set up  menu bar
   setJMenuBar(mbar);
   
   //Add File menu
   JMenu mFile = new JMenu("File");
   mbar.add(mFile);

   //create two Action Objects
   Action Open = new FileButton("Open", new ImageIcon("open.gif"), this);
   mFile.add(Open);
   
   Action Exit = new ExitButton("Exit", new ImageIcon("exit.gif"), this);
   mFile.addSeparator();
   mFile.add(Exit);
   
   //now create toolbar that fixes up the buttons as you add them
   toolbar = new JToolBar();
   getContentPane().add(jp = new JPanel());
   jp.setLayout(new BorderLayout());
   jp.add("North", toolbar);
   
   //add the two action objects
   toolbar.add(Open);
   toolbar.addSeparator();
   toolbar.add(Exit);
    setSize(300, 200);
   setVisible(true);
   }
   //-----------------------------------
   static public void main(String argv[])
   {
      new xMenu();
   }
}
