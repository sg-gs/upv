package javaTest;


/**
 * class Textual.
 * 
 * @author LTP
 * @version 2020-21
 */

public class Textual extends Obra implements Structure {
    private int pages;
    private int chapters = 0;

    public Textual(String ty, String t, String[] a, int p) {
        super(ty, t, a); pages = p;
    }
    
    public Textual(String ty, String t, String[] a, int p, int m) {
        this(ty, t, a, p); chapters = m;
    }

    public String toString() {
        return super.toString() + ". Pages: " + pages;
    }
    
    public int structureUnits() 
    {
        return this.chapters;
    }
    
    public boolean isShort()
    {
        return (this.chapters < 5 || this.pages < 100);
    }
}