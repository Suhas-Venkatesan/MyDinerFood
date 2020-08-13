package com.example.mydiner;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Console;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<FoodModel> foodList;
    int mExpandedPosition = -1;

    public FoodAdapter(List<FoodModel> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.foodentry, viewGroup, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, final int position) {
        FoodModel food = foodList.get(position);
        holder.foodName.setText(food.getName());
        /*final boolean isExpanded = position==mExpandedPosition;
        holder.itemView.setVisibility(isExpanded?View.GONE:View.VISIBLE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(position);
                Log.d("This has"," been clicked!");
            }
        });*/
    }



    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;

        FoodViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.food_name);
        }
    }
}
