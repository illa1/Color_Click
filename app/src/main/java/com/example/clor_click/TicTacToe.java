package com.example.clor_click;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TicTacToe extends AppCompatActivity {
    private TextView statusTextInfo;
    private Button[] buttons = new Button[9];
    private Button resetButton;

    private boolean isPlayerX = true;
    private int moveCount = 0;
    private int[] gameStatus = {0,0,0,0,0,0,0,0,0,};
    private final int[][] winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tic_tac_toe);

        statusTextInfo = findViewById(R.id.statusTextInfo);
        resetButton = findViewById(R.id.resetButton);

        for(int i = 0; i<9; i++){
            String buttonID = "btn_tic_tac_toe_" + i;

            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

            buttons[i] = findViewById(resID);

            buttons[i].setOnClickListener(v -> onGridButtonClick((Button) v, index)
            );
        }
    }
    private void onGridButtonClick(Button btn, int index){

    }
}

