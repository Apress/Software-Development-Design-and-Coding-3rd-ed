import java.awt.*;
import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;

public class RestList extends JawtList
        implements Chain
{
   private Chain nextChain = null;
   public RestList()
   {
   super(10);     //arg to JawtList
   setBorder(new LineBorder(Color.black));
   }
public void addChain(Chain c)
{
   nextChain = c;
}
public void sendToChain(String mesg)
{ 
   add(mesg);        //this is the end of the chain
   repaint();
   if(nextChain != null)
      nextChain.sendToChain(mesg);
}
public Chain getChain()
{
   return nextChain;
}

}        
