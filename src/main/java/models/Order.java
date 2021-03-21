package models;

import utils.Identifiable;

import java.util.Date;

public class Order extends Identifiable {
    private Date date;
    private int FK_customer;
    private int FK_good;

    Order(){

    }


    public Order(int id, int FK_customer, int FK_good, Date date) {
        this.id = id;
        this.date = date;
        this.FK_customer = FK_customer;
        this.FK_good = FK_good;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFK_customer() {
        return FK_customer;
    }

    public void setFK_customer(int FK_customer) {
        this.FK_customer = FK_customer;
    }

    public int getFK_good() {
        return FK_good;
    }

    public void setFK_good(int FK_good) {
        this.FK_good = FK_good;
    }
}
