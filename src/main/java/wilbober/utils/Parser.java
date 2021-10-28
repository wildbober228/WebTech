package main.java.wilbober.utils;

import main.java.wilbober.entity.Fridge;
import main.java.wilbober.entity.Kettle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    DocumentBuilder documentBuilder;
    Document document;

    public Parser() throws ParserConfigurationException, IOException, SAXException {
        documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = documentBuilder.parse("ShopCatalog.xml");

    }

    public ArrayList<Kettle> ParseAllKettle() {
        ArrayList<Kettle> listKettle = new ArrayList<>();
        Node root = document.getDocumentElement();
        NodeList items = root.getChildNodes();
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            if (item.getNodeName() == "Kettle")
                if (item.getNodeType() != Node.TEXT_NODE) {
                    NodeList itemProps = item.getChildNodes();
                    int id = 0;
                    int cost = 0;
                    int volume = 0;
                    for (int j = 0; j < itemProps.getLength(); j++) {
                        Node itemProp = itemProps.item(j);

                        if (itemProp.getNodeType() != Node.TEXT_NODE) {

                            if (itemProp.getNodeName() == "id") {
                                id = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "cost") {
                                cost = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "volume") {
                                volume = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }

                            //System.out.println(itemProp.getNodeName() + ":" + itemProp.getChildNodes().item(0).getTextContent());

                        }

                    }
                    //System.out.println("===========>>>>");
                    Kettle kettle = new Kettle(id, cost, volume);
                    listKettle.add(kettle);
                }

        }

        return listKettle;
    }

    public Kettle ParseKettleById(int idToFind) {
        Node root = document.getDocumentElement();
        NodeList items = root.getChildNodes();
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            if (item.getNodeName() == "Kettle")
                if (item.getNodeType() != Node.TEXT_NODE) {
                    NodeList itemProps = item.getChildNodes();
                    int id = 0;
                    int cost = 0;
                    int volume = 0;
                    for (int j = 0; j < itemProps.getLength(); j++) {
                        Node itemProp = itemProps.item(j);

                        if (itemProp.getNodeType() != Node.TEXT_NODE) {

                            if (itemProp.getNodeName() == "id") {
                                id = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "cost") {
                                cost = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "volume") {
                                volume = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }

                            //System.out.println(itemProp.getNodeName() + ":" + itemProp.getChildNodes().item(0).getTextContent());

                        }

                    }
                    //System.out.println("===========>>>>");
                    Kettle kettle = new Kettle(id, cost, volume);
                    if(idToFind == id)
                        return kettle;
                }

        }

        return null;
    }

    public ArrayList<Fridge> ParseAllFridge() {
        ArrayList<Fridge> listFridge = new ArrayList<>();
        Node root = document.getDocumentElement();
        NodeList items = root.getChildNodes();
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            if (item.getNodeName() == "Fridge")
                if (item.getNodeType() != Node.TEXT_NODE) {
                    NodeList itemProps = item.getChildNodes();
                    int id = 0;
                    int cost = 0;
                    int usefulVolume = 0;
                    String color = "";
                    int width = 0;
                    int height = 0;
                    for (int j = 0; j < itemProps.getLength(); j++) {
                        Node itemProp = itemProps.item(j);

                        if (itemProp.getNodeType() != Node.TEXT_NODE) {

                            if (itemProp.getNodeName() == "id") {
                                id = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "cost") {
                                cost = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "usefulVolume") {
                                usefulVolume = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "color") {
                                color = itemProp.getChildNodes().item(0).getTextContent();
                            }
                            if (itemProp.getNodeName() == "width") {
                                width = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "height") {
                                height = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }

                            //System.out.println(itemProp.getNodeName() + ":" + itemProp.getChildNodes().item(0).getTextContent());

                        }

                    }
                    //System.out.println("===========>>>>");
                    Fridge fridge = new Fridge(id, cost, usefulVolume, color, width, height);
                    listFridge.add(fridge);
                }

        }

        return listFridge;
    }

    public Fridge ParseFridgeById(int idToFind) {
        Node root = document.getDocumentElement();
        //System.out.println();
        NodeList items = root.getChildNodes();
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            if (item.getNodeName() == "Fridge")
                if (item.getNodeType() != Node.TEXT_NODE) {
                    NodeList itemProps = item.getChildNodes();
                    int id = 0;
                    int cost = 0;
                    int usefulVolume = 0;
                    String color = "";
                    int width = 0;
                    int height = 0;
                    for (int j = 0; j < itemProps.getLength(); j++) {
                        Node itemProp = itemProps.item(j);

                        if (itemProp.getNodeType() != Node.TEXT_NODE) {

                            if (itemProp.getNodeName() == "id") {
                                id = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "cost") {
                                cost = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "usefulVolume") {
                                usefulVolume = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "color") {
                                color = itemProp.getChildNodes().item(0).getTextContent();
                            }
                            if (itemProp.getNodeName() == "width") {
                                width = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }
                            if (itemProp.getNodeName() == "height") {
                                height = Integer.parseInt(itemProp.getChildNodes().item(0).getTextContent());
                            }

                            //System.out.println(itemProp.getNodeName() + ":" + itemProp.getChildNodes().item(0).getTextContent());

                        }

                    }
                    //System.out.println("===========>>>>");
                    Fridge fridge = new Fridge(id, cost, usefulVolume, color, width, height);
                    if(idToFind == id)
                        return fridge;
                }

        }

        return null;
    }


}
