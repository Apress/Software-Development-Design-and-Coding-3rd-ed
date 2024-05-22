import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;

public class Buttons extends JxFrame
   implements ActionListener
{
   JToolBar toolbar;
   JCheckBox YMCA, Rotary,ACLU;
   JRadioButton Rep, Dem, Flat;
   JButton Clear, Quit;

   public Buttons()
   {
   super("Buttons and Checks");
   JPanel jp = new JPanel();
   getContentPane().add(jp);
   jp.setLayout(new BorderLayout());
   toolbar = new JToolBar();
   jp.add("North", toolbar);
   JPanel center = new JPanel();
   jp.add("Center", center);
   center.setLayout(new GridLayout(1,2));
   JPanel left = new JPanel();
   JPanel right = new JPanel();
   center.add(left);
   center.add(right);
   left.setLayout(new GridLayout(3,1));
   right.setLayout(new GridLayout(3,1));
   left.setBorder(new TitledBorder("Memberships"));
   right.setBorder(new TitledBorder("Party"));

   left.add(YMCA = new JCheckBox("YMCA"));
   left.add(Rotary = new JCheckBox("Rotary"));
   left.add(ACLU = new JCheckBox("ACLU"));
   
   right.add(Rep = new JRadioButton("Republicrat"));
   right.add(Dem = new JRadioButton("Demmican"));
   right.add(Flat = new JRadioButton("Flat Earth"));
   ButtonGroup bgroup = new ButtonGroup();
   bgroup.add(Rep);
   bgroup.add(Dem);
   bgroup.add(Flat);

   setBar();

   setSize(300,200);
   setVisible(true);

   }
   private void setBar()
   {
      Clear = new ToolButton(new ImageIcon("erase.gif"));
      Quit = new ToolButton(new ImageIcon("stop.gif"));
      toolbar.add(Clear);
      Clear.setToolTipText("Clear all boxes");
      Quit.setToolTipText("Exit from program");
      toolbar.add(Quit);
      Clear.addActionListener(this);
      Quit.addActionListener(this);
      toolbar.addSeparator();
      JToggleButton a = new JToggleButton("a");
      JToggleButton b = new JToggleButton("b");
      JToggleButton c = new JToggleButton("c");
      toolbar.add(a);
      toolbar.add(b);
      toolbar.add(c);
      ButtonGroup tgroup = new ButtonGroup();
      tgroup.add(a);
      tgroup.add(b);
      tgroup.add(c);
   }
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if(obj == Quit)
         System.exit(0);
      if(obj == Clear)
      {
         YMCA.setSelected(false);
         Rotary.setSelected(false);
         ACLU.setSelected(false);
         Rep.setSelected(false);
         Dem.setSelected(false);
         Flat.setSelected(false);
      }
   }
   static public void main(String argv[])
   {
      new Buttons();
   }
}
