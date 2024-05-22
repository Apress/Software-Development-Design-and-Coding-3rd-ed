import java.awt.*;
import java.awt.event.*;

public class extrnCommand extends Frame
   implements ActionListener
{
   Menu mnuFile;
   fileOpenCommand mnuOpen;
   fileExitCommand mnuExit;
   btnRedCommand btnRed;
   Panel p;
   Frame fr;
   //-----------------------------------------
   public extrnCommand()
   {
      super("Frame with external commands");
      fr = this;     //save frame object
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new fileOpenCommand("Open...", this);
      mnuFile.add(mnuOpen);
      mnuExit = new fileExitCommand("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      p = new Panel();
      add(p);
      btnRed = new btnRedCommand("Red", p);
      
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
      new extrnCommand();
   }
}
//==========================================
class btnRedCommand extends Button implements Command
   {
   Panel p;
      public btnRedCommand(String caption, Panel pnl)
      {
         super(caption);
         p = pnl;
      }
      public void Execute()
      {
         p.setBackground(Color.red);
      }
   }
   //------------------------------------------
   class fileOpenCommand extends MenuItem implements Command
   {
      Frame fr;
      public fileOpenCommand(String caption, Frame frm)
      {
         super(caption);
         fr = frm;
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



