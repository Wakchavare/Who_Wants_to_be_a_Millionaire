package com.example.who_wants_to_be_a_millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TwelfththQuestionActivity extends AppCompatActivity {

    private String question = "What is the chemical symbol for gold?";
    private String[] options = {"Au", "Ag", "Fe", "Pb"};
    private int correctAnswerIndex = 1;

    private TextView textViewQuestion;
    private RadioGroup radioGroupOptions;
    private RadioButton[] optionRadioButtons;
    private TextView textViewPrize;
    private Button buttonConfirm;

    private int[] prizeAmounts = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
    private int currentPrizeIndex;

    private boolean answerConfirmed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        textViewQuestion = findViewById(R.id.textView_question);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        textViewPrize = findViewById(R.id.textView_prize);
        buttonConfirm = findViewById(R.id.button_confirm);

        // Retrieving currentPrizeIndex from Intent
        Intent intent = getIntent();
        currentPrizeIndex = intent.getIntExtra("currentPrizeIndex", 0);

        textViewQuestion.setText(question);
        updatePrize();

        // Clear existing radio buttons
        radioGroupOptions.removeAllViews();

        // Set answer options text for RadioButtons
        optionRadioButtons = new RadioButton[options.length];
        for (int i = 0; i < options.length; i++) {
            optionRadioButtons[i] = new RadioButton(this);
            optionRadioButtons[i].setText(options[i]);
            optionRadioButtons[i].setId(i); // Set unique ID for each RadioButton
            radioGroupOptions.addView(optionRadioButtons[i]);
        }

        // Set onClickListener for the Confirm button
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answerConfirmed) {
                    int selectedOptionIndex = radioGroupOptions.indexOfChild(findViewById(radioGroupOptions.getCheckedRadioButtonId()));
                    if (selectedOptionIndex != -1) {
                        checkAnswer(selectedOptionIndex);
                        answerConfirmed = true;
                    } else {
                        Toast.makeText(TwelfththQuestionActivity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(TwelfththQuestionActivity.this, "Answer already confirmed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkAnswer(int selectedOption) {
        if (selectedOption == correctAnswerIndex) {

            // Correct answer
            Toast.makeText(this, "Correct Answer!", Toast.LENGTH_SHORT).show();
            // Add prize money
            PrizeManager.getInstance().addPrizeMoney(prizeAmounts[currentPrizeIndex]);
            // Move to the ThirdQuestionActivity and pass the updated currentPrizeIndex
            moveToNextQuestion();
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect Answer! Game Over!", Toast.LENGTH_SHORT).show();
            // Move to the GameOverActivity
            Intent intent = new Intent(this, GameOverActivity.class);
            startActivity(intent);
            finish(); // Finish current activity
        }
    }

    private void updatePrize() {
        // Update prize TextView with total prize money
        textViewPrize.setText("Current Prize: $" + PrizeManager.getInstance().getTotalPrizeMoney());
    }

    private void moveToNextQuestion() {
        // Increment currentPrizeIndex to move to the next question's prize
        currentPrizeIndex++;

        // Move to the ThirdQuestionActivity and pass the updated currentPrizeIndex
        Intent intent = new Intent(this, ThirteenthQuestionActivity.class);
        intent.putExtra("currentPrizeIndex", currentPrizeIndex);
        startActivity(intent);
        finish(); // Finish current activity to prevent going back to it using the back button
    }
}
