package com.wildbober.Task8;

public class Task8 {
    public static void checkTwoArrays(){ //z8
        int[] mas1 = { 1,2,3,5,7,8,10};
        int[] mas2 = { 1,2,3,4,6,8,10};

        for (int i = 0; i < mas1.length; i++) {
            if(i==0){
                if(mas1[i] >= mas2[i])
                    System.out.print("1:1");
            }else {
                System.out.println("");
                for (int j = 0; j < mas1.length; j++)
                    if(mas1[i] >= mas2[j] && mas1[i-1] <= mas2[j])
                        System.out.print((i+1) + ":" + (j+1) + " ");
            }
        }
    }
}
