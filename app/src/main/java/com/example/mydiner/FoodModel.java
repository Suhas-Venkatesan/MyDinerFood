package com.example.mydiner;

public class FoodModel {
    private String name;
    private int calories;
    private double quantity;
    private int[] macros;

    public FoodModel(String name, int calories, double quantity, int[] macros) {
        this.name = name;
        this.calories = calories;
        this.quantity = quantity;
        this.macros = macros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }



    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


    public int[] getMacros() {
        return macros;
    }


    public void setMacros(int[] macros) {
        this.macros = macros;
    }

}
