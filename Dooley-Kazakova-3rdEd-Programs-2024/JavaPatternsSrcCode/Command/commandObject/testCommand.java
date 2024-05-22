import java.awt.*;
import java.awt.event.*;

public class testCommand extends Frame
   implements ActionListener
{
   Menu mnuFile;
   fileOpenCommand mnuOpen;
   fileExitCommand mnuExit;
   btnRedCommand btnRed;
   Panel p;
   Frame fr;
   //-----------------------------------------
   public testCommand()
   {
      super("Frame without commands");
      fr = this;     //save frame object
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new fileOpenCommand("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new fileExitCommand("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      btnRed = new btnRedCommand("Red");
      p = new Panel();
      add(p);
      p.add(btnRed);

      btnRed.addActionListener(this);
      setBounds(100,100,200,100);
      setVisible(true);
   }
   //-----------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Command obj = (Command)e.getSource();
      obj.Execute();
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new testCommand();
   }
   //====----====-----inner class----=====----
   class btnRedCommand extends Button implements Command
   {
      public btnRedCommand(String caption)
      {
         super(caption);
      }
      public void Execute()
      {
         p.setBackground(Color.red);
      }
   }
   //------------------------------------------
   class fileOpenCommand extends MenuItem implements Command
   {
      public fileOpenCommand(String caption)
      {
         super(caption);
      }
      public void Execute()
      {
         FileDialog fDlg=new FileDialog(fr,"Open file");
         fDlg.show();
      }
   }
   //-------------------------------------------
   class fileExitCommand extends MenuItem implements Command
   {
      public fileExitCommand(String caption)
      {
         super(caption);
      }
      public void Execute()
      {
         System.exit(0);
      }
   }
}
//==========================================


