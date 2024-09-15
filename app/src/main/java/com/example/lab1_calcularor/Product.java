package com.example.lab1_calcularor;

public class Product {
    private int id;
    private String name;
    private boolean check;

    public Product(int id, String name, boolean check) {
        this.id = id;
        this.name = name;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
