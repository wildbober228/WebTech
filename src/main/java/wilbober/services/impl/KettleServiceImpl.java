package main.java.wilbober.services.impl;

import main.java.wilbober.DAO.KettleDAO;
import main.java.wilbober.DAO.impl.KettleDAOimpl;
import main.java.wilbober.entity.Kettle;
import main.java.wilbober.services.KettleService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class KettleServiceImpl implements KettleService {

    KettleDAO kettleDAO;

    public KettleServiceImpl() throws ParserConfigurationException, SAXException, IOException {
        kettleDAO = new KettleDAOimpl();
    }

    @Override
    public List<Kettle> allKettle() throws IOException, SAXException, ParserConfigurationException {
        return kettleDAO.allKettle();
    }

    @Override
    public Kettle getById(int id) {
        return kettleDAO.getById(id);
    }
}
