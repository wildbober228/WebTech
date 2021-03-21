package models;

import utils.Identifiable;

public class Customer extends Identifiable {
    private String name;
    private String surName;

    private Discount discount;
    private int FK_discount;

    Customer(){

    }

    public Customer(int id, String name, String surName, int FK_discount, Discount discount) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.FK_discount = FK_discount;
        this.discount = discount;
    }

    public Customer(int id, String name, String surName, int FK_discount) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.FK_discount = FK_discount;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurName(String surName){
        this.surName = surName;
    }

    public String getSurName(){
        return surName;
    }

    public Discount getDiscount(){
        return discount;
    }

    public void setDiscount(Discount discount){
        this.discount = discount;
    }

    public int getDiscountFK(){
        return FK_discount;
    }

    public void setDiscountFK(int FK_discount){
        this.FK_discount = FK_discount;
    }
}
