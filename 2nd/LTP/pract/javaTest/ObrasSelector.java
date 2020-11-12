package javaTest;

import java.util.ArrayList;

/**
 * class ObrasSelector.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class ObrasSelector<T extends Obra> extends ArrayList<T> implements Structure  {
   
    public String toString() {
        String s = "";
        for (int i = 0; i < size(); i++) s += get(i) + "\n";
        return s;
    }
    
    public int structureUnits() 
    {
        Obra o;
        int totalStructureUnits = 0;
        for(int i = 0; i < size(); i++)
        {
            o = get(i);
            if (o instanceof Structure)
            {
                Structure s = (Structure) o;
                totalStructureUnits += s.structureUnits();
            }
        }
        return totalStructureUnits;
    }
    
    public boolean isShort()
    {
        return (structureUnits() < 5);
    }
}