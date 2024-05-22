import java.awt.event.*;
import com.sun.java.swing.*;
import com.sun.java.swing.event.*;
import com.sun.java.swing.text.*;
import com.sun.java.swing.border.*;
import com.sun.java.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Chainer extends JxFrame
{
   //list of chain members
   Sender sender;    //gets commands
   Imager imager;    //displays images
   FileList fileList;  //highlights file names
   ColorImage colorImage;  //shows colors
   RestList restList;  //shows rest of list
//--------------------------------------
   public Chainer()
   {
   super("Chain demo");
   JPanel jp = new JPanel();
   jp.setBorder(new EmptyBorder(5,5,5,5));
   getContentPane().add(jp);
   jp.setLayout(new GridLayout(1,3));
   JPanel left = new JPanel();
   jp.add(left);
   left.setLayout(new GridLayout(2,1));

   //create send panel and image display panel
   sender = new Sender();
   imager = new Imager();
   left.add(imager);
   left.add(sender);
   
   //create file list and color panels
   JPanel mid = new JPanel();
   jp.add(mid);
   mid.setBorder(new EmptyBorder(5,5,5,5));
   mid.setLayout(new GridLayout(2,1));
   fileList = new FileList();

   colorImage = new ColorImage();
   mid.add(fileList);
   mid.add(colorImage);

   //put list for rest of commands in right panel
   restList = new RestList();
   jp.add(restList);

   //set up the chain of responsibility
   sender.addChain(imager);
   imager.addChain(colorImage);
   colorImage.addChain(fileList);
   fileList.addChain(restList);

   //set up visual shape
   setSize(new Dimension(500,300));
   setVisible(true);
   
   }
//-----------------------------------------
   static public void main(String argv[])
   {
      new Chainer();
   }

}
