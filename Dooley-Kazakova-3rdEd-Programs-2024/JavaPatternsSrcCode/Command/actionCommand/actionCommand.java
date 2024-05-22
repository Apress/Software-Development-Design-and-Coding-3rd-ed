import java.awt.*;
import java.awt.event.*;

public class actionCommand extends Frame
{
   Menu mnuFile;
   MenuItem mnuOpen, mnuExit;
   Button btnRed;
   Panel p;
   Frame fr;
   //-----------------------------------------
   public actionCommand()
   {
      super("Frame without commands");
      fr = this;        //sae cop of this frame
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new MenuItem("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new MenuItem("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(new fileOpen());
      mnuExit.addActionListener(new fileExit());
      
      btnRed=new Button("Red");
      p = new Panel();
      add(p);
      p.add(btnRed);

      btnRed.addActionListener(new btnRed());
      setBounds(100,100,200,100);
      setVisible(true);
   }
   
   //-----------------------------------------
   private void exitClicked()
   {
      System.exit(0);
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new actionCommand();
   }
   //=====----====--inner classes---=====----
   class fileOpen implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         FileDialog fDlg = new FileDialog(fr, "Open a file", FileDialog.LOAD);
         fDlg.show();
      }
   }
   //-------------------------------------
   class btnRed implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          p.setBackground(Color.red);
      }
   }
   //-------------------------------------
   class fileExit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}
//=====================================


