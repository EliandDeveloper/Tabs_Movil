package com.example.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        TextView message = findViewById(R.id.welcome_message);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        message.setText("Bienvenido " + name);
    }
}
