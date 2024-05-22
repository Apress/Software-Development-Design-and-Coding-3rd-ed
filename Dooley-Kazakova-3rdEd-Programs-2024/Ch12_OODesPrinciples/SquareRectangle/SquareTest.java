/**
 * class SquareTest
 */
public class SquareTest {

    public static void main(String [] args) {
        Rectangle r;
        Square s;
        
        r = new Rectangle(4, 8);
        s = new Square(5);
        
        System.out.printf("Rectangle: width = %5.0f height = %5.0f\n",
                r.getWidth(), r.getHeight());
        
        System.out.printf("Square: width = %5.0f, height = %5.0f\n\n", 
                s.getWidth(), s.getHeight());
        
        myFunc(r, 16);
        myFunc(s, 32);
        
        System.out.printf("Rectangle: width = %5.0f height = %5.0f\n",
                r.getWidth(), r.getHeight());
                
        System.out.printf("Square: width = %5.0f, height = %5.0f\n", 
                s.getWidth(), s.getHeight());
                
        myFunc2(r);
        System.out.printf("myFunc2 using Square");
        myFunc2(s);
        
        System.out.printf("\n-----------\n");
    }
    
    public static void myFunc(Rectangle r, double newWidth) {
        r.setWidth(newWidth);
    }
    
    public static void myFunc2(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        assert ((r.getWidth() * r.getHeight()) == 20) : "Assert fails";
    }      
}
