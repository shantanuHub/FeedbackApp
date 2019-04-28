package com.example.android.feedbackapp_ipscollege;

import android.content.Intent;
import android.media.Image;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main2page extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    RatingBar ratingBar,ratingbar1,ratingBar2,ratingBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2page);
        textView = findViewById(R.id.maintext);
        imageView = findViewById(R.id.mainimage);
        ratingBar = findViewById(R.id.ratingBar);
        ratingbar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);

        float ratingvalue = ratingBar.getRating();


        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        imageView.setImageResource(intent.getIntExtra("images" , 0));
        ratingBar.setRating(ratingvalue);

    }
}
