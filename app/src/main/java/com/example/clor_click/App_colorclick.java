package com.example.clor_click;

import android.content.Intent;
import android.os.Bundle;
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
    }
    private void openFastColor(){
        Intent intent = new Intent(App_colorclick.this, FastColor.class);
        startActivity(intent);
    }
}
