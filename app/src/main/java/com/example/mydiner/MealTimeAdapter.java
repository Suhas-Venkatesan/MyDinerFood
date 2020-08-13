package com.example.mydiner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealTimeAdapter extends RecyclerView.Adapter<MealTimeAdapter.ItemViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<MealTimeModel> mealList;
    int mExpandedPosition = -1;

    public MealTimeAdapter(List<MealTimeModel> itemList) {
        this.mealList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diaryrow, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, final int position) {
        MealTimeModel meal = mealList.get(position);
        itemViewHolder.mealName.setText(meal.getMealName());
        itemViewHolder.calories.setText("500");

        /*final boolean isExpanded = position==mExpandedPosition;
        itemViewHolder.itemView.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        itemViewHolder.itemView.setActivated(isExpanded);
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
                Log.d("This has"," been clicked!");
            }
        });*/
        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                itemViewHolder.rvSubItem.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(meal.getFoodList().size());

        // Create sub item view adapter
        FoodAdapter subItemAdapter = new FoodAdapter(meal.getFoodList());

        itemViewHolder.rvSubItem.setLayoutManager(layoutManager);
        itemViewHolder.rvSubItem.setAdapter(subItemAdapter);
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mealName;
        private TextView calories;
        private RecyclerView rvSubItem;

        ItemViewHolder(View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.meal_name);
            calories = itemView.findViewById(R.id.meal_cals);
            rvSubItem = itemView.findViewById(R.id.foodlist);
        }
    }}