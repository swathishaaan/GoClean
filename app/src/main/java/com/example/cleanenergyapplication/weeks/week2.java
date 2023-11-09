package com.example.cleanenergyapplication.weeks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.cleanenergyapplication.Course_week;
import com.example.cleanenergyapplication.R;

public class week2 extends AppCompatActivity {
    String done = "Congratulations! Week two Complete";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2);

        Button check1 = findViewById(R.id.check1);
        Button check2 = findViewById(R.id.check2);
        Button check3 = findViewById(R.id.check3);
        Button doneButton = findViewById(R.id.doneButton);

        ImageView rating1 = findViewById(R.id.rating1);
        ImageView rating2 = findViewById(R.id.rating2);
        ImageView rating3 = findViewById(R.id.rating3);

        CardView course1 = findViewById(R.id.course1);
        CardView course2 = findViewById(R.id.course2);
        CardView course3 = findViewById(R.id.course3);


        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course1.setBackgroundColor(Color.GREEN);
                rating1.setImageResource(R.drawable.yellowstar);

            }
        });
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course2.setBackgroundColor(Color.GREEN);
                rating2.setImageResource(R.drawable.yellowstar);

            }
        });
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course3.setBackgroundColor(Color.GREEN);
                rating3.setImageResource(R.drawable.yellowstar);

            }
        });

//        if(course1.getCardBackgroundColor().equals(Color.GREEN) && course2.getCardBackgroundColor().equals(Color.GREEN)
//                && course3.getCardBackgroundColor().equals(Color.GREEN)) {
//            Toast.makeText(week2.this,done,Toast.LENGTH_LONG).show();
//            launchWeeks(done);
//        }
//
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(course3.getSolidColor()!= Color.GREEN) {
//                    Toast.makeText(week2.this,"Please finish activity",Toast.LENGTH_LONG).show();
//                } else {
                    Toast.makeText(week2.this,"Congratulations! Week 2 complete",Toast.LENGTH_LONG).show();
                    launchWeeks(done);
//                }
            }
        });

    }

    private void launchWeeks(String done) {
        Intent intent = new Intent(week2.this, Course_week.class);
        intent.putExtra("done2", done);
        startActivity(intent);
    }
//        private void launchWeeks(String done2) {
//            Intent intent = new Intent(week2.this, Course_week.class);
//            Bundle bundle = new Bundle();
//            bundle.putString ("done2", done2);
//            intent.putExtras(bundle);
//            startActivity(intent);
//    }


}
