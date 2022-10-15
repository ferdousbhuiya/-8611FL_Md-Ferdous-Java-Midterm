package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** INSTRUCTIONS
 * This XML Reader class is used to parse the XML documents contained within this package. You must also implement the
 * given method at the bottom of the class.
 *
 * If you don't know what XML is... Look it up! You can expect to see a lot of XML very soon
 */

public class XmlReader {

    public List<Student> parseData(String tagName, String path) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(path);

        Document doc = builder.parse(file);
        NodeList nodeList = doc.getDocumentElement().getChildNodes();

        List<Student> list = new ArrayList<>();
        Student student;
        Node node;
        Node cNode;
        NodeList childNodes;
        String content;
        String data;

        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (node instanceof Element) {
                student = new Student();
                student.id = node.getAttributes().getNamedItem(tagName).getNodeValue();
                childNodes = node.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        content = cNode.getLastChild().getTextContent().trim();
                        data = cNode.getNodeName();
                        switch (data) {
                            case "firstName":
                                student.firstName = content;
                                break;
                            case "lastName":
                                student.lastName = content;
                                break;
                            case "score":
                                student.score = convertIntToChar(content);
                                break;
                        }
                    }
                }
                list.add(student);
            }
        }
        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("student");
        System.out.println();
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Student ID : " + eElement.getAttribute("id"));
                System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Score : " + convertIntToChar( eElement.getElementsByTagName("score").item(0).getTextContent())) ;
            }
        }
        return list;




    }

    // You must implement this method
    public char convertIntToChar(String score) {
        char grade = ' ';
        int scr = Integer.parseInt(score);
        if (scr <= 100 && scr >= 90) {
            grade = 'A';
        }
        if (scr <= 89 && scr >= 80) {
            grade = 'B';
        }
        if (scr <= 79 && scr >= 50) {
            grade = 'C';
        }

        return grade;
    }

}