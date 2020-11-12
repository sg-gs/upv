package javaTest;


/**
 * class Musical.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Musical extends Obra {    
    private double duration; // mm.ss format
    private int tracks = 1;  // number of tracks, songs, themes...

    public Musical(String ty, String t, String[] a, double d) {
        super(ty, t, a); duration = d;
    }
    
    public Musical(String ty, String t, String[] a, double d, int n) {
        this(ty, t, a, d); tracks = n;
    }

    public String toString() {
        return super.toString() + ". Duration: " + duration;
    }
}