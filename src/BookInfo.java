import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookInfo {
    public static void main(String[] args) {
        try {
            // Create a new Scanner object to get user input
            Scanner input = new Scanner(System.in);
            System.out.print("Enter book ID: ");
            String bookID = input.nextLine();
            input.close();
            // Load the XML file and create a Document object
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            // Get all book elements from the XML file
            NodeList nodeList = doc.getElementsByTagName("book");
            // Loop through each book element to find the one with the specified ID
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getAttribute("id").equals(bookID)) {
                        // Print the book information if the ID matches
                        System.out.println("Book ID: " + element.getAttribute("id"));
                        System.out.println("Author: " + element.getElementsByTagName("author").item(0).getTextContent());
                        System.out.println("Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                        System.out.println("Genre: " + element.getElementsByTagName("genre").item(0).getTextContent());
                        System.out.println("Price: " + element.getElementsByTagName("price").item(0).getTextContent());
                        System.out.println("Publish Date: " + element.getElementsByTagName("publish_date").item(0).getTextContent());
                        System.out.println("Description: " + element.getElementsByTagName("description").item(0).getTextContent());

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
