/**
 * class Triangle.
 * 
 * @version 0.1
 */
public class Triangle implements Shape {
    private Point v1, v2, v3;
    private double a;
    private double b;
    private double c;

    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        a = Math.sqrt((Math.pow(v2.getX() - v1.getX(), 2)) + (Math.pow(v2.getY() - v1.getY(), 2)));
        b = Math.sqrt((Math.pow(v3.getX() - v2.getX(), 2)) + (Math.pow(v3.getY() - v2.getY(), 2)));
        c = Math.sqrt((Math.pow(v3.getX() - v1.getX(), 2)) + (Math.pow(v3.getY() - v1.getY(), 2)));
        System.out.printf("a = %12.6f b = %12.6f c = %12.6f\n", a, b, c);
    }

    /**
     * compute the Area of the triangle from the lengths
     * using Heron's formula
     */
    public double computeArea() {
        double s = (a + b + c) / 2.0;
        System.out.println("s = " + s);
        double m = s * (s - a) * (s - b) * (s - c);
        System.out.println("m = " + m);
        double area = Math.sqrt(m);
        System.out.println("area = " + area);
        return area;
    }
    
    public double computePerimeter() {
        return a + b + c;
    }
}
