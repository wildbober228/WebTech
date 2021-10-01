package com.wildbober.Task1;

public class Task1 {


    public static float calculate(float x, float y){
        float result = 0;

        result = (float) (1 + Math.sin(x+y))/(2+Math.abs(x - (2*x)/(1+x*x*y*y)))+x;

        return  result;
    }
}
