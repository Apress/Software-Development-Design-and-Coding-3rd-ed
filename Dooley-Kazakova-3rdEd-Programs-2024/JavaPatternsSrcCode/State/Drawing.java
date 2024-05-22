import java.awt.*;
public class Drawing
{
 protected int x, y, w, h;
 protected Rectangle rect;
 protected boolean selected;
 protected boolean filled;
 protected Color fillColor;
 
  //-------------------------------------------
  public void setSelected(boolean b)
  {
     selected = b;
  }

   public void draw(Graphics g){}
   public void move(int xpt, int ypt)
   {
      x = xpt;
      y = ypt;
   }
   public boolean contains(int x, int y)
   {
      return rect.contains(x, y);
   }
  //-------------------------------------------
  protected void saveAsRect()
  {
     rect = new Rectangle(x-w/2, y-h/2, w, h);
  }
  //-------------------------------------------
  protected void setFill(Color c)
  {
     filled = true;
     fillColor = c;
  }


}
