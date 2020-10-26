package asst.experiments;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** Dump an arbitrary xml file and report on its content.  Adapted from 
 * https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
 * @author Material gain
 * @since 2020 10n
 */
public class ReadAnyXmlFile {

	static int depth = 0;

	/** Print any XML file
	 * @param args one file
	 */
	public static void main(String[] args) {

		try {
			File file = new File("F:\\git\\bible-corpus\\bibles\\English.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			deppIt("Root element :" + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printNote(NodeList nodeList) {
		depth++;

		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				deppIt("Name =" + tempNode.getNodeName() + " [OPEN]"
						+ tempNode.getTextContent() + "<");
				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						deppIt("attr name : " + node.getNodeName() + node.getNodeValue());
					}
				}

				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}
				deppIt("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}
		}
		depth--;
	}

	static void deppIt(String msg) {
		for (int i=0; i<= depth; i++) System.out.print(" ");
		System.out.println(msg);
	}
}
/* Specific XML file, a program to parse it based on its fixed structure,
 * and the sample output.

<?xml version="1.0"?>
<company>
    <staff id="1001">
        <firstname>yong</firstname>
        <lastname>mook kim</lastname>
        <nickname>mkyong</nickname>
        <salary>100000</salary>
    </staff>
    <staff id="2001">
        <firstname>low</firstname>
        <lastname>yin fong</lastname>
        <nickname>fong fong</nickname>
        <salary>200000</salary>
    </staff>
</company>

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static void main(String argv[]) {
    try {
    File fXmlFile = new File("/Users/mkyong/staff.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("staff");
    System.out.println("----------------------------");

    for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            System.out.println("Staff id : "
                               + eElement.getAttribute("id"));
            System.out.println("First Name : "
                               + eElement.getElementsByTagName("firstname")
                                 .item(0).getTextContent());
            System.out.println("Last Name : "
                               + eElement.getElementsByTagName("lastname")
                                 .item(0).getTextContent());
            System.out.println("Nick Name : "
                               + eElement.getElementsByTagName("nickname")
                                 .item(0).getTextContent());
            System.out.println("Salary : "
                               + eElement.getElementsByTagName("salary")
                                 .item(0).getTextContent());
        }
    }
    } catch (Exception e) {
    e.printStackTrace();
    }
  }
}

----------------
Root element :company
---------------

Current Element :staff
Staff id : 1001
First Name : yong
Last Name : mook kim
Nick Name : mkyong
Salary : 100000

Current Element :staff
Staff id : 2001
First Name : low
Last Name : yin fong
Nick Name : fong fong
Salary : 200000
*/