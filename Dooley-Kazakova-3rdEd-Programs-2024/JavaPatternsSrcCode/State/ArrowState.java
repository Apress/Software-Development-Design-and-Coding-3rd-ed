import java.util.*;
public class ArrowState extends State
{
   private Mediator med;
   public  ArrowState(Mediator md)
   {
      med = md;
   }

   public void mouseDown(int x, int y)
   {
      Vector drawings = med.getDrawings();
      for(int i=0; i<drawings.size(); i++)
      {
         Drawing d = (Drawing)drawings.elementAt(i);
         if(d.contains(x,y))
            med.setSelected(d);
      }
   }
}
