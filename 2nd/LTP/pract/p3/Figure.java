package practica3;


/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2020-21
 */

public abstract class Figure implements Comparable<Figure>, Printable {
    private double x;
    private double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    
    public abstract double area();
    public int compareTo(Figure fig) {
       if(this.area() == fig.area()){
           return 0;
       } else if(this.area() < fig.area()){
           return -1;
       } else {
           return 1;
       }
    }
    
    public void print(char c) {}
}