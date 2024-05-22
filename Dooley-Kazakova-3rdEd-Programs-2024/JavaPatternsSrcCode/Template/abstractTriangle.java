import java.awt.*;
public abstract class Triangle
{
  Point p1, p2, p3; 
  public Triangle(Point a, Point b, Point c)
  {
     p1 = a; p2 = b; p3 = c;
  }
  public void draw(Graphics g)
  {
     drawLine(g, p1, p2);
     Point current = draw2ndLine(g, p2, p3);
     closeTriangle(g, current);
  }
  public void drawLine(Graphics g, Point a, Point b)
  {
     g.drawLine(a.x, a.y, b.x, b.y);
  }
  abstract public Point draw2ndLine(Graphics g, Point a, Point b);
  public void closeTriangle(Graphics g, Point c)
  {
     g.drawLine(c.x, c.y, p1.x, p1.y);
  }

}
