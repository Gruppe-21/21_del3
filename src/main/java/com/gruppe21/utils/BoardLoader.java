package com.gruppe21.utils;

import com.gruppe21.Square;
import com.gruppe21.SquareType;
import com.gruppe21.utils.xmlutils.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Used for getting board configurations by parsing xml documents
 */
public class BoardLoader {

    public static ArrayList<Square> loadBoardFromFile(String fileName) throws ParserConfigurationException, IOException, SAXException {
        Document document = XMLUtil.getXMLDocument(fileName);
        NodeList boardNodes = XMLUtil.getNodeListFromTag(document, "board");
        // NodeList cardNodes = getNodeListFromTag(doc, "cards");

        ArrayList<Square> squares = getSquaresFromNodeList(boardNodes);
        //   ArrayList<ChanceCard> chanceCards = getCardsFromNodeList(boardNodes);
        return squares;
    }

    private static ArrayList<Square> getSquaresFromNodeList(NodeList boardNodes) {
        ArrayList<Square> squares = new ArrayList<Square>();

        for (int i = 0; i < boardNodes.getLength(); i++) {
            Node node = boardNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element tag = (Element) node;
                addXMLSquareToArrayList(squares, tag);
            }
        }

        return squares;
    }

    //TODO SKAL ÆNDRES TIL TYPEN CHANCECARD NÅR DET ER IMPLEMENTERET
    private static ArrayList<String> getCardsFromNodeList(NodeList nodelist) {
        ArrayList<String> cards = new ArrayList<String>();

        for (int i = 0; i < nodelist.getLength(); i++) {
            Node nNode = nodelist.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tag = (Element) nNode;
            }

        }
        return cards;
    }

    private static void addXMLSquareToArrayList(ArrayList<Square> squares, Element tag) {
        String elementName = tag.getNodeName();
        switch (elementName) {
            case "StartSquare":
                // Add square
                squares.add(new Square("GO!", "", 0, SquareType.Normal));
                break;
            case "PropertySquare":
                // Add square
                String name = tag.getAttribute("label");
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


}
