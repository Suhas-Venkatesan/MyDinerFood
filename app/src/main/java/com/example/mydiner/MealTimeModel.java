package com.example.mydiner;

import java.util.ArrayList;

public class MealTimeModel {

    private String mealName;
    private int calorieBank;
    private int caloriesConsumed;
    private ArrayList<FoodModel> foodList;


    public MealTimeModel(String mealName, int caloriesConsumed, int calorieBank) {
        this.mealName = mealName;
        this.calorieBank = calorieBank;
        this.caloriesConsumed = caloriesConsumed;
        this.foodList = new ArrayList<>();
    }

    public int getCalorieBank() {
        return calorieBank;
    }

    public void setCalorieBank(int calorieBank) {
        this.calorieBank = calorieBank;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }


    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }


    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }


    public static ArrayList<MealTimeModel> createMealList() {
        ArrayList<MealTimeModel> mealList = new ArrayList<>();
        mealList.add(new MealTimeModel("Breakfast",0,500));
        mealList.add(new MealTimeModel("Lunch",0,500));
        mealList.add(new MealTimeModel("Dinner",0,500));
        mealList.add(new MealTimeModel("Snack",0,500));
        return mealList;
    }

    public ArrayList<FoodModel> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<FoodModel> foodList) {
        this.foodList = foodList;
    }
}


