public class RectState extends State
{
   private Mediator med;     //save the Mediator here
   public RectState(Mediator md)
   {
      med = md;
   }
   //create a new Rectangle where mode clicks
   public void mouseDown(int x, int y)
   {
      med.addDrawing(new visRectangle(x, y));
   }
}
