import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ColorImage extends JPanel
        implements Chain      
{
private Chain nextChain;
//-----------------------------------
public ColorImage()
{
   super();
   setBorder(new LineBorder(Color.black));
}
//-----------------------------------
public void addChain(Chain c)
{
   nextChain = c;
}
//-----------------------------------
public void sendToChain(String mesg)
{
 Color c = getColor(mesg);
 if(c != null)
   {
   setBackground(c);
   repaint();
   }
 else
 {
    if (nextChain != null) 
       nextChain.sendToChain(mesg);
 }
}
//-----------------------------------
private Color getColor(String mesg)
{
   String lmesg = mesg.toLowerCase();
   Color c = null;

   if(lmesg.equals("red"))
      c = Color.red;
   if(lmesg.equals("blue"))
      c = Color.blue;
   if(lmesg.equals("green"))
      c= Color.green;
   return c;
}
//-----------------------------------
public Chain getChain()
{
   return nextChain;
}


}
