package data_structures;

import databases.SharedStepsDatabase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    /**
     * INSTRUCTIONS
     * <p>
     * Demonstrate how to use Queue that includes add, peek, remove & poll methods.
     * Use For-Each loop and While-Loop with Iterator to retrieve data.
     * <p>
     * Store and retrieve data from/to a database table.
     */


    public static void main(String[] args) throws Exception {





        Queue<String> queue = new LinkedList<String>();


        //Use of add, that add the element in the list.
        queue.add("Ferdous");
        queue.add("Hasan");
        queue.add("Saeed");
        queue.add("Zakariya");
        queue.add("Tayeeb");

        System.out.println("Output after use 'add' :" + queue); //Output is : [Ferdous, Hasan, Saeed, Zakariya, Tayeeb]

        System.out.println("++++++++++++++++++++++++");
// offer will add more element to the previous list.
        queue.offer("Khadija");
        queue.offer("Tabassum");
        queue.offer("Aqsa");
        queue.offer("Mary");
        queue.offer("Nusrat");

        System.out.println("Output after use 'offer' :" + queue); //Output is : [Ferdous, Hasan, Saeed, Zakariya, Tayeeb, Khadija, Tabassum, Aqsa, Mary, Nusrat]
        System.out.println("====================");
// remove will remove the items from the list.
        queue.remove("Khadija");
        queue.remove("Tabassum");


        System.out.println("Output after use 'remove' :" + queue); // output is : [Ferdous, Hasan, Saeed, Zakariya, Tayeeb, Aqsa, Mary, Nusrat]
        System.out.println("====================");


        System.out.println("Output after use 'peek' :" + queue.peek()); // It will give the first element of the array
        System.out.println("====================");

// Remove the head of this queue. It will remove first item from the list.
        queue.poll();
        queue.poll();

        System.out.println("Output after use 'poll' :" + queue);
        System.out.println("====================");

        System.out.println("Output of For-Each loop as below :");

        for (String nam : queue) {
            System.out.println(nam);
        }

        System.out.println("====================");

        System.out.println("Output of Iterator loop as below :");

        // Use iterator for retrieving data
        String value = null;
        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext())
            value = (String) iterator.next();
        System.out.println(value);

        SharedStepsDatabase sharedStepsDatabase = new SharedStepsDatabase();
        sharedStepsDatabase.insertString("test_insert_string", "test_string", "Hello! How are you? I am fine");
        System.out.println(sharedStepsDatabase.executeQueryReadAllSingleColumn("SELECT * FROM TEST_INSERT_STRING", 2).get(0));



    }
}