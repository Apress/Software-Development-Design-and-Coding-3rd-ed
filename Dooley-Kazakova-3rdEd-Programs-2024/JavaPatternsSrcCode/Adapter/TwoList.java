//Demonstratio of simple Two-list program
//using awt controls

import java.awt.*;
import java.awt.event.*;

public class TwoList extends Frame
   implements ActionListener
{
   private Button Add, MoveRight, MoveLeft;
   private List leftList, rightList;
   private TextField txt;

   public TwoList()
   {
      super("Two Lists");
      setCloseClick();
      setGUI();
   }
   //--------------------------------------------
   private void setGUI()
   {
      setLayout(new GridLayout(1,2));  //two columns
      setBackground(Color.lightGray);
      Panel pLeft = new Panel();
      Panel pRight = new Panel();
      add(pLeft);
      add(pRight);
      pLeft.setLayout(new BorderLayout());
      
      //top panel contains text field and 
      //Insert buttn
      Panel pTop = new Panel();
      pLeft.add("North", pTop);
      txt = new TextField(10);
      pTop.add(txt);
      Add = new Button("Insert");
      pTop.add(Add);
      
      //right border contains add and remove buttons
      Panel rBorder = new Panel();
      rBorder.setLayout(new GridLayout(2,1));
      MoveRight = new Button("Add --->");
      MoveLeft = new Button("<--- Remove");
      
      Panel rbTop = new Panel();
      rbTop.add(MoveRight);
      rBorder.add(rbTop);
      
      Panel rbBot = new Panel();
      rbBot.add(MoveLeft);
      rBorder.add(rbBot);
      pLeft.add("East", rBorder);

      leftList = new List(10);
      pLeft.add("Center", leftList);

      rightList = new List(10);
      pRight.add(rightList);

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
   //---------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Button b = (Button)e.getSource();
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
      new TwoList();
   }
}

