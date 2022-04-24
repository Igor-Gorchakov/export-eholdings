package com.techprimers.springbatchexample1.batch.model;

public class EHoldingsPackage {
    private int id;
    private String name;

    public EHoldingsPackage(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
