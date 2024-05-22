import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Imager extends JPanel implements Chain
{
   private Chain nextChain;
   private Image img;
   private boolean loaded;

 public Imager()
 {
      super();            
      loaded = false;
      setBorder(new BevelBorder(BevelBorder.RAISED));
 }
//------------------------------------------
public void addChain(Chain c)
{
   nextChain = c;    //next in chain of resp
}
//------------------------------------------
public void sendToChain(String mesg)
{
   //if there is a JPEG file with this root name
   //load it and display it.
   if (findImage(mesg))
      loadImage(mesg+".jpg");
   else
   //Otherwise, pass request along chain
   nextChain.sendToChain(mesg);
}
//------------------------------------------
public Chain getChain()
{
   return nextChain;
}          
//------------------------------------------
public void paint(Graphics g)
{
   if (loaded) 
      {
      g.drawImage(img, 0, 0, this);
      }
}
//------------------------------------------
private void loadImage(String file)
{
   loaded = false;
   MediaTracker tracker = new MediaTracker(this);
   img = Toolkit.getDefaultToolkit().getImage(file);
   tracker.addImage(img, 0);     //watch for image loading

   //this begins actual image loading
   try{
      tracker.waitForID(0,1);
   }
   catch(InterruptedException e){}
 loaded = true;
 validate();
 repaint();
}
//------------------------------------------
private boolean findImage(String file)
{
   XFile xfile = null;

   File dir = new File(System.getProperty("user.dir"));
   boolean found = false;
   String files[] = dir.list();
   int i = 0; 
   while ((! found) && (i < files.length))
     {   
      xfile = new XFile(files[i]);
      found = xfile.matchRoot(file);
      if (!found) 
         i++;
      }
   if(found)
      {
      return xfile.matchName(file+".jpg");
      }
   else
      return found;     //false
 }
}
