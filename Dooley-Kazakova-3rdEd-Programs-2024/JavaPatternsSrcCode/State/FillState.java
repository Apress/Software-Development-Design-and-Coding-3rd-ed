import java.awt.*;
import java.util.*;
public class FillState extends State
{
   private Mediator med;   //save Mediator
   private Color color;    //save current color
   public FillState(Mediator md)
   {
      med = md;
   }
   //Fill drawing if selected
   public void select(Drawing d, Color c)
   {
      color = c;
       if(d!= null)
         {
         d.setFill(c);  //fill that drawing
         }
   }
   //Fill drawing if you click inside one
   public void mouseDown(int x, int y)
   {
      Vector drawings = med.getDrawings();
      for(int i=0; i< drawings.size(); i++)
      {
         Drawing d = (Drawing)drawings.elementAt(i);
         if(d.contains(x, y))
            d.setFill(color); //fill drawing
      }
   }
}
