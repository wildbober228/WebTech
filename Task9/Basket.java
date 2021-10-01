package com.wildbober.Task9;

import java.util.ArrayList;

public class Basket {

    ArrayList<Ball> balls = new ArrayList<>();
    int amount;
    int weightBasket;



    public Basket(){

    }


    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
        amount++;
        weightBasket += ball.getWeight();
    }

    public int getWeightBasket() {
        return weightBasket;
    }

    public int getAmount() {
        return amount;
    }


}
