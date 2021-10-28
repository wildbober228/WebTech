package main.java.wilbober.entity;

public class Kettle extends Identifier{

    private int cost;
    private int volume;

    public Kettle(int id, int cost, int volume) {
        this.cost = cost;
        this.volume = volume;
        this.id = id;
    }

    public Kettle() {

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
