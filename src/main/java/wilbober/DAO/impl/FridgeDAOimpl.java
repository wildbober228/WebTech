package main.java.wilbober.DAO.impl;

import main.java.wilbober.DAO.FridgeDAO;
import main.java.wilbober.entity.Fridge;
import main.java.wilbober.utils.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FridgeDAOimpl implements FridgeDAO {

    Parser parser;
    public FridgeDAOimpl() throws IOException, SAXException, ParserConfigurationException {
        parser = new Parser();
    }

    @Override
    public List<Fridge> allFridge() throws IOException, SAXException, ParserConfigurationException {
        ArrayList<Fridge> listOfFridge = parser.ParseAllFridge();
        return listOfFridge;
    }

    @Override
    public Fridge getById(int id) {
        Fridge fridge = parser.ParseFridgeById(id);
        return fridge;
    }
}
