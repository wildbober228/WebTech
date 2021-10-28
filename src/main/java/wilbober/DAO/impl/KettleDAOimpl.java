package main.java.wilbober.DAO.impl;

import main.java.wilbober.DAO.KettleDAO;
import main.java.wilbober.entity.Fridge;
import main.java.wilbober.entity.Kettle;
import main.java.wilbober.utils.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KettleDAOimpl implements KettleDAO {

    Parser parser;

    public KettleDAOimpl() throws IOException, SAXException, ParserConfigurationException {
        parser = new Parser();
    }

    @Override
    public List<Kettle> allKettle() throws IOException, SAXException, ParserConfigurationException {
        ArrayList<Kettle> listOfKettle = parser.ParseAllKettle();
        return listOfKettle;
    }

    @Override
    public Kettle getById(int id) {
        Kettle kettle = parser.ParseKettleById(id);
        return kettle;
    }
}
