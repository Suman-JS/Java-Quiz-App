package com.rocky.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint ("SetTextI18n")
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);
        TextView scoreView = findViewById (R.id.scoreView);
        Intent intent = getIntent ();
        String score = intent.getStringExtra (MainActivity.EXTRA_RESULT);
        scoreView.setText ("Your Score Is : " + score );
    }
}