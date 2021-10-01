package com.wildbober.Task4;

public class Task4 {

    static int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19,20,21};

    public static void checkArray(){

        for (int i =0; i < array.length; i++){
            int k =0;
            for (int j =1; j < array.length-1; j++){
                if (array[i] % array[j] == 0){
                    k++;
                    continue;
                }
            }
            if(k == 1)
            System.out.println("Простое число - " + array[i]);
        }
    }

}
