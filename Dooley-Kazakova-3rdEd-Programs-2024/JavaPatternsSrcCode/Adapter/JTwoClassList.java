//Demonstratiob of simple Two-list program
//using JFC controls

import java.awt.*;
import java.awt.event.*;
//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.tree.*;
import com.sun.java.swing.border.*;


public class JTwoClassList extends JFrame
   implements ActionListener
{
   private JButton Add, MoveRight, MoveLeft;
   private JclassAwtList leftList, rightList;
   private TextField txt;

   public JTwoClassList()
   {
      super("Two Lists");
      setLF();          //set look and feel
      setCloseClick();  //Window exits on close-click
      setGUI();
   }
   //--------------------------------------------
   private void setGUI()
   {
      getContentPane().setLayout(new GridLayout(1,2));  //two columns
      setBackground(Color.lightGray);
      JPanel pLeft = new JPanel();
      JPanel pRight = new JPanel();
      getContentPane().add(pLeft);
      getContentPane().add(pRight);
      pLeft.setLayout(new BorderLayout());
      
      JPanel pTop = new JPanel();
      pLeft.add("North", pTop);
      txt = new TextField(15);
      pTop.add(txt);
      Add = new JButton("Insert");
      Add.setMargin(new Insets(0,0,0,0));

      pTop.add(Add);
      
      JPanel rBorder = new JPanel();
      rBorder.setLayout(new GridLayout(2,1));
      MoveRight = new JButton("Add --->");
      MoveLeft = new JButton("<--- Remove");
      
      JPanel rbTop = new JPanel();
      rbTop.add(MoveRight);
      rBorder.add(rbTop);
      
      JPanel rbBot = new JPanel();
      rbBot.add(MoveLeft);
      rBorder.add(rbBot);
      pLeft.add("East", rBorder);

      leftList = new JclassAwtList(15);
      JScrollPane lsp = new JScrollPane();
      pLeft.add("Center", lsp);
      lsp.getViewport().add(leftList);

      rightList = new JclassAwtList(15);
      JScrollPane rsp = new JScrollPane();
      pRight.setLayout(new BorderLayout());
      pRight.add("Center", rsp);
      rsp.getViewport().add(rightList);
      
      //Add button action listenes
      Add.addActionListener(this);
      MoveRight.addActionListener(this);
      MoveLeft.addActionListener(this);

      setSize(new Dimension(400, 300));
      setVisible(true);
   }
   //-----------------------------------------  
   private void setCloseClick()
   {
      //create window listener to respond to window close click
      addWindowListener(new WindowAdapter() 
       {
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    });
   }
   //------------------------------------------
   private void setLF()
   {
   // Force SwingApp to come up in the System L&F
	String laf = UIManager.getSystemLookAndFeelClassName();
	try {
       UIManager.setLookAndFeel(laf);
   	 }
       catch (UnsupportedLookAndFeelException exc) 
         {System.err.println("Warning: UnsupportedLookAndFeel: " + laf);}
       catch (Exception exc) {System.err.println("Error loading " + laf + ": " + exc);
	   }
   }

   //---------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      if(b == Add)
         addName();
      if(b == MoveRight)
         moveNameRight();
      if(b == MoveLeft)
         moveNameLeft();
   }
   //--------------------------------------------
   private void addName()
   {
      if (txt.getText().length() > 0) 
         {
         leftList.add(txt.getText());
         txt.setText("");
         }
   }
   //--------------------------------------------
   private void moveNameRight()
   {
     String sel[] = leftList.getSelectedItems();
     
     if (sel != null)        
     {
     rightList.add(sel[0]);
     leftList.remove(sel[0]);
     }
   }
   //--------------------------------------------
   public void moveNameLeft()
   {
    String sel[] = rightList.getSelectedItems();
     if (sel != null)        
     {
     leftList.add(sel[0]);
     rightList.remove(sel[0]);
     }
   }
   //--------------------------------------------
   static public void main(String argv[])
   {
      new JTwoList();
   }
}

