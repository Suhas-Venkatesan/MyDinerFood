package com.example.mydiner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvFood;
    RecyclerView rvMeals;
    LayoutInflater factory;
    View entryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
        rvMeals = findViewById(R.id.rvmeal);
        factory = getLayoutInflater();
        entryView = factory.inflate(R.layout.diaryrow, null);
        rvFood = entryView.findViewById(R.id.foodlist);


        // Initialize meals of the day (Breakfast,lunch,etc.)
        ArrayList<MealTimeModel> meals = MealTimeModel.createMealList();
        // Create adapter passing in the meals
        MealTimeAdapter adapter = new MealTimeAdapter(meals);
        // Attach the adapter to the RecyclerView to populate items
        rvMeals.setAdapter(adapter);
        // Set layout manager to position the items
        rvMeals.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<FoodModel> food = new ArrayList<>();
        food.add(new FoodModel("Pizza",150,1.0, new int[]{20,3,45}));
        // Create adapter passing in the meals
       /* FoodAdapter adapter1 = new FoodAdapter(food);
        // Attach the adapter to the RecyclerView to populate items
        rvFood.setAdapter(adapter1);
        // Set layout manager to position the items
        rvFood.setLayoutManager(new LinearLayoutManager(this));
*/
    }
}
