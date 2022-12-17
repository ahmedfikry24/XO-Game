package com.example.xogame;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView playerOneText;
    TextView playerTwoText;
    ConstraintLayout rootElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneText = findViewById(R.id.player_1_score);
        playerTwoText = findViewById(R.id.player_2_score);
        rootElement = findViewById(R.id.root_element);
        init();
    }

    int counter = 0;
    Integer playerTwoCount = 0;
    Integer playerOneCount = 0;
    String playerSympole = "";
    ArrayList<String> arrayList;

    @SuppressLint("SetTextI18n")
    public void onButtonClick(View view) {
        Button onClicked = ((Button) view);
        if (!onClicked.getText().toString().isEmpty()) {
            return;
        }
        if (counter % 2 == 0) {
            onClicked.setText("X");
            playerSympole = "X";
        } else {
            onClicked.setText("O");
            playerSympole = "O";
        }
        counter++;
        setValues(view.getId(), playerSympole);
        if (checkWinner("X")) {
            playerOneCount += 5;
            init();
            counter = 0;
        } else if (checkWinner("O")) {
            playerTwoCount += 5;
            init();
            counter = 0;
        } else if (counter == 9) {
            init();
            counter = 0;
        }
        playerOneText.setText(playerOneCount.toString());
        playerTwoText.setText(playerTwoCount.toString());
    }


    void init() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            arrayList.add("");
        }
        for (int i = 0; i < rootElement.getChildCount(); i++) {
            View view = rootElement.getChildAt(i);
            if (view instanceof Button) {
                ((Button) view).setText("");
            }
        }
    }

    void setValues(int id, String playerSympole) {
        if (id == R.id.button1) {
            arrayList.set(0, playerSympole);
        } else if (id == R.id.button2) {
            arrayList.set(1, playerSympole);
        } else if (id == R.id.button3) {
            arrayList.set(2, playerSympole);
        } else if (id == R.id.button4) {
            arrayList.set(3, playerSympole);
        } else if (id == R.id.button5) {
            arrayList.set(4, playerSympole);
        } else if (id == R.id.button6) {
            arrayList.set(5, playerSympole);
        } else if (id == R.id.button7) {
            arrayList.set(6, playerSympole);
        } else if (id == R.id.button8) {
            arrayList.set(7, playerSympole);
        } else if (id == R.id.button9) {
            arrayList.set(8, playerSympole);
        }
    }

    boolean checkWinner(String sympole) {
        for (int i = 0; i < 9; i += 3) {
            if (arrayList.get(i).equals(sympole) && arrayList.get(i + 1).equals(sympole) && arrayList.get(i + 2).equals(sympole)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i += 1) {
            if (arrayList.get(i).equals(sympole) && arrayList.get(i + 3).equals(sympole) && arrayList.get(i + 6).equals(sympole)) {
                return true;
            }
        }
        if (arrayList.get(0).equals(sympole) && arrayList.get(4).equals(sympole) && arrayList.get(8).equals(sympole)) {
            return true;
        }
        if (arrayList.get(2).equals(sympole) && arrayList.get(4).equals(sympole) && arrayList.get(6).equals(sympole)) {
            return true;
        }
        return false;
    }

}