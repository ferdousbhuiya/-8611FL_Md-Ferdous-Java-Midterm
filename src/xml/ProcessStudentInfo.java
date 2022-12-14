package xml;


import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import databases.SharedStepsDatabase;
import org.xml.sax.SAXException;


public class ProcessStudentInfo {

    /** INSTRUCTIONS
     * Take a look at the XmlReader class, found within this package. Try to understand what the parseData() method
     * is doing. This is essential to figuring out how to implement the remainder of this exercise.
     *
     * In that XmlReader class, you need to implement the method called "convertIntToChar()" which should convert the
     * student number scores into corresponding letter grades:
     * 90 - 100 = 'A'
     * 80 - 89  = 'B'
     * 70 - 79  = 'C'
     *
     * Here, in the main method, extend the code that is written and meant to get you started. You must parse the
     * students' information contained within the XML files into 2 separate ArrayList's (One for Selenium students and
     * the other for QTP Students) and then store those lists into the provided HashMap
     *
     * Then, you must use a combination of an iterator and a while-loop to print out the stored data.
     * Your output should be formatted EXACTLY like the example below:
     * ......................................................
     * Student ID: 1
     * First Name: Ibrahim
     * Last Name:  Khan
     * GRADE:      B
     *
     * Student ID: 2
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      A
     *
     * Student ID: 3
     * First Name: Asif
     * Last Name:  Roni
     * GRADE:      C
     * ......................................................
     *
     * Finally, you must store all student data into a database table, called `selenium_students`
     * Use any database (MongoDB, Oracle MySQL, PostgreSQL) to store and retrieve data.
     *
     **/

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException {

        // To get you started, your system's abs path has been initialized and some add'l variables have been declared
        String systemPath = System.getProperty("user.dir");
        String seleniumDocRelativePath;
        String qtpDocRelativePath;
        String seleniumDocPath= "src/xml/data/selenium.xml";
        String qtpDocPath = "src/xml/data/qtp.xml";
        String tag = "id";

        /*
         Here is a map that you'll be using to store 2 lists. One will contain Selenium students, the other will
         contain QTP students
         */
        Map<String, List<Student>> studentMap = new LinkedHashMap<String, List<Student>>();

        // Implement the rest below, as per the instructions

        XmlReader xmlReader = new XmlReader();
        System.out.println("qtp Student list:");
        xmlReader.parseData(tag,qtpDocPath );
        System.out.println("\n");
        System.out.println("Selenium Student:");
        List<Student> listOfselnmStd = new ArrayList<>();
        for (Student x : xmlReader.parseData(tag, seleniumDocPath))
        {
            listOfselnmStd.add(x);
        }

        Map<Object, Object> StudentSlnm = new HashMap<>();
        for (Student s : listOfselnmStd) {
            StudentSlnm.put(s.lastName, s.score);
        }
        System.out.println("\n");
        SharedStepsDatabase sharedStepsDatabase = new SharedStepsDatabase();

        sharedStepsDatabase.insertMap("StudentOfSelenium", StudentSlnm);
        String query = "SELECT * FROM StudentOfSelenium";
        //System.out.println(sharedStepsDatabase.executeQueryReadAll(query));

    }
}
