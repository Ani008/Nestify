package com.example.nestify_10;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Set Splash Screen Layout

        // Delay for 3 seconds then open SignUp activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity_splash.this, signup.class);
                startActivity(intent);
                finish(); // Close SplashActivity so it doesn't stay in the back stack
            }
        }, 3000); // 3000ms = 3 seconds
    }
}
