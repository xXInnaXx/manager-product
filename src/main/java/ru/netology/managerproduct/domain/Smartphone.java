package ru.netology.managerproduct.domain;

public class Smartphone extends Product {
    private String creator;

    public Smartphone(int id, String name, int price, String productBy) {
        super(id, name, price);
        this.creator = productBy;
    }

    public Smartphone(String productBy) {
        this.creator = productBy;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
