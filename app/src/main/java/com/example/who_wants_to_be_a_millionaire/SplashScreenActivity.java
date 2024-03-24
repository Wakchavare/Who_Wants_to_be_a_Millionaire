package com.example.who_wants_to_be_a_millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // Splash screen display time in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Using a Handler to delay the intent for the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity (login/register screen)
                Intent intent = new Intent(SplashScreenActivity.this,FirstQuestionActivity.class);
                startActivity(intent);
                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
