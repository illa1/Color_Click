package com.example.clor_click;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FastColor extends AppCompatActivity {
    private TextView scoreText, timerText, targetColorText;
    private Button startButton, resetButton;


    private int score = 0;
    private int timeLeft = 30;

    private CountDownTimer timer;

    private final Random random = new Random();

    private final String[] colors = {"RED","GREEN","BLUE"};

    private  String currentTargetColor = "";

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
        if (timer == null) return;
        String pressColor = "";
        if (view.getId() == R.id.redButton){
            pressColor = "RED";
        }
        if (view.getId() == R.id.greenButton){
            pressColor = "GREEN";
        }
        if (view.getId() == R.id.blueButton){
            pressColor = "BLUE";
        }

        if (pressColor.equals(currentTargetColor)){
            score ++;
            scoreText.setText(String.valueOf(score));
        }else {
            timeLeft -= 5;
            if (timeLeft < 0) timeLeft = 0;

            timerText.setText(String.valueOf(timeLeft));

            if(timeLeft == 0){
                timer.cancel();
                finishGame();
                return;
            }
        }
        pickNewColor();
    }

    private void startGame(){
        score = 0;
        timeLeft = 30;

        scoreText.setText("0");
        timerText.setText("30");

        pickNewColor();

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

    private void  pickNewColor(){
        int i = random.nextInt(colors.length);
        currentTargetColor = colors[i];

        switch (currentTargetColor){
            case "RED":
                targetColorText.setText("Червоний");
                targetColorText.setTextColor(0xFFF44336);
                break;
            case "GREEN":
                targetColorText.setText("Зелений");
                targetColorText.setTextColor(0xFF4CAF50);
                break;
            case "BLUE":
                targetColorText.setText("Синій");
                targetColorText.setTextColor(0xFF2196F3);
                break;
        }
    }
   
    private void finishGame(){
        timer = null;
        timerText.setText("0");
        targetColorText.setText("Гру завершено");
        targetColorText.setTextColor(0xFF000000);
    }

    private void resetGame(){
        if(timer != null) {
           timer.cancel();
           timer = null;
        }
        score = 0;
        timeLeft = 30;
        scoreText.setText("0");
        timerText.setText("30");
        targetColorText.setText("Натисніть колір");
        targetColorText.setTextColor(0xFF444444);
    }

}
