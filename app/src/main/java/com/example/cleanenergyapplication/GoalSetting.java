package com.example.cleanenergyapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.cleanenergyapplication.RenewableEnergy.RenewableEnergy;

public class GoalSetting extends AppCompatActivity {

    private CardView course1, course2, course3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.energy_goals);
        course1 = findViewById(R.id.course1);
        course3 = findViewById(R.id.course3);

        course1.setOnClickListener(new View.OnClickListener() {
            //When borrowing calculator button is clicked, calculator activity open
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });
        course3.setOnClickListener(new View.OnClickListener() {
            //When borrowing calculator button is clicked, calculator activity open
            @Override
            public void onClick(View v) {
                showDialog2();
            }
        });

    }
    public void launchRecommendations(){
        Intent intent= new Intent(GoalSetting.this, Course_week.class);
        startActivity(intent);
    }
    public void launchRenewableEnergy(){
        Intent intent= new Intent(GoalSetting.this, RenewableEnergy.class);
        startActivity(intent);
    }

    public void showDialog() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.dialouge);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRecommendations();
            }
        });
        dialog.show();
    }
    public void showDialog2() {
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.congratulations);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_window);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        Button btn_yes = dialog.findViewById(R.id.btn_yes);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRecommendations();
            }
        });
        dialog.show();
    }
}
