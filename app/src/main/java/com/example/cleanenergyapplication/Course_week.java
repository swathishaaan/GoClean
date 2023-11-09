package com.example.cleanenergyapplication;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        int colour = Color.GRAY;
        CardView week1, week2, week3, week4, week5;
        ConstraintLayout week1CL,week2CL,week3CL,week4CL,week5CL;
        ImageView week1IV,week2IV,week3IV,week4IV,week5IV;
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

            week1IV = findViewById(R.id.week1IV);
            week2IV = findViewById(R.id.week2IV);
            week3IV = findViewById(R.id.week3IV);
            week4IV = findViewById(R.id.week4IV);
            week5IV = findViewById(R.id.week5IV);

            week2.setCardBackgroundColor(Color.GRAY);
            week3.setCardBackgroundColor(Color.GRAY);
            week4.setCardBackgroundColor(Color.GRAY);
            week5.setCardBackgroundColor(Color.GRAY);

//            Intent i = getIntent();
//            done = i.getStringExtra("week1");
//
//            Toast.makeText(Course_week.this,done,Toast.LENGTH_LONG).show();
//            week2CL.setBackgroundResource(R.drawable.bg_window);


            Intent i = getIntent();

            String done  = i.getStringExtra("done");
            if(done!=null) {
                week2.setBackgroundResource(R.drawable.bg_window);
                week1IV.setImageResource(R.drawable.baseline_check_box_24);
                week2IV.setImageResource(R.drawable.baseline_lock_open_24);
            }
            Intent in = getIntent();
            String done2  = i.getStringExtra("done2");
            if(done2!=null) {
                week2.setBackgroundResource(R.drawable.bg_window);
                week1IV.setImageResource(R.drawable.baseline_check_box_24);
                week2IV.setImageResource(R.drawable.baseline_lock_open_24);
                week3.setBackgroundResource(R.drawable.bg_window);
                week2IV.setImageResource(R.drawable.baseline_check_box_24);
                week3IV.setImageResource(R.drawable.baseline_lock_open_24);
            }
            Intent intent1 = getIntent();
            String done3  = i.getStringExtra("done3");
            if(done3!=null) {
                week2.setBackgroundResource(R.drawable.bg_window);
                week1IV.setImageResource(R.drawable.baseline_check_box_24);
                week2IV.setImageResource(R.drawable.baseline_lock_open_24);
                week3.setBackgroundResource(R.drawable.bg_window);
                week2IV.setImageResource(R.drawable.baseline_check_box_24);
                week3IV.setImageResource(R.drawable.baseline_lock_open_24);
                week4.setBackgroundResource(R.drawable.bg_window);
                week3IV.setImageResource(R.drawable.baseline_check_box_24);
                week4IV.setImageResource(R.drawable.baseline_lock_open_24);
            }
            Intent intent2 = getIntent();
            String done4  = i.getStringExtra("done4");
            if(done4!=null) {
                week2.setBackgroundResource(R.drawable.bg_window);
                week1IV.setImageResource(R.drawable.baseline_check_box_24);
                week2IV.setImageResource(R.drawable.baseline_lock_open_24);
                week3.setBackgroundResource(R.drawable.bg_window);
                week2IV.setImageResource(R.drawable.baseline_check_box_24);
                week3IV.setImageResource(R.drawable.baseline_lock_open_24);
                week4.setBackgroundResource(R.drawable.bg_window);
                week3IV.setImageResource(R.drawable.baseline_check_box_24);
                week4IV.setImageResource(R.drawable.baseline_lock_open_24);
                week5.setBackgroundResource(R.drawable.bg_window);
                week4IV.setImageResource(R.drawable.baseline_check_box_24);
                week5IV.setImageResource(R.drawable.baseline_lock_open_24);
            }

//            Intent inte = getIntent();
//            String done3 = inte.getStringExtra("done3");
//            if(done3!=null) {
//                week4.setBackgroundResource(R.drawable.bg_window);
//                week3IV.setImageResource(R.drawable.baseline_check_box_24);
//                week4IV.setImageResource(R.drawable.baseline_lock_open_24);
//            }


//            Bundle bundle = getIntent().getExtras();
//            if (bundle != null) {
//
//                if (bundle.containsKey("done2")) {
//                    String done2 = bundle.getString ("done2");
//                    week3.setBackgroundResource(R.drawable.bg_window);
//                    week2IV.setImageResource(R.drawable.baseline_check_box_24);
//                    week3IV.setImageResource(R.drawable.baseline_lock_open_24);
//
//                } else if(bundle.containsKey("done3")) {
//                    String done3 = bundle.getString ("done3");
//                }
//
//            }

            week1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchRecommendations();
                }
            });

            week2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(week2.getSolidColor() == Color.GRAY ) {
                        Toast.makeText(Course_week.this,"Week 2 locked",Toast.LENGTH_LONG).show();
                    } else if(done == null) {
                        Toast.makeText(Course_week.this,"Week 2 locked",Toast.LENGTH_LONG).show();
                    }
                    else {
                        launchWeek2();
                    }
                }
            });

            week3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(week3.getSolidColor() == Color.GRAY ) {
                        Toast.makeText(Course_week.this,"Week 3 locked",Toast.LENGTH_LONG).show();
                    } else if(done2 == null) {
                        Toast.makeText(Course_week.this,"Week 3 locked",Toast.LENGTH_LONG).show();
                    }
                    else {
                        launchWeek3();
                    }
                }
            });
            week4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(week5.getSolidColor() == Color.GRAY ) {
                        Toast.makeText(Course_week.this,"Week 4 locked",Toast.LENGTH_LONG).show();
                    } else if(done3 == null) {
                        Toast.makeText(Course_week.this,"Week 4 locked",Toast.LENGTH_LONG).show();
                    }
                    else {
                        launchWeek4();
                    }
                }
            });
            week5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(week5.getSolidColor() == Color.GRAY ) {
                        Toast.makeText(Course_week.this,"Week 5 locked",Toast.LENGTH_LONG).show();
                    } else if(done4 == null) {
                        Toast.makeText(Course_week.this,"Week 5 locked",Toast.LENGTH_LONG).show();
                    }
                    else {
                        launchWeek5();
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
                launchWeek2();
            }
        });
        dialog.show();
    }

}


