import java.awt.*;
import java.awt.event.*;

//illustrates use of Abstract Factory pattern
public class Gardener extends Frame
   implements ActionListener, ItemListener
{
   private Checkbox Vegie, Annual, Peren;
   private Button Center, Border, Shade, Quit;
   private Garden garden = null;
   private GardenPanel gardenPlot;
   private String borderPlant = "", centerPlant = "", shadePlant = "";

   public Gardener()
   {
      super("Garden planner");
      setGUI();
   }
   //----------------------------------
   private void setGUI()
   {
      setBackground(Color.lightGray);
      setLayout(new GridLayout(1,2));
      Panel left = new Panel();
      add(left);
      Panel right= new Panel();
      add(right);

      //create label and 3 radio buttons on left side
      left.setLayout(new GridLayout(4, 1));
      left.add(new Label("Garden type"));
      CheckboxGroup grp= new CheckboxGroup();
      Vegie = new Checkbox("Vegetable", grp, false);
      Annual = new Checkbox("Annual", grp, false);
      Peren = new Checkbox("Perennial", grp, false);
      left.add(Vegie);
      left.add(Annual);
      left.add(Peren);
      Vegie.addItemListener(this);
      Peren.addItemListener(this);
      Annual.addItemListener(this);

      //now create right side
      right.setLayout(new GridLayout(2,1));
      gardenPlot = new GardenPanel();
      gardenPlot.setBackground(Color.white);
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
      if(garden != null) centerPlant = garden.getCenter().getName();
      gardenPlot.repaint();
   }
   private void setBorder()
   {
      if(garden != null) borderPlant = garden.getBorder().getName();
      gardenPlot.repaint();
   }
   private void setShade()
   {
      if(garden != null) shadePlant = garden.getShade().getName();
      gardenPlot.repaint();
   }
   //----------------------------------
   public void itemStateChanged(ItemEvent e)
   {
      Checkbox ck = (Checkbox)e.getSource();
      garden = new GardenMaker().getGarden(ck.getLabel());
      shadePlant=""; centerPlant=""; borderPlant = "";
      gardenPlot.repaint();
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
      g.drawString(centerPlant, 100, 50);
      g.drawString( borderPlant, 75, 120);
      g.drawString(shadePlant, 10, 40);
   }
 }
}     //end of Gardener class
//=============================================

class GardenMaker 
{
 //Abstract Factory which returns one of three gardens  
   private Garden gd;
   
   public Garden getGarden(String gtype)
   {
      gd = new VegieGarden();   //default
      if(gtype.equals("Perennial"))
           gd = new PerennialGarden();
      if(gtype.equals("Annual"))
           gd = new AnnualGarden();
      return gd;
   }
   
}
