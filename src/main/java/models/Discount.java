package models;

import utils.Identifiable;

public class Discount extends Identifiable {
    private int amountDiscount;

    public Discount(){

    }

    public Discount(int id, int amountDiscount){
        this.id = id;
        this.amountDiscount = amountDiscount;
    }

    public int getAmountDiscount(){
        return amountDiscount;
    }

    public void setAmountDiscount(int amountDiscount){
        this.amountDiscount = amountDiscount;
    }
}
