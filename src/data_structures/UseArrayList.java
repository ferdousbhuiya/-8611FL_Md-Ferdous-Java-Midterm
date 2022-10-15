package data_structures;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UseArrayList {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sql_text";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Silme123@";

    /** INSTRUCTIONS
     *
     * Demonstrate how to use an ArrayList that includes using the add, peek, remove & retrieve methods.
     * Use For-Each loop and While-loop with Iterator to retrieve the data.
     *
     * Store and retrieve the data from/to a database table.
     */

    public static void main(String[] args) {

        //Adding data to the ArrayList.
        //Uses of add

        ArrayList<String>lis = new ArrayList<>();
        lis.add("How");
        lis.add("Are");
        lis.add("You?");
        lis.add("I");
        lis.add("am");
        lis.add("fine.");
        System.out.println(lis);

        System.out.println("=======******************++++++++++++");
        // Uses of remove, to remove the element from the ArrayList of index 3.
        //It will remove 'I', which is in index 3

        lis.remove(3);

        System.out.println(lis);
        System.out.println("=======******************++++++++++++");



        // Uses of For-each loop
        // It will print the array element. This will no need any iteration process.
        lis.add(3,"I"); // it will add again in its right position.
        for (String str:lis)
        {
            System.out.println(str);
        }
        System.out.println("=======******************++++++++++++");



        // uses of iteration for retrieving the data from the ArrayList
        //This will show the same result as the For-each loop
        for (int i=0; i<lis.size(); i++)
        {
            System.out.println(lis.get(i));
        }

        UseArrayList useArrayList = new UseArrayList();
        useArrayList.storeFile();
    }

    private void storeFile () {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        FileReader fileReader = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String s1 = "INSERT INTO Arralist (Serial, Text)VALUES(?,?)";
            preparedStatement = connection.prepareStatement(s1);

            int numberOfRowsInserted = preparedStatement.executeUpdate();
            System.out.println("Number of Rows Inserted : " + numberOfRowsInserted);

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

}
