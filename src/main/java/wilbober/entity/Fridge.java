package main.java.wilbober.entity;

public class Fridge extends Identifier{

    private int cost;
    private int usefulVolume;
    private String color;
    private int width;
    private int height;

    public Fridge(int id, int cost, int usefulVolume, String color, int width, int height) {
        this.cost = cost;
        this.usefulVolume = usefulVolume;
        this.color = color;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUsefulVolume() {
        return usefulVolume;
    }

    public void setUsefulVolume(int usefulVolume) {
        this.usefulVolume = usefulVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
