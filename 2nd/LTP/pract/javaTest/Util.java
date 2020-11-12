package javaTest;


/**
 * class Util.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Util {
    public static String concatenation(String[] a) {
        String s = "";
        for (int i = 0; i <= a.length - 2; i++) {  s += a[i] + ", "; }
        s += a[a.length - 1];
        return s;
    }
}
