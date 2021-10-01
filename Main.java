package com.wildbober;
import com.wildbober.Task1.Task1;
import com.wildbober.Task2.Task2;
import com.wildbober.Task3.Task3;
import com.wildbober.Task4.Task4;
import com.wildbober.Task5.Task5;
import com.wildbober.Task6.Task6;
import com.wildbober.Task7.Task7;
import com.wildbober.Task8.Task8;
import com.wildbober.Task9.Task9;

public class Main {

    public static void main(String[] args) {
        System.out.println("***************************************");
	    System.out.println("Task_1 = ");
        System.out.println(Task1.calculate(10,5));

        System.out.println("***************************************");
        System.out.println("Task_2 = ");
        System.out.println(Task2.checkPosition(3,-5));

        System.out.println("***************************************");
        System.out.println("Task_3 = ");
        Task3.calculate(0.5f, 5,10);

        System.out.println("***************************************");
        System.out.println("Task_4 = ");
        Task4.checkArray();

        System.out.println("***************************************");
        System.out.println("Task_5 = ");
        int[] array = {74,58,2,69,30,50,39,94,88};
        int count = Task5.fillArray(array);
        System.out.println("наименьшее число K элементов, которые можно выкинуть из ");
        for(int i =0; i < array.length; i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println("последовательности, равно = " + count);

        System.out.println("***************************************");
        System.out.println("Task_9 = ");
        Task9.resultBallsInBasket();

        System.out.println("***************************************");
        System.out.println("Task_6 = ");
        Task6.fillMatrix();

        System.out.println("***************************************");
        System.out.println("Task_7 = ");
        Task7.checkResults();

        System.out.println("***************************************");
        System.out.println("Task_8 = ");
        Task8.checkTwoArrays();
        System.out.println("***************************************");
    }


}

