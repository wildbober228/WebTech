package com.wildbober.Task5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task5 {

    static int[] array;
    static LinkedList<Integer> sourceArray = new LinkedList<Integer>();
    static int countItemsToDelete = 0;


    public static int fillArray(int[] _array){
        array = _array;

        for (int i =0; i < array.length; i ++){
            sourceArray.add(array[i]);
        }
        int first = checkArrayRight();

        countItemsToDelete = 0;
        sourceArray.clear();

        for (int i =0; i < array.length; i ++){
            sourceArray.add(array[i]);
        }
        int second = checkArrayLeft();

        if (first > second)
            return second;
        if (first < second)
            return first;
        return first;
    }

    private static int checkArrayRight(){
        for(int i =0; i < sourceArray.size()-1; i ++){
            if(sourceArray.get(i) > sourceArray.get(i+1)){
                sourceArray.remove(i+1);
                countItemsToDelete++;
                checkArrayRight();
            }
        }
        return countItemsToDelete;
    }

    private static int checkArrayLeft(){
        for(int i =0; i < sourceArray.size()-1; i ++){
            if(sourceArray.get(i) > sourceArray.get(i+1) && countItemsToDelete < 8){
                sourceArray.remove(i);
                countItemsToDelete++;
                checkArrayLeft();
            }
        }
        return countItemsToDelete;
    }

}
