import java.awt.*;
import java.awt.event.*;

//illustrates use of Abstract Factory pattern
public class Gardener extends Frame
   implements ActionListener, ItemListener
{
   private checkCommand Vegie, Annual, Peren;
   private Button Center, Border, Shade, Quit;
   private Garden garden = null;
   private GardenPanel gardenPlot;
   private String borderPlant = "", centerPlant = "", shadePlant = "";

   public Gardener()
   {
      setGUI();
   }
   //----------------------------------
   private void setGUI()
   {
      setLayout(new GridLayout(1,2));
      Panel left = new Panel();
      add(left);
      Panel right= new Panel();
      add(right);

      //create label and 3 radio buttons on left side
      left.setLayout(new GridLayout(4, 1));
      left.add(new Label("Garden type"));
      CheckboxGroup grp= new CheckboxGroup();
      Vegie = new checkCommand("Vegetable", grp, new GardenMaker("Vegie", this));
      Annual = new checkCommand("Annual", grp, new GardenMaker("Annual", this));
      Peren = new checkCommand("Perennial", grp, new GardenMaker("Peren", this));
      left.add(Vegie);
      left.add(Annual);
      left.add(Peren);
      Vegie.addItemListener(this);
      Peren.addItemListener(this);
      Annual.addItemListener(this);

      //now create right side
      right.setLayout(new GridLayout(2,1));
      gardenPlot = new GardenPanel();
      Panel botRight = new Panel();
     
      right.add(gardenPlot);
      right.add(botRight);
      Center = new Button("Central");
      Border =  new Button("Border");
      Shade = new Button("Shade");
      Quit = new Button("Quit");
      botRight.add(Center);
      Center.addActionListener(this);
      botRight.add(Border);
      Border.addActionListener(this);
      botRight.add(Shade);
      Shade.addActionListener(this);
      botRight.add(Quit);
      Quit.addActionListener(this);
      setBounds(200,200, 400,300);
      setVisible(true);

    }
   //----------------------------------
   public void setGarden(Garden g)
   {
      garden = g;
      shadePlant=""; centerPlant=""; borderPlant = "";
      gardenPlot.repaint();
   }                                   
   //----------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if(obj == Center)
         setCenter();
      if(obj == Border)
         setBorder();
      if(obj == Shade)
         setShade();
      if(obj == Quit)
         System.exit(0);
   }
   //----------------------------------
   private void setCenter()
   {
      centerPlant = garden.getCenter();
      gardenPlot.repaint();
   }
   private void setBorder()
   {
      borderPlant = garden.getBorder();
      gardenPlot.repaint();
   }
   private void setShade()
   {
      shadePlant = garden.getShade();
      gardenPlot.repaint();
   }
   //----------------------------------
   public void itemStateChanged(ItemEvent e)
   {
      Command cmd = (Command)e.getSource();
      cmd.Execute();
   }
   //----------------------------------
   static public void main(String argv[])
   {
      new Gardener();
   }
   
   
//--------------------------------
class GardenPanel extends Panel
 {
   public void paint (Graphics g)
   {
      Dimension sz=getSize();
      g.setColor(Color.lightGray);
      g.fillArc( 0, 0, 80, 80,0, 360);
      g.setColor(Color.black);
      g.drawRect(0,0, sz.width-1, sz.height-1);
      g.drawString(centerPlant, 100,50);
      g.drawString( borderPlant, 75,120);
      g.drawString(shadePlant, 10,20);
   }
 }
}     //end of Gardener class
//=============================================

class GardenMaker implements Command
{
   private String garden_type;
   private Gardener gard;
   public GardenMaker(String gtype, Gardener g)
   {
      garden_type = gtype;
      gard = g;
   }
   public void Execute()
   {
      Garden gd = new VegieGarden();   //default
      if(garden_type.equals("Peren"))
           gd = new PerenGarden();
      if(garden_type.equals("Annual"))
           gd = new AnnualGarden();

      gard.setGarden(gd);
   }
}
