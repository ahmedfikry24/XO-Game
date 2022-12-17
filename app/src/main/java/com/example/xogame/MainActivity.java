package com.example.xogame;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
TextView playerOneText;
TextView playerTwoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneText = findViewById(R.id.player_1_score);
        playerTwoText = findViewById(R.id.player_2_score);
    }

}