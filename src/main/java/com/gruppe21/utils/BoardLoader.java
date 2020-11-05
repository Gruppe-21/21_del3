package com.gruppe21.utils;

import com.gruppe21.Square;
import com.gruppe21.SquareType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Used for getting board configurations by parsing xml documents
 */
public class BoardLoader {

    public static ArrayList<Square> loadBoardFromFile(String fileName) throws ParserConfigurationException, IOException, SAXException {
        NodeList nList = getBoardNodeList(fileName);

        ArrayList<Square> squares = new ArrayList<Square>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                addXMLSquareToArrayList(squares, eElement);
            }

        }
        return squares;
    }

    private static void addXMLSquareToArrayList(ArrayList<Square> squares, Element eElement) {
        String elementName = eElement.getNodeName();
        switch (elementName) {
            case "StartSquare":
                // Add square
                squares.add(new Square("Start", "", 0, SquareType.Normal));
                break;
            case "PropertySquare":
                // Add square
                String name = eElement.getAttribute("name");
                squares.add(new Square(name, "", 0, SquareType.Normal));
                break;
            case "ChanceSquare":
                // Add square
                squares.add(new Square("Chance", "", 0, SquareType.Normal));

                break;
            case "FreeParkingSquare":
                // Add square
                squares.add(new Square("Free parking", "", 0, SquareType.Normal));


                break;
            case "GoToPrisonSquare":
                // Add square
                squares.add(new Square("Go to prison", "", 0, SquareType.Normal));


                break;
            case "PrisonSquare":
                // Add square
                squares.add(new Square("Prison / Visit prison", "", 0, SquareType.Normal));


                break;
            default:
                break;

        }
    }

    private static NodeList getBoardNodeList(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        String charSetName = "UTF-8";
        InputStream inputStream = BoardLoader.class.getResourceAsStream("/" + fileName + ".xml");
        Document doc = builder.parse(inputStream);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("board").item(0).getChildNodes();
        return nList;
    }
}