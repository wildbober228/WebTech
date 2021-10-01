package com.wildbober.Task9;

import java.util.ArrayList;

public class Task9 {
    static Basket basket = new Basket();
    public static void addBallsToBasket(){
        Ball ball1 = new Ball(10, "Red");
        Ball ball2 = new Ball(10, "Red");
        Ball ball3 = new Ball(10, "Red");
        Ball ball4 = new Ball(10, "Red");
        Ball ball5 = new Ball(15, "Blue");
        Ball ball6 = new Ball(15, "Blue");
        Ball ball7 = new Ball(15, "Blue");
        Ball ball8 = new Ball(5, "Yellow");
        Ball ball9 = new Ball(5, "Yellow");



        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);
        basket.addBall(ball4);
        basket.addBall(ball5);
        basket.addBall(ball6);
        basket.addBall(ball7);
        basket.addBall(ball8);
        basket.addBall(ball9);

    }

    public static void resultBallsInBasket(){

        addBallsToBasket();
        System.out.println("Кол-во мячей в корзине - " + basket.getAmount());
        System.out.println("Общий вес мячей в корзине - " + basket.getWeightBasket());
        int countBlueBalls = 0;
        ArrayList<Ball> balls = basket.getBalls();
            for(int i =0; i < balls.size(); i++){
                if(balls.get(i).getColor() == "Blue"){
                    countBlueBalls++;
                }
        }
        System.out.println("Кол-во синих мячей в корзине - " + countBlueBalls);
    }
}
