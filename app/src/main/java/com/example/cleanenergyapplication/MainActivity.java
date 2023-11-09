package com.example.cleanenergyapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.Spanned;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    EditText washer1;
    Button button1;
    TextView Tv1;

    EditText fridge1;
    Button button2;
    TextView Tv2;

    EditText elec1;
//    Button button3;
//    TextView Tv3;

    EditText air1;
//    Button button4;
//    TextView Tv4;

    EditText kitchen1;
//    Button button5;
//    TextView Tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        // Switch to ZoneActivity
                        Intent homeIntent = new Intent(MainActivity.this,ZoneScreen.class);
                        startActivity(homeIntent);
                        return true;

                    case R.id.input:
                        // Switch to MainActivity
                        Intent inputIntent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(inputIntent);
                        return true;

                    case R.id.settings:
                        // Switch to SettingsActivity
                        Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(settingsIntent);
                        return true;

                    default:
                        return false;
                }
            }
        });



        double value1 = getIntent().getDoubleExtra("value1", 0.0);
        double value2 = getIntent().getDoubleExtra("value2", 0.0);




        washer1 = (EditText) findViewById(R.id.edittext1);
        button1 = (Button) findViewById(R.id.button1);
        Tv1 = (TextView) findViewById(R.id.textview1);


        fridge1 = (EditText) findViewById(R.id.edittext2);
        button2 = (Button) findViewById(R.id.button2);
        Tv2 = (TextView) findViewById(R.id.textview2);

        elec1 = (EditText) findViewById(R.id.edittext3);
//        button3 = (Button) findViewById(R.id.button3);
//        Tv3 = (TextView) findViewById(R.id.textview3);

        air1 = (EditText) findViewById(R.id.edittext4);
//        button4 = (Button) findViewById(R.id.button4);
//        Tv4 = (TextView) findViewById(R.id.textview4);

        kitchen1 = (EditText) findViewById(R.id.edittext5);
//        button5 = (Button) findViewById(R.id.button5);
//        Tv5 = (TextView) findViewById(R.id.textview5);


//        double valueM1 = Double.parseDouble(washer1.getText().toString());
//        String valueM1 = washer1.getText().toString();
//        String valueM2 = fridge1.getText().toString();
//        String valueM3 = elec1.getText().toString();
//        String valueM4 = air1.getText().toString();
//        String valueM5 = kitchen1.getText().toString();

//        double valueM2 = Double.parseDouble(fridge1.getText().toString());
//        double valueM3 = Double.parseDouble(elec1.getText().toString());
//        double valueM4 = Double.parseDouble(air1.getText().toString());
//        double valueM5 = Double.parseDouble(kitchen1.getText().toString());

        applyInputFilter(washer1);
        applyInputFilter(fridge1);
        applyInputFilter(elec1);
        applyInputFilter(air1);
        applyInputFilter(kitchen1);




        button1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String input1 = washer1.getText().toString();
                double inputpi = Double.parseDouble(input1);


                String input2 = fridge1.getText().toString();
                double inputpi1 = Double.parseDouble(input2);

                String input3 = elec1.getText().toString();
                double inputpi2 = Double.parseDouble(input3);

                String input4 = air1.getText().toString();
                double inputpi3 = Double.parseDouble(input4);

                String input5 = kitchen1.getText().toString();
                double inputpi4 = Double.parseDouble(input5);



                double result = calculatewashingmachine(inputpi) + calculatefridge(inputpi1)
                        + calculateeclectronics(inputpi2) + calculateaircon(inputpi3) + calculatekitchen(inputpi4);


                double consumptionresult = calculatewashingconsumption(inputpi) + calcfridgeconsumption(inputpi1)
                        + calcelectronicsconsumption(inputpi2) + calcairconconsumption(inputpi3) + calckitchenconsumption(inputpi4);

                String formattedvalue = String.format("%.2f",result, consumptionresult);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String input1 = washer1.getText().toString();
                        double inputpi = Double.parseDouble(input1);


                        String input2 = fridge1.getText().toString();
                        double inputpi1 = Double.parseDouble(input2);

                        String input3 = elec1.getText().toString();
                        double inputpi2 = Double.parseDouble(input3);

                        String input4 = air1.getText().toString();
                        double inputpi3 = Double.parseDouble(input4);

                        String input5 = kitchen1.getText().toString();
                        double inputpi4 = Double.parseDouble(input5);



                        double result = calculatewashingmachine(inputpi) + calculatefridge(inputpi1)
                                + calculateeclectronics(inputpi2) + calculateaircon(inputpi3) + calculatekitchen(inputpi4);


                        double consumptionresult = calculatewashingconsumption(inputpi) + calcfridgeconsumption(inputpi1)
                                + calcelectronicsconsumption(inputpi2) + calcairconconsumption(inputpi3) + calckitchenconsumption(inputpi4);

                        String formattedvalue = String.format("%.2f",result, consumptionresult);

                        Intent intent = new Intent(MainActivity.this, ZoneScreen.class);

                        intent.putExtra("value1", value1);
                        intent.putExtra("value2", value2);

                        intent.putExtra("Washing Machine", inputpi);
                        intent.putExtra("Fridge", inputpi1);
                        intent.putExtra("Electronics", inputpi2);
                        intent.putExtra("Aircon", input3);
                        intent.putExtra("Kitchen", inputpi4);


                        intent.putExtra("number", consumptionresult);
                        startActivity(intent);
                    }
                });






//

//                int inputpi2 = Integer.parseInt(input3);
//
//
//                int inputpi3 = Integer.parseInt(input4);
//
//                String input5 = kitchen1.getText().toString();
//                int inputpi4 = Integer.parseInt(input5);


//                Tv1.setText(String.valueOf(inputpi+inputpi1+inputpi2+inputpi3+inputpi4));
                Tv1.setText("Quarterly Total Cost: $" + formattedvalue);
                Tv2.setText("Quarterly Total Consumption: " + String.valueOf(consumptionresult) +"kWh");


            }
        });





//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input = fridge1.getText().toString();
//                Tv2.setText(input);
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input = elec1.getText().toString();
//                Tv3.setText(input);
//            }
//        });
//
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input = air1.getText().toString();
//                Tv4.setText(input);
//            }
//        });
//
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String input = kitchen1.getText().toString();
//                Tv5.setText(input);
//            }
//        });




    }



//    input filter for number only and below 24.

    private void applyInputFilter(EditText editText) {
        InputFilter[] filters = editText.getFilters();
        InputFilter[] newFilters = new InputFilter[filters.length + 1];
        System.arraycopy(filters, 0, newFilters, 0, filters.length);

        newFilters[filters.length] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                // Combine the existing text and the input to validate the new value
                String newValue = dest.subSequence(0, dstart).toString() + source.subSequence(start, end).toString() + dest.subSequence(dend, dest.length()).toString();

                try {
                    // value as a double
                    double newValueAsDouble = Double.parseDouble(newValue);

                    // value is within (0 to 24)
                    if (newValueAsDouble < 0 || newValueAsDouble > 24) {
                        showAlertDialog("Please enter a number between 0 and 24.");
                        return "";
                    }
                } catch (NumberFormatException e) {
                    showAlertDialog("Please enter a valid number.");
                    return "";
                }

                return null;
            }
        };

        editText.setFilters(newFilters);
    }

//popup dialog

    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.create().show();
    }

    public void switchToSecondActivity(View view) {
        Intent intent = new Intent(this, ZoneScreen.class);
        startActivity(intent);
    }


//    conversion methods
    private double calculatewashingmachine(double inputpi) {
        return ((inputpi * 18.2)*90) /100 ;
    }

    private double calculatefridge (double inputpi1){
        return ((inputpi1 * 1.5)*90)/100;
    }

    private double calculateeclectronics(double inputpi2){
        return ((inputpi2 * 5.2)*90)/100;
    }

    private double calculateaircon(double inputpi3){
        return ((inputpi3 * 46.5)*90)/100;
    }

    private double calculatekitchen(double inputpi4){
        return ((inputpi4 * 36.2)*90)/100;
    }

    private double calcelectronicsconsumption(double inputpi2){
        return ((250 * inputpi2)/1000)*90;
    }

    private double calculatewashingconsumption(double inputpi){
        return ((900 * inputpi)/1000)*90;
    }

    private double calcfridgeconsumption(double inputpi1){
        return ((72 * inputpi1)/1000)*90;
    }

    private double calcairconconsumption (double inputpi3){
        return ((2300 * inputpi3)/1000)*90;
    }

    private double calckitchenconsumption (double inpuptpi4){
        return ((1800 * inpuptpi4)/1000)*90;
    }




}