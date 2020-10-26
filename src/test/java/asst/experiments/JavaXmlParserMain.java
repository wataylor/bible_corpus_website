package asst.experiments;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.io.File;

/** Read a Bible file in the standard Corpus format and print
 * all the SEG elements which define one verse of the Bible.
 * The purpose is to be abel to explore vairous aspects of the
 * Corpus format.
 * @author Material Gain
 * @since 2020 10
 *
 */
public class JavaXmlParserMain {

	/**
	 * @param args list of files to explore
	 */
	public static void main(String args[]) {
		for (int f = 0; f <args.length; f++)
			try {
				File fXmlFile = new File(args[f]);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();

				Element elem = doc.getDocumentElement();
				System.out.println("Root element: " + elem.getNodeName());
				NodeList nList = doc.getElementsByTagName("seg");
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					System.out.println("Node name :" + nNode.getNodeName() + " "
					+ nNode.getNodeType() + " "
					+ nNode.getTextContent().trim());
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						if (nNode.hasAttributes()) {
							// get attributes names and values
							NamedNodeMap nodeMap = nNode.getAttributes();
							for (int i = 0; i < nodeMap.getLength(); i++) {
								Node node = nodeMap.item(i);
								System.out.println("attr name : " + node.getNodeName() + node.getNodeValue());
							}
					} else {
						System.out.println("Not element");
					}
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}