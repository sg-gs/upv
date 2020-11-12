package p3;

import java.util.*;

/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;
    
    public void add(Figure f) { figuresList[numF++] = f; }
    
    
    // public void add(Figure f) {
    //    if(!found(f)) figuresList[numF++] = f;
    //}
    
    public List<Figure> orderedList(){
        List<Figure> l = new ArrayList<Figure>();
        if(numF > 0) l.add(figuresList[0]);
        for(int i = 1; i < numF; i++){
            int j = l.size() - 1;
            while(j >= 0 && figuresList[i].compareTo(l.get(j)) < 0){
                j--;
            }
            l.add(j + 1, figuresList[i]);
        }
        
        return l;
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }
    
    public boolean equals(Object o) {
        if(o instanceof FiguresGroup){
            FiguresGroup g = (FiguresGroup) o;
            return included(g);
        } 
        return false;
    }

    private boolean found(Figure f) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {
    for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }
    
    public double area() {
        double totalArea = 0;
        for(int i = 0; i < numF; i++) {
            totalArea += figuresList[i].area();
        }
        return totalArea;
    }
    
    public Figure greatestFigure() {
        if(numF == 0) return null;
        Figure f = figuresList[0];
        for(int i = 0; i < numF; i++) {
            if(figuresList[i].area() > f.area()){
                f = figuresList[i];
            }
        }
        return f;
    }
    
    public void print(char c) {
        for(int i = 0; i < numF; i++) {
            figuresList[i].print(c);
            System.out.println();
        }
    }
}