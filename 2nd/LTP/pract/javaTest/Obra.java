package javaTest;


/**
 * class Obra.
 * 
 * @author LTP 
 * @version 2020-21
 */

public abstract class Obra {
    private String title;
    private String[] authors;
    private String type;
    
    public Obra(String ty, String t, String[] a) {
        title = t; authors = a; type = ty;
    }
       
    public String toString() {        
        return type + " ('" + title + "', [" + Util.concatenation(authors) + "])"; 
    }
}