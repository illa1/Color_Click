package com.example.clor_click;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class TicTacToe  extends AppCompatActivity {

    private TextView statusTextInfo;
    private Button[] buttons = new Button[9];
    private Button resetButton;
    private boolean isPlayerX = true;
    private int moveCount = 0;
    private boolean activeGame = true;
    private int[] gameStatus = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final int[][] winningPositions = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tic_tac_toe);

        statusTextInfo = findViewById(R.id.statusTextInfo);
        resetButton = findViewById(R.id.resetButton);

        for (int i = 0; i < 9; i++) {
            String buttonID = "btn_tic_tack_toe_" + i;

            int resID = getResources().getIdentifier(
                    buttonID,
                    "id",
                    getPackageName());

            buttons[i] = findViewById(resID);

            final int index = i;
            buttons[i].setOnClickListener(
                    v -> onGridButtonClick((Button) v, index)
            );
        }

        resetButton.setOnClickListener(v -> resetGame);

        isPlayerX = Math.random() < 0.5;
    }

    private void  onGridButtonClick(Button btn, int index) {
        if (gameStatus[index] == 0 && activeGame){
            moveCount ++;
            gameStatus[index] = isPlayerX ? 1: 2;

            if(isPlayerX){
                btn.setText("x");
                btn.setTextColor(Color.RED);
            } else {
                btn.setText("o");
                btn.setTextColor(Color.BLUE);
            }
            if (checkWinner()){
                activeGame = false;
                showWinner(isPlayerX ? "x" : "o");
            }else if (moveCount == 9){
                activeGame = false;
                showWinner("N");
            }else {
                isPlayerX = !isPlayerX;
            }
        }
    }
    private boolean checkWinner(){
        return true;
    }
    private boolean showWinner(String winner){
        return true;
    }
    private void resetGame() {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.menu_main){
            Intent intent = new Intent(this, App_colorclick.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return  true;
        }else if (id == R.id.menu_fast_color){
            startActivity(new Intent(this, FastColor.class));
            return  true;
        }else if (id == R.id.menu_tic_tac_toe){
            startActivity(new Intent(this, TicTacToe.class));
            return  true;
        }
        return  super.onOptionsItemSelected(item);

    }
}

