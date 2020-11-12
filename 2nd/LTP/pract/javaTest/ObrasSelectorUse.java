package javaTest;


/**
 * class ObrasSelectorUse.
 * 
 * @author LTP
 * @version 2020-21
 */

public class ObrasSelectorUse {
    public static void main(String[] args) {   
        ObrasSelector<Obra> os = new ObrasSelector<Obra>();
        String[] a = {"G. Brassard", "P. Bratley"};
        Textual b1 = new Textual("Book", "Fundamentos de Algoritmia", a, 579, 13);
        os.add(b1);
        String[] p = {"Henry Korth", "Abraham Silberschatz"};
        Textual b2 = new Textual("Book", "Fundamentos de Bases de Datos", p, 833, 17);
        os.add(b2);
        String[] q = {"Robert Eisberg", "Robert Resnick"};
        Textual b3 = new Textual("Book", "Fisica Cuantica", q, 739, 17);
        os.add(b3);
        String[] r = {"Michael Curtiz"};
        os.add(new Audiovisual("Movie", "Casablanca", r, 99));
        String[] s = {"Francis Ford Coppola"};
        os.add(new Audiovisual("Movie", "Apocalypse now", s, 148));
        String[] t = {"Bruce Springsteen"};
        os.add(new Musical("LongPlay", "Nebraska", t, 40.50, 10));
        os.add(new Musical("Song", "Nebraska", t, 4.32));
        os.add(new Musical("Song", "Atlantic City", t, 4.00));
        os.add(new Musical("Song", "Johnny 99", t, 3.43));

        //System.out.println(os);
        System.out.println(b1.structureUnits());
        System.out.println(b2.structureUnits());
        System.out.println(b3.isShort());
        System.out.println(os.structureUnits());
        System.out.println(os.isShort());
    }
}