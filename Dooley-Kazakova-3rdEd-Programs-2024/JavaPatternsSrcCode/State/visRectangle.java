import java.awt.*;

public class visRectangle extends Drawing
{
 
  public visRectangle(int xpt, int ypt)
  {
     x = xpt;   y = ypt;
     w = 40;    h = 30;
     saveAsRect();
  }
  //-------------------------------------------
  public void draw(Graphics g)
  {
     g.drawRect(x, y, w, h);
     if(filled)
     {
        g.setColor(fillColor);
        g.fillRect(x,y,w,h);
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
class rectMemento extends Memento
{
   visRectangle rect;
   //saved fields- remember internal fields
   //of the specified visual rectangle
   int x, y, w, h;
   public rectMemento(visRectangle r)
   {
      super(r);
      rect = r;
      x = rect.x;  y = rect.y;
      w = rect.w;  h = rect.h;
   }
   //-------------------------------------------
   public void restore()
   {
      //restore the internal state of
      //the specified rectangle
      rect.x = x;  rect.y = y;
      rect.h = h;  rect.w = w;
   }
}
