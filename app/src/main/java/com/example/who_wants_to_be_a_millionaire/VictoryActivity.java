package com.example.who_wants_to_be_a_millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VictoryActivity extends AppCompatActivity {

    private TextView textViewCongrats;
    private TextView textViewPrizeAmount;
    private Button buttonPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        textViewCongrats = findViewById(R.id.textView_congrats);
        textViewPrizeAmount = findViewById(R.id.textView_prize_amount);
        buttonPlayAgain = findViewById(R.id.button_play_again);

        // Retrieving total prize money from PrizeManager
        int totalPrize = PrizeManager.getInstance().getTotalPrizeMoney();

        // Display "Congratulations!"
        textViewCongrats.setText("Congratulations!");

        // Display total prize money won
        textViewPrizeAmount.setText("You've won: $" + totalPrize);

        // Setting onClickListener for Play Again button
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Starting the FirstQuestionActivity for a new game
                Intent intent = new Intent(VictoryActivity.this, FirstQuestionActivity.class);
                startActivity(intent);

                // Finish current activity
                finish();
            }
        });
    }
}
