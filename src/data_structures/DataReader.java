package data_structures;

import java.io.*;
import java.sql.*;


public class DataReader {

    /**
     * INSTRUCTIONS
     * <p>
     * Create an API to read the .txt file and print it to the console.
     * HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     * <p>
     * Store and retrieve the file to/from a database table.
     * <p>
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     * <p>
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sql_text";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Silme123@";

   // private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String DB_URL = "jdbc:mysql://localhost:3306/sql_text";
   // private static final String USERNAME = "root";
    //private static final String PASSWORD = "Silme123@";


    //MYSQLJDBC.driver=com.mysql.cj.jdbc.Driver
   // MYSQLJDBC.host=jdbc:mysql://localhost/java_midterm?serverTimezone=UTC&useSSL=false
   // MYSQLJDBC.userName=root
   // MYSQLJDBC.password=Test210!

    public static void main(String[] args) throws SQLException, IOException {
        String textFilePath = "JavaMidterm/src/data_structures/data/self-driving-car";
        DataReader dataReader = new DataReader();
        dataReader.storeFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader(textFilePath));
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
        private void storeFile () {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            FileReader fileReader = null;
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                String s1 = "INSERT INTO TextFile (Serial, Text)VALUES(?,?)";
                preparedStatement = connection.prepareStatement(s1);
                File file = new File("JavaMidterm/src/data_structures/data/self-driving-car");
                fileReader = new FileReader(file);

                preparedStatement.setInt(1, 49);
                preparedStatement.setCharacterStream(2, fileReader);
                int numberOfRowsInserted = preparedStatement.executeUpdate();
                System.out.println("Number of Rows Inserted : " + numberOfRowsInserted);

        } catch (SQLException | ClassNotFoundException | FileNotFoundException se) {
            se.printStackTrace();
        }
    }

}