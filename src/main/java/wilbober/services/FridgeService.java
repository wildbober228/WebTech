package main.java.wilbober.services;

import main.java.wilbober.entity.Fridge;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface FridgeService {

    List<Fridge> allFridge() throws IOException, SAXException, ParserConfigurationException;
    Fridge getById(int id);

}
