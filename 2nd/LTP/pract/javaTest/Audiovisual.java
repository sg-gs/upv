package javaTest;


/**
 * class Audiovisual.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Audiovisual extends Obra {
    private double duration; // it stores minutes
 
    public Audiovisual(String type, String t, String[] a, double d) {
        super(type, t, a); duration = d;
    }

    public String toString() {
        return super.toString() + ". Duration: " + duration;
    }
}