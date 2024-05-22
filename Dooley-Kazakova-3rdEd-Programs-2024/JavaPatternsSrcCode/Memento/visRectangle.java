import java.awt.*;

public class visRectangle
{
 int x, y, w, h;
 Rectangle rect;
 boolean selected;
 
  public visRectangle(int xpt, int ypt)
  {
     x = xpt;   y = ypt;
     w = 40;    h = 30;
     saveAsRect();
  }
  //-------------------------------------------
  public void setSelected(boolean b)
  {
     selected = b;
  }
  //-------------------------------------------
  private void saveAsRect()
  {
     rect = new Rectangle(x-w/2, y-h/2, w, h);
  }
 //-------------------------------------------
  public void draw(Graphics g)
  {
     g.drawRect(x, y, w, h);
     if (selected)
     {
        g.fillRect(x+w/2, y-2, 4, 4);
        g.fillRect(x-2, y+h/2, 4, 4);
        g.fillRect(x+w/2, y+h-2, 4, 4);
        g.fillRect(x+w-2, y+h/2, 4, 4);
     }
  }
  //-------------------------------------------
  public boolean contains(int x, int y)
  {
     return rect.contains(x, y);
  }
  //-------------------------------------------
  public void move(int xpt, int ypt)
  {
     x = xpt; y = ypt;
     saveAsRect();
  }
}
//===============================================
class Memento
{
   visRectangle rect;
   //saved fields- remember internal fields
   //of the specified visual rectangle
   int x, y, w, h;
   public Memento(visRectangle r)
   {
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
