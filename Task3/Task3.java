package com.wildbober.Task3;

public class Task3 {

    public static void calculate(float h, float a, float b){
        float x;
        for (float i = a; i <= b; i+=h){
        x = (float) Math.tan(i);
        System.out.println("tg("+i+") = " + x);
        }
    }
}
