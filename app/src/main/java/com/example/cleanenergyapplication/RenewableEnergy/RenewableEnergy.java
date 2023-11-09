package com.example.cleanenergyapplication.RenewableEnergy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cleanenergyapplication.R;
import com.example.cleanenergyapplication.weeks.RecommendationsDetail;

public class RenewableEnergy extends AppCompatActivity {

    //weeks page

    private String count;
    private String done;
    CardView week1, week2, week3;
    ConstraintLayout week1CL,week2CL,week3CL;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renewable_energy);

        week1 = findViewById(R.id.course1);
        week2 = findViewById(R.id.course2);
        week3 = findViewById(R.id.course3);

        week1CL = findViewById(R.id.week1CL);
        week2CL = findViewById(R.id.week2CL);
        week3CL = findViewById(R.id.week3CL);


//            Intent i = getIntent();
//            done = i.getStringExtra("week1");
//
//            Toast.makeText(Course_week.this,done,Toast.LENGTH_LONG).show();
//            week2CL.setBackgroundResource(R.drawable.bg_window);


        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRecommendations();
            }
        });

        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                done = i.getStringExtra("week1");
                if (done.equalsIgnoreCase("INTENT_MESSAGE")) {
                    launchWeek2();
                    week2.setBackgroundResource(R.drawable.bg_window);
                } else {

                }
            }
        });

    }
    public void launchRecommendations(){
        Intent intent= new Intent(RenewableEnergy.this, RecommendationsDetail.class);
        startActivity(intent);
    }

    public void launchWeek2(){
        Intent intent= new Intent(RenewableEnergy.this, com.example.cleanenergyapplication.weeks.week2.class);
        startActivity(intent);
    }
    public void launchWeek3(){
        Intent intent= new Intent(RenewableEnergy.this, com.example.cleanenergyapplication.weeks.week3.class);
        startActivity(intent);
    }


}
