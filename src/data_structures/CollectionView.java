package data_structures;

import java.util.HashMap;
import java.util.Set;

public class CollectionView {

    /** INSTRUCTIONS
     *
     * A map is given to you below, with some data inserted into it.
     *
     * Retrieve the Collection view of the values present in map
     */

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(5, "San Jose");
        map.put(6, "Seattle");
        map.put(2, "LA");
        map.put(4, "Boston");
        map.put(1, "NYC");
        map.put(3, "Denver");

        Set<Integer> set = map.keySet();
        System.out.println("set :"+ set +"\n");

        System.out.println("-----------------------");
        System.out.println("Key "+" | " + "Values");
        System.out.println("-----------------------");

        for(Integer key: set)
        {
            String value = map.get(key);
            System.out.println(key + "    | "+value);
        }

    }

}
