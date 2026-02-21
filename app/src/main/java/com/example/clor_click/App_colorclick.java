package com.example.clor_click;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class App_colorclick extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.colorclicklayout);
        Button fastColor = findViewById(R.id.button_fast_color);
        fastColor.setOnClickListener(view -> openFastColor());

        Button ticTacToe = findViewById(R.id.btn_tic_tac_toe);
        ticTacToe.setOnClickListener(view -> openTicTacToe());


    }
    private void openFastColor(){
        Intent intent = new Intent(App_colorclick.this, FastColor.class);
        startActivity(intent);
    }
    private  void openTicTacToe(){
        Intent intent = new Intent(App_colorclick.this, TicTacToe.class);
        startActivity(intent);
    }
//    MENU -----------------------------------------------------------
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
