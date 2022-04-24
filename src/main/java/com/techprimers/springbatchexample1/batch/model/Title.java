package com.techprimers.springbatchexample1.batch.model;

public class Title {
    private int id;
    private String name;

    public Title(int id, String name) {
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
        return "Title{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
