package com.example.cleanenergyapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ZoneScreen extends AppCompatActivity {

    Button switchToCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_screen);
        Intent intent = getIntent();
        double number = intent.getDoubleExtra("number", 0.0);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        // Switch to ZoneActivity
                        Intent homeIntent = new Intent(ZoneScreen.this,ZoneScreen.class);
                        startActivity(homeIntent);
                        return true;

                    case R.id.input:
                        // Switch to MainActivity
                        Intent inputIntent = new Intent(ZoneScreen.this, MainActivity.class);
                        startActivity(inputIntent);
                        return true;

                    case R.id.settings:
                        // Switch to SettingsActivity
                        Intent settingsIntent = new Intent(ZoneScreen.this, SettingsActivity.class);
                        startActivity(settingsIntent);
                        return true;

                    default:
                        return false;
                }
            }
        });

        double value1 = getIntent().getDoubleExtra("value1", 0.0);
        double value2 = getIntent().getDoubleExtra("value2", 0.0);

        double valueM1 = getIntent().getDoubleExtra("Washing Machine", 0.0);
        double valueM2 = getIntent().getDoubleExtra("Fridge", 0.0);
        double valueM3 = getIntent().getDoubleExtra("Electronics", 0.0);
        double valueM4 = getIntent().getDoubleExtra("Aircon", 0.0);
        double valueM5 = getIntent().getDoubleExtra("Kitchen", 0.0);


        int circleColor;


        if (number > 1600.0) {
            circleColor = Color.RED;
        } else if (number > 1000.0) {
            circleColor = Color.rgb(255, 165, 0); // Orange
        } else {
            circleColor = Color.YELLOW;
        }

        TextView colorTextView = findViewById(R.id.colorTextView);

        if (circleColor == Color.RED) {
            colorTextView.setText("You are in the Red Zone (Very high consumption)");
        } else if (circleColor == Color.rgb(255, 165, 0)) {
            colorTextView.setText("You are in the Orange Zone (High Consumption)");
        } else {
            colorTextView.setText("You are in the Yellow Zone (Moderate Consumption)");
        }

//        View circleView = findViewById(R.id.circleView);
//        circleView.setBackgroundColor(circleColor);

        CircularView circleView = findViewById(R.id.circleView);

        double redThreshold = 1600.0;
        double orangeThreshold = 1000.0;

        if (number >= redThreshold) {
            circleView.setCircleColor(Color.RED);
            circleView.setStrokeColor(Color.BLACK);
        } else if (number >= orangeThreshold) {
            circleView.setCircleColor(Color.parseColor("#FFA500"));
            circleView.setStrokeColor(Color.BLACK);
        } else {
            circleView.setCircleColor(Color.YELLOW);
            circleView.setStrokeColor(Color.BLACK);
        }



// Initialize the LineChart
        LineChart lineChart = findViewById(R.id.lineChart);

        // Create a list of entries for the line chart
        ArrayList<Entry> entries4 = new ArrayList<>();
        entries4.add(new Entry(0, (float) valueM1));
        entries4.add(new Entry(1, (float) valueM2));
        entries4.add(new Entry(2, (float) valueM3));
        entries4.add(new Entry(3, (float) valueM4));
        entries4.add(new Entry(4, (float) valueM5));

        // Create a LineDataSet from the entries
        LineDataSet dataSet4 = new LineDataSet(entries4, "Consumption Usage Breakdown (hours)");

        // Create a LineData object from the LineDataSet
        LineData lineData = new LineData(dataSet4);

        // Set the LineData to the LineChart
        lineChart.setData(lineData);

        // Customize the line chart as needed
        dataSet4.setColors(new int[]{Color.GREEN});
        dataSet4.setValueTextSize(12f);

        XAxis xAxis4 = lineChart.getXAxis();
        xAxis4.setGranularity(1f);
        xAxis4.setValueFormatter(new IndexAxisValueFormatter(new String[]{"Washer", "Fridge", "Electronics", "Aircon", "Kitchen"}));
        xAxis4.setPosition(XAxis.XAxisPosition.BOTTOM); // Position the labels at the bottom

        lineChart.setExtraTopOffset(10f);
        lineChart.setExtraBottomOffset(10f);


        // Refresh the chart to display the data
        lineChart.invalidate();
        PieChart pieChart = findViewById(R.id.pieChart);
        BarChart barChart = findViewById(R.id.barChart);
        BarChart barChart1 = findViewById(R.id.barChart1);
        BarChart barChart2 = findViewById(R.id.barChart2);
        int singleColor = Color.DKGRAY;

        float[] percentages = {29f, 39f, 46f, 44f, 38f, 33f};
        String[] labels3 = {"18-24", "25-34", "35-44", "45-54", "55-64", "65+"};

        List<PieEntry> entries3 = new ArrayList<>();
        for (int i = 0; i < percentages.length; i++) {
            entries3.add(new PieEntry(percentages[i], labels3[i]));
        }

        PieDataSet dataSet3 = new PieDataSet(entries3, "% stressed by energy bills (Age)");
        dataSet3.setColors(new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.LTGRAY, Color.MAGENTA, Color.CYAN});

        PieData pieData = new PieData(dataSet3);
        dataSet3.setValueTextSize(14f);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);
        pieChart.animateY(1400);

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 732f)); // Bar 1 value
        entries.add(new BarEntry(1f, 1278f)); // Bar 2 value
        entries.add(new BarEntry(2f, 1530f)); // Bar 3 value
        entries.add(new BarEntry(3f, 1819f)); // Bar 4 value
        entries.add(new BarEntry(4f, 2158f)); // Bar 4 value

        List<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(0f, 324f)); // Bar 1 value
        entries1.add(new BarEntry(1f, 376f)); // Bar 2 value
        entries1.add(new BarEntry(2f, 407f)); // Bar 2 value
        entries1.add(new BarEntry(3f, 454f)); // Bar 2 value
        entries1.add(new BarEntry(4f, 476f)); // Bar 2 value

        ArrayList<BarEntry> entries2 = new ArrayList<>();

        entries2.add(new BarEntry(0f, (float) value1)); // Bar 1 value
        entries2.add(new BarEntry(1f, (float) value2)); // Bar 2 value






        BarDataSet dataSet1 = new BarDataSet(entries1, "Average electricity bill by number of persons ($)");

        ArrayList<String> labels1 = new ArrayList<>();
        labels1.add("1 person");
        labels1.add("2 persons");
        labels1.add("3 persons");
        labels1.add("4 persons");
        labels1.add("5+ persons");

        BarData barData1 = new BarData(dataSet1);
        barChart1.setData(barData1);
        dataSet1.setColor(singleColor);


        BarDataSet dataSet = new BarDataSet(entries, "Average usage in Sydney (kWh)");

        ArrayList<String> labels = new ArrayList<>();
        labels.add("1 Person");
        labels.add("2 Persons");
        labels.add("3 Persons");
        labels.add("4 Persons");
        labels.add("5+ Persons");

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);


        BarDataSet dataSet2 = new BarDataSet(entries2, "Your Current Quarterly Consumption");

        ArrayList<String> labels2 = new ArrayList<>();
        labels2.add("Cost ($)");
        labels2.add("Consumption (kWh)");

        BarData barData2 = new BarData(dataSet2);
        barChart2.setData(barData2);

        XAxis xAxis2 = barChart2.getXAxis();
        xAxis2.setValueFormatter(new IndexAxisValueFormatter(labels2));
        xAxis2.setLabelCount(labels2.size());
//        barChart2.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
//        barChart2.getXAxis().setCenterAxisLabels(true);
//        barChart2.getXAxis().setLabelRotationAngle(0); // You can adjust the rotation angle as needed
//        barChart2.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels2));
//        // Set different colors for the entries
//        dataSet2.setColors(new int[]{Color.BLUE, Color.RED}); // Set bar colors for "Cost ($)" and "Consumption (kWh)"
//        dataSet2.setValueTextColor(Color.BLACK);
//        dataSet2.setValueTextSize(12f);
//        barChart2.animateY(1000); // Add animation if desired
//        barChart2.setFitBars(true); // Make the bars fit the screen widthhe bars fit the screen width
//        barChart2.setScaleXEnabled(false); // Disable X-axis zooming
//        barChart2.setScaleYEnabled(false); //

        dataSet2.setColors(new int[]{Color.BLUE, Color.RED});

// Customize the X-axis labels
//        barChart2.getXAxis().setValueFormatter(new IndexAxisValueFormatter(new String[]{"Cost ($)", "Consumption (kWh)"}));

        // Set up the X-axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setLabelCount(labels.size());

// Adjust bar width and center labels
        barData.setBarWidth(0.6f); // bar width
        barChart.setFitBars(true);
        xAxis.setAxisMinimum(-0.5f); // Start labels from the center of each bar
        xAxis.setAxisMaximum(barData.getXMax() + 0.5f); // End labels at the center of each bar
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // Position the labels at the bottom

        barChart.getDescription().setEnabled(false); // Disable chart description
        barChart1.getDescription().setEnabled(false);
        barChart2.getDescription().setEnabled(false);
        barChart.invalidate(); // Refresh the chart
        barChart1.invalidate();
        barChart2.invalidate();

        //When button is clicked, it moves onto Courses

        switchToCourse = findViewById(R.id.switchToCourse);
        switchToCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchToCourses();
            }
        });


    }
    private void launchToCourses() {
        Intent intent = new Intent(ZoneScreen.this, GoalSetting.class);
        startActivity(intent);

    }

}


