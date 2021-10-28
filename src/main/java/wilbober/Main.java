package main.java.wilbober;

import main.java.wilbober.entity.Fridge;
import main.java.wilbober.entity.Kettle;
import main.java.wilbober.services.KettleService;
import main.java.wilbober.services.impl.FridgeServiceImpl;
import main.java.wilbober.services.impl.KettleServiceImpl;
import main.java.wilbober.utils.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        KettleServiceImpl kettleService = new KettleServiceImpl();
        FridgeServiceImpl fridgeService = new FridgeServiceImpl();
        ArrayList<Fridge> listOfFridge = (ArrayList<Fridge>) fridgeService.allFridge();

        System.out.println("Список всех чайников: ");
        ArrayList<Kettle> listOfKettle = (ArrayList<Kettle>) kettleService.allKettle();

        for(int i =0; i < listOfKettle.size(); i++){
            Kettle kettle = listOfKettle.get(i);
            System.out.println("Чайник номер "+ kettle.getId());
            System.out.println("Цена "+ kettle.getCost());
            System.out.println("Обьем "+ kettle.getVolume());
            System.out.println("--------------");
        }

        System.out.println("Самый дешевый товар");

        Kettle kettleMin = listOfKettle.get(0);
        for(int i =1; i < listOfKettle.size(); i++){
            Kettle kettle = listOfKettle.get(i);
            if(kettle.getCost() < kettleMin.getCost()){
                kettleMin = kettle;
            }
        }
        int minCostKettle = kettleMin.getCost();

        Fridge fridgeMin = listOfFridge.get(0);
        for(int i =1; i < listOfFridge.size(); i++){
            Fridge fridge = listOfFridge.get(i);
            if(fridge.getCost() < fridgeMin.getCost()){
                fridgeMin = fridge;
            }
        }
        int minCostFridge = fridgeMin.getCost();


        if(minCostKettle > minCostFridge){
            System.out.println("Холодильник номер " + fridgeMin.getId());
            System.out.println("цена " + minCostFridge);
        } else if(minCostKettle < minCostFridge) {
            System.out.println("Чайник номер " + kettleMin.getId());
            System.out.println("цена " + minCostKettle);
        } else {
            System.out.println("Холодильник номер " + fridgeMin.getId());
            System.out.println("цена " + minCostFridge);
            System.out.println("Чайник номер " + kettleMin.getId());
            System.out.println("цена " + minCostKettle);
        }


    }
}
