package com.example.clor_click;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FastColor extends AppCompatActivity {
    private TextView scoreText, timerText, targetColorText;
    private Button startButton, resetButton;

    private int score = 0;
    private int timeLeft = 30;

    private CountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fast_color);
        scoreText = findViewById(R.id.scoreText);
        timerText = findViewById(R.id.timerText);
        targetColorText = findViewById(R.id.targetColorText);

        startButton = findViewById(R.id.startButton);
        resetButton = findViewById(R.id.resetButton);

        startButton.setOnClickListener(v -> startGame());
        resetButton.setOnClickListener(v -> resetGame());
    }
    public void onColorClick(View view){

    }

    private void startGame(){
        score = 0;
        timeLeft = 30;

        scoreText.setText("0");
        timerText.setText("30");

        timer = new CountDownTimer(timeLeft * 1000L, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft -=1;
                timerText.setText(String.valueOf(timeLeft));

                if(timeLeft<=0) {
                    timer.cancel();
                    finishGame();
                }
            }

            @Override
            public void onFinish() {
                finishGame();
            }

        }.start();

    }
   
    private void finishGame(){
        timer = null;
        timerText.setText("0");
        targetColorText.setText("Гру завершено");
        targetColorText.setTextColor(0xFF000000);
    }

    private void resetGame(){

    }

}
