package com.wildbober.Task7;

import java.io.Console;

public class Task7 {

    static int[] array = {4,6,2,4,8,3,2,4,66,33,11,234};

    private static void showArray(int mass[]){

        for(int i = 0; i < mass.length; i++){
            System.out.print(mass[i] + " ");
        }

    }

    private static void shellSort(int mass[])
    {
        int i, j, step;
        int tmp;
        int n = mass.length;
        for (step = n / 2; step > 0; step /= 2)
            for (i = step; i < n; i++)
            {
                tmp = mass[i];
                for (j = i; j >= step; j -= step)
                {
                    if (tmp < mass[j - step])
                        mass[j] = mass[j - step];
                    else
                        break;
                }
                mass[j] = tmp;
            }
    }

    public static void checkResults(){
        showArray(array);
        shellSort(array);
        System.out.println(" ");
        showArray(array);
        System.out.println(" ");

    }

}
