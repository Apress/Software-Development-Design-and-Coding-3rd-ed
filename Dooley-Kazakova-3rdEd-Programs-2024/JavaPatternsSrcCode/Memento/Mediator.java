import java.awt.*;
import java.util.*;
//swing classes
import com.sun.java.swing.text.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.border.*;
import com.sun.java.swing.tree.*;

public class Mediator
{
   boolean startRect;
   boolean rectSelected;
   Vector drawings;
   Vector undoList;
   RectButton rect;
   JPanel canvas;
   visRectangle selectedRectangle;

public Mediator()
{
   startRect = false;
   rectSelected = false;
   drawings = new Vector();
   undoList = new Vector();
}
//-------------------------------------------
public void startRectangle()
{
   startRect = true;
}
//-------------------------------------------
public void createRect(int x, int y)
{              
   unpick();   //make sure no rectangle is selected
   if(startRect)  //if rect button is depressed
   {
   Integer count = new Integer(drawings.size());
   undoList.addElement(count);   //Save previous drawing list size
   visRectangle v = new visRectangle(x, y);
   drawings.addElement(v);       //add new element to list
   startRect = false;            //done with this rectangle
   rect.setSelected(false);      //unclick button
   canvas.repaint();
   }
   else
      pickRect(x, y); //if not pressed look for rect to select
   }
//-------------------------------------------
public void registerRectButton(RectButton rb)
{
   rect = rb;
}
//-------------------------------------------
public void registerCanvas(JPanel p)
{
   canvas = p;
}
//-------------------------------------------
private void unpick()
{
   rectSelected = false;
   if(selectedRectangle != null)
   {
      selectedRectangle.setSelected(false);
      selectedRectangle = null;
      repaint();
   }
}
//-------------------------------------------
public void rememberPosition()
{
   if(rectSelected){
   Memento m = new Memento(selectedRectangle);
   undoList.addElement(m);
   }
}
//-------------------------------------------
public void pickRect(int x, int y)
{                                                          
   //save current selected rectangle to avoid double save of undo
   visRectangle lastPick = selectedRectangle;
   unpick();
   for(int i=0; i<drawings.size(); i++)
   {
    visRectangle v = (visRectangle)drawings.elementAt(i);
    if(v.contains(x,y))    //did click inside a rectangle
    {
       selectedRectangle = v; //save it
       rectSelected = true;
       if(selectedRectangle != lastPick)  //but don't save twice
         rememberPosition();
    
       v.setSelected(true);   //turn on handles
       repaint();             //and redraw
    }
   }
}                   
//-------------------------------------------
public void clear()
{
 drawings = new Vector();
 undoList = new Vector();
 rectSelected = false;
 selectedRectangle = null;
 repaint();
}
//-------------------------------------------
private void repaint()
{
   canvas.repaint();
}
//-------------------------------------------
public void drag(int x, int y)
{
 if(rectSelected)
 {
  if(selectedRectangle.contains(x, y))
   {
      selectedRectangle.move(x,y);
      repaint();
   }
 }
}
//-------------------------------------------
public void reDraw(Graphics g)
{
   g.setColor(Color.black);
   for (int i=0; i< drawings.size(); i++) 
      {
      visRectangle v = (visRectangle)drawings.elementAt(i);
      v.draw(g);
      }
}
//-------------------------------------------
public void undo()
{
   if(undoList.size()>0)
   {
      //get last element in undo list
      Object obj = undoList.lastElement();
      undoList.removeElement(obj);   //and remove it
      //if this is an Integer, the last action was a new rectangle
      if (obj instanceof Integer)    
      {   
         //remove last created rectangle
         Object drawObj = drawings.lastElement();
         drawings.removeElement(drawObj);
      }
      //if this is a Memento, the last action was a move
      if(obj instanceof Memento)
      {
         //get the Memento
         Memento m = (Memento)obj;
         m.restore();     //and restore the old position
      }
     repaint();
   }
 }
}
