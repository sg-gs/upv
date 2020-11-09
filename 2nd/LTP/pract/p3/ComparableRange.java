package practica3;

/**
 * Write a description of interface ComparableRange here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ComparableRange extends Comparable<Figure>
{
   int compareToRange(Figure o);
}
