package com.example.xogame;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView playerOneText;
TextView playerTwoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneText = findViewById(R.id.player_1_score);
        playerTwoText = findViewById(R.id.player_2_score);
        init();
    }
int counter = 0;
    String playerSympole;
   public void onButtonClick(View view){
     Button onClicked = ((Button) view);
     if(!onClicked.getText().toString().isEmpty()){
         return;
     }
     if(counter%2==0){
        onClicked.setText("X");
        playerSympole ="X";
     }else {
         onClicked.setText("O");
         playerSympole ="O";
     }
     counter++;
      setValues(onClicked.getId());
   }
    ArrayList<String> arrayList = new ArrayList<>();
   void init(){

       for (int i =0; i<9;i++){
           arrayList.add("");
       }
   }

void setValues(int id){
    if(id == R.id.button1){
        arrayList.set(0,playerSympole);
    } else if (id == R.id.button2) {
        arrayList.set(1,playerSympole);
    }else if (id == R.id.button3) {
        arrayList.set(2,playerSympole);
    }else if (id == R.id.button4) {
        arrayList.set(3,playerSympole);
    }else if (id == R.id.button5) {
        arrayList.set(4,playerSympole);
    }else if (id == R.id.button6) {
        arrayList.set(5,playerSympole);
    }else if (id == R.id.button7) {
        arrayList.set(6,playerSympole);
    }else if (id == R.id.button8) {
        arrayList.set(7,playerSympole);
    }else if (id == R.id.button9) {
        arrayList.set(8,playerSympole);
    }
}


}