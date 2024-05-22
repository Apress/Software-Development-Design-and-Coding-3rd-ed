import java.awt.*;
import java.awt.event.*;

public class noCmd extends Frame
   implements ActionListener
{
   Menu mnuFile;
   MenuItem mnuOpen, mnuExit;
   Button btnRed;
   Panel p;
   //-----------------------------------------
   public noCmd()
   {
      super("Frame without commands");
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new MenuItem("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new MenuItem("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      btnRed=new Button("Red");
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
      Object obj = e.getSource();
      if(obj == mnuOpen)
         fileOpen();
      if (obj == mnuExit) 
         exitClicked();
      if (obj == btnRed)
         redClicked();
   }
   //-----------------------------------------
   private void exitClicked()
   {
      System.exit(0);
   }
   //-----------------------------------------
   private void fileOpen()
   {
      FileDialog fDlg = new FileDialog(this, "Open a file", FileDialog.LOAD);
      fDlg.show();
   }
   //-----------------------------------------
   private void redClicked()
   {
      p.setBackground(Color.red);
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new noCmd();
   }
}

