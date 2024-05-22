import java.awt.*;

public class visCircle extends Drawing
{
 
  public visCircle(int xpt, int ypt)
  {
     x = xpt;   y = ypt;
     w = 40;    h = 30;
     saveAsRect();
  }
  //-------------------------------------------
  public void draw(Graphics g)
  {
     g.drawArc(x, y, w, h, 0, 360);
     if(filled)
      {
      g.setColor(fillColor);
      g.fillArc(x, y, w, h, 0 ,360);
      }
     if (selected)
     {
        g.setColor(Color.black);
        g.fillRect(x+w/2, y-2, 4, 4);
        g.fillRect(x-2, y+h/2, 4, 4);
        g.fillRect(x+w/2, y+h-2, 4, 4);
        g.fillRect(x+w-2, y+h/2, 4, 4);
     }
  }
 }
//===============================================
class circleMemento extends Memento
{
   visCircle circ;
   //saved fields- remember internal fields
   //of the specified visual rectangle
   int x, y, w, h;
   public circleMemento(visCircle r)
   {
      super(r);
      circ = r;
      x = circ.x;  y = circ.y;
      w = circ.w;  h = circ.h;
   }
   //-------------------------------------------
   public void restore()
   {
      //restore the internal state of
      //the specified rectangle
      circ.x = x;  circ.y = y;
      circ.h = h;  circ.w = w;
   }
}
