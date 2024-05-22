//demonstrates use of the Action object
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class xtendMenu extends JxFrame
{
   JPanel jp;            
   JMenuItem menuitem;
   ActionToolBar toolbar;

   public xtendMenu()
   {
   super("Extended Menu");
   JMenuBar mbar = new JMenuBar();  //set up  menu bar
   setJMenuBar(mbar);
   
   //Add File menu
   JMenu mFile = new JMenu("File");
   mbar.add(mFile);

   //create two Action Objects
   Action Open = new FileButton("Open", new ImageIcon("open.gif"), this);
   menuitem = mFile.add(Open);
   menuitem.setIcon(null);

   Action Exit = new ExitButton("Exit", new ImageIcon("exit.gif"), this);
   mFile.addSeparator();
   menuitem = mFile.add(Exit);
   menuitem.setIcon(null);
   //Exit.setEnabled(false);  --used to test disable

   //now create toolbar that fixes up the buttons as you add them
   toolbar = new ActionToolBar();
   getContentPane().add(jp = new JPanel());
   jp.setLayout(new BorderLayout());
   jp.add("North", toolbar);
   
   //add the two action objects
   toolbar.add(Open, "Open a file");
   toolbar.addSeparator();
   toolbar.addSeparator();
   toolbar.addSeparator();
   toolbar.add(Exit, "Exit from program");
   setSize(300, 200);
   setVisible(true);
   }
   //-----------------------------------
   static public void main(String argv[])
   {
      new xtendMenu();
   }
}
