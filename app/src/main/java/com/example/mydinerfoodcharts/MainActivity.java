package com.example.mydinerfoodcharts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;
    BarChart sodiumChart;
    BarChart calorieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        /* An example of a day's worth of macros*/
        ArrayList<PieEntry> values = new ArrayList<>();
        values.add(new PieEntry((float) 23.9, "Total Fats"));
        values.add(new PieEntry((float) 29, "Total Carbs"));
        values.add(new PieEntry((float) 33.6, "Protein"));

        PieDataSet dataSet = new PieDataSet(values, "Macro Nutrients");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLUE);
        pieChart.setData(data);

        /* Supplying Data to Sodium Bar Chart*/
        sodiumChart = (BarChart)findViewById(R.id.sodiumbarchart);
        /* Pass in the meals arraylist as a parameter*/
        setSodiumData();

        /* Supplying data to the weekly calorie bar chart*/
        calorieChart = (BarChart)findViewById(R.id.calorieBarChart);
        /* pass in an arraylist of meal lists, one for each day of the current week.
        * Also pass in the daily calorie goal which is set by the user.*/
        int dailyCalorieGoal = 1500;
        setCalorieData(dailyCalorieGoal);

    }

    private void setSodiumData(){
        /* Use the meals array to calculate the total amount of sodium and add value to the values arraylist*/
        ArrayList<BarEntry> values = new ArrayList<>();
        /* Adding 3000mg of sodium as an example for a day*/
        values.add(new BarEntry(0f, 3000f));
        BarDataSet barDataSet = new BarDataSet(values, "Today's Sodium Level");
        barDataSet.setBarBorderWidth(0.9f);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.3f);
        XAxis xAxis = sodiumChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);


        String[] label = new String[]{"Sodium"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(label);


        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        LimitLine recommendedLevel = new LimitLine(2300f, "Recommended Level");
        recommendedLevel.setLineWidth(1f);
        recommendedLevel.setTextSize(10f);
        recommendedLevel.setLineColor(Color.BLACK);
        sodiumChart.getAxisRight().setDrawGridLines(false);
        sodiumChart.getAxisLeft().setDrawGridLines(false);
        sodiumChart.getXAxis().setDrawGridLines(false);
        sodiumChart.getAxisLeft().addLimitLine(recommendedLevel);
        sodiumChart.getAxisLeft().setAxisMinimum(1500f);
        sodiumChart.setData(barData);
        sodiumChart.setFitBars(true);
        sodiumChart.animateXY(5000, 5000);
        sodiumChart.invalidate();
    }

    private void setCalorieData(int dailyCaloricGoal){

        ArrayList<BarEntry> values = new ArrayList<>();
        /* Adding in a sample weekly set of calorie counts*/
        values.add(new BarEntry(0f, 1328f));
        values.add(new BarEntry(1f, 1826f));
        values.add(new BarEntry(2f, 1522f));
        values.add(new BarEntry(3f, 1676f));
        values.add(new BarEntry(4f, 1432f));
        values.add(new BarEntry(5f, 1483f));
        values.add(new BarEntry(6f, 2000f));
        BarDataSet barDataSet = new BarDataSet(values, "Daily Caloric Count");
        barDataSet.setBarBorderWidth(0.9f);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.3f);
        XAxis xAxis = calorieChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        String[] dayLabel = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        IndexAxisValueFormatter formatter = new IndexAxisValueFormatter(dayLabel);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        xAxis.setTextSize(8);
        LimitLine calorieGoal = new LimitLine((float)dailyCaloricGoal, "Goal");
        calorieGoal.setLineWidth(1f);
        calorieGoal.setTextSize(10f);
        calorieGoal.setLineColor(Color.BLACK);
        calorieChart.getAxisLeft().addLimitLine(calorieGoal);
        calorieChart.getAxisLeft().setAxisMinimum(800f);
        calorieChart.getAxisRight().setDrawGridLines(false);
        calorieChart.getAxisLeft().setDrawGridLines(false);
        calorieChart.getXAxis().setDrawGridLines(false);
        calorieChart.setData(barData);
        calorieChart.setFitBars(true);
        calorieChart.animateXY(5000, 5000);
        calorieChart.invalidate();

    }

}