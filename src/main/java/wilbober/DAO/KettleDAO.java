package main.java.wilbober.DAO;

import main.java.wilbober.entity.Fridge;
import main.java.wilbober.entity.Kettle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface KettleDAO {

    List<Kettle> allKettle() throws IOException, SAXException, ParserConfigurationException;
    Kettle getById(int id);

}
