package p3;

import java.lang.Math;

public class Rectangle extends Figure implements ComparableRange, Printable
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
    

    public int compareToRange(Figure f) {
        double areasSum = f.area() + this.area();
        double areasDiff = Math.abs(f.area() - this.area());
        
        if(areasDiff <= (0.1 * areasSum)) {
            return 0;
        } else {
            return this.compareTo(f);
        }
    }
    
    public void print(char c) {
        int b = (int) this.base;
        int h = (int) this.height;
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < b; j++){
                System.out.print(c);
            }
            System.out.println();
        }
        
    }
}
