package com.example.who_wants_to_be_a_millionaire;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        // Get reference to the TextView
        TextView textViewGameOverMessage = findViewById(R.id.textViewGameOverMessage);

        // Set the message
        textViewGameOverMessage.setText("Game Over!");
    }
}
