package p1;
public class Rectangle extends Figure
{
    private double base; 
    private double height;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double x, double y, double b, double h)
    {
        super(x, y);
        base = b;
        height = h;
    }
    
    public boolean equals(Object o) {
        if(super.equals(o) && (o instanceof Rectangle)) {
            Rectangle r = (Rectangle) o;
            return height == r.height && base == r.base;
        }
        return false;
    }

    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }

    public double area () {
        return base * height;
    }
}
