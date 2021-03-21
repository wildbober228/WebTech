package models;

import utils.Identifiable;

public class Good  extends Identifiable {
    private String goodName;
    private int goodCount;
    private float goodPrice;

    public Good() {
    }

    public Good(int id, String goodName, int goodCount, float goodPrice) {
        this.id = id;
        this.goodName = goodName;
        this.goodCount = goodCount;
        this.goodPrice = goodPrice;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }

}