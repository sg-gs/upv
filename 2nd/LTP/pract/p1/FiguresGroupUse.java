package p1;


/**
 * class FiguresGroupUse.
 * 
 * @author LTP 
 * @version 2020-21
 */
public class FiguresGroupUse {
    public static void main(String[] args) {
        // FiguresGroup g = new FiguresGroup();
        //g.add(new Circle(10, 5, 3.5));
        //g.add(new Triangle(10, 5, 6.5, 32));
        //System.out.println(g);
        testFiguresEquals();
    }
    
    public static void testFiguresEquals() {
        
        System.out.println(new Rectangle(10, 5, 6.5, 32).area());
        System.out.println(new Circle(10, 5, 3.5).area());
        System.out.println(new Triangle(10, 5, 6.5, 32).area());
        
       
        FiguresGroup g1 = new FiguresGroup();
        g1.add(new Rectangle(10, 5, 6.5, 32));
        g1.add(new Circle(10, 5, 3.5));
        g1.add(new Circle(10, 5, 3.5));
        g1.add(new Triangle(10, 5, 6.5, 32));
        g1.add(new Triangle(10, 5, 6.5, 32));
        
        FiguresGroup g2 = new FiguresGroup();
        g1.add(new Rectangle(10, 5, 6.5, 32));
        g2.add(new Circle(10, 5, 3.5));
        g2.add(new Triangle(10, 5, 6.5, 32));
        
        FiguresGroup g3 = new FiguresGroup();
        g3.add(new Rectangle(10, 5, 7, 31));
        g3.add(new Circle(10, 5, 3.5));
        g3.add(new Triangle(10, 5, 6.5, 32));
        
        System.out.println("g1 equals g2: " + g1.equals(g2));
        System.out.println("g1 equals g3: " + g1.equals(g3));
        
        System.out.println("TOTAL AREAS");
        System.out.println("g1 AREA " + g1.area());
        System.out.println("g2 AREA " + g2.area());
        System.out.println("g3 AREA: " + g3.area());
        
        System.out.println("g3 greatest figure: " + g3.greatestFigure());
        
    }
}