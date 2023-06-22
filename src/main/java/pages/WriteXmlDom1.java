package pages;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;





	public class WriteXmlDom1 {

	    public static void main(String[] args)
	            throws ParserConfigurationException, TransformerException {

	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	        // root elements
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("company");
	        doc.appendChild(rootElement);
	        
	        Element name = doc.createElement("name");
	        //name.appendChild(doc.createTextNode("pp"));
	        rootElement.appendChild(name);

	        Element name2 = doc.createElement("name2");
	        name2.appendChild(doc.createTextNode("pp2"));
	        Node channelNode = doc.getElementsByTagName("name").item(0);
	        channelNode.appendChild(name2);
	        
	        Element name3 = doc.createElement("name3");
	        name3.appendChild(doc.createTextNode("pp3"));
	        rootElement.appendChild(name3);
	     
	        
	      
	        //...create XML elements, and others...

	        // write dom document to a file
	        try (FileOutputStream output =
	                     new FileOutputStream("c:\\test\\staff-dom.xml")) {
	            writeXml(doc, output);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    // write doc to output stream
	    private static void writeXml(Document doc,
	                                 OutputStream output)
	            throws TransformerException {
	    	

	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("c:\\test\\staff-dom.xml"));

	        transformer.transform(source, result);

	    }
	}


