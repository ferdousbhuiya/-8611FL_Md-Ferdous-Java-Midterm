package data_structures;

import databases.SharedStepsDatabase;

import java.sql.*;
import java.util.*;

public class UseMap {

    /**
     * INSTRUCTIONS
     * <p>
     * Implement code to demonstrate how to interact with a database connection, using a Map
     * You must insert the map into a table, and then you must submit & execute a query to retrieve
     * all the submitted data (retrieval does not need to be stored as a map - you can use any data structure)
     * <p>
     * Use For-Each loop and While-loop with Iterator to retrieve data.
     */


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_midterm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Silme123@";
    private static Object batchUpdateException;

    public static void main(String[] args) throws Exception {

        HashMap<Object, Object> map = new HashMap<>();
        map.put(8454, "lamia");
        map.put(4567, "azar");
        map.put(7898, "rahim");

        //String INSERT_USERS_SQL = "INSERT INTO test_hash_map" + " (Serial, value) VALUES " + " (?, ?);";

        // Retrieving "Keys" & "Values" using an Iterator
        Iterator<Object> mapIter = map.keySet().iterator();
        Object key;
        while (mapIter.hasNext()) {
            key = mapIter.next();
            System.out.println("KEY: " + key);
            System.out.println("VALUE: " + map.get(key));
            Object key1;

            for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
                key1 = i.next();
                System.out.println("KEY: " + key1);
                System.out.println("Value: " + map.get(key1));
            }
        }

        String tableName = "test_hash_map";
        SharedStepsDatabase sharedStepsDatabase = new SharedStepsDatabase();
        // IMPLEMENT HERE
        sharedStepsDatabase.insertMap(tableName, map);
        String sqlquery = "Select * From test_hash_map";
        System.out.println(sharedStepsDatabase.executeQueryReadAll(sqlquery));
        System.out.println(sharedStepsDatabase.executeQueryReadAllSingleColumn(sqlquery, 2));



    }
}

