import java.util.*;

/**
 * ShapeTest - test the Shape interface implementations.
 * 
 * @author fred 
 * @version 1.0
 */
public class ShapeTest {

    public static void main(String [] args) {
        ArrayList<Shape> figures = new ArrayList<Shape>();
        
       // figures.add(new Rectangle(10, 20));
       // figures.add(new Circle(10));
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(5.0, 1.0);
        Point p3 = new Point(3.0, 8.0);
        figures.add(new Triangle(p1, p2, p3));
        
        Iterator<Shape> iter = figures.iterator();
        
        while (iter.hasNext()) {
            Shape nxt = iter.next();
            System.out.printf("area = %12.4f perimeter = %12.4f\n", 
                nxt.computeArea(), nxt.computePerimeter());
        }
    }
}
