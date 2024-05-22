public class CircleState extends State
{
   private Mediator med;        //save Mediator
   public CircleState(Mediator md)
   {
      med = md;
   }
   //Draw circle where mouse clicks
   public void mouseDown(int x, int y)
   {
     med.addDrawing(new visCircle(x, y));
   }
}
