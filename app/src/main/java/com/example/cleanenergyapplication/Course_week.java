package com.example.cleanenergyapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.cleanenergyapplication.weeks.RecommendationsDetail;
import com.example.cleanenergyapplication.weeks.week2;
import com.example.cleanenergyapplication.weeks.week3;
import com.example.cleanenergyapplication.weeks.week4;
import com.example.cleanenergyapplication.weeks.week5;

public class Course_week extends AppCompatActivity {

        private String count;
        private String done;
        CardView week1, week2, week3, week4, week5;
        ConstraintLayout week1CL,week2CL,week3CL,week4CL,week5CL;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.course_week);

            week1 = findViewById(R.id.course1);
            week2 = findViewById(R.id.course2);
            week3 = findViewById(R.id.course3);
            week4 = findViewById(R.id.course4);
            week5 = findViewById(R.id.course5);
            week1CL = findViewById(R.id.week1CL);
            week2CL = findViewById(R.id.week2CL);
            week3CL = findViewById(R.id.week3CL);
            week4CL = findViewById(R.id.week4CL);
            week5CL = findViewById(R.id.week5CL);

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
        Intent intent= new Intent(Course_week.this, RecommendationsDetail.class);
        startActivity(intent);
    }

    public void launchWeek2(){
        Intent intent= new Intent(Course_week.this, com.example.cleanenergyapplication.weeks.week2.class);
        startActivity(intent);
    }
    public void launchWeek3(){
        Intent intent= new Intent(Course_week.this, com.example.cleanenergyapplication.weeks.week3.class);
        startActivity(intent);
    }
    public void launchWeek4(){
        Intent intent= new Intent(Course_week.this, com.example.cleanenergyapplication.weeks.week4.class);
        startActivity(intent);
    }
    public void launchWeek5(){
        Intent intent= new Intent(Course_week.this, com.example.cleanenergyapplication.weeks.week5.class);
        startActivity(intent);
    }

}


