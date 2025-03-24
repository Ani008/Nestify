package com.example.nestify_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        // Initialize the back button
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   // Go back to the previous activity
            }
        });

        // Initialize Interested button
        Button btnInterested = findViewById(R.id.btnInterested);
        btnInterested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailInfoActivity.this, "You clicked Interested!", Toast.LENGTH_SHORT).show();

                // Example: Navigate to an inquiry form or another activity
                // Intent intent = new Intent(DetailInfoActivity.this, InquiryFormActivity.class);
                // startActivity(intent);
            }
        });

        // Initialize Favorite button
        Button btnFavorite = findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailInfoActivity.this, "Added to Favorites!", Toast.LENGTH_SHORT).show();

                // Example: Save to favorites (you can add Firebase or local storage logic here)
            }
        });
    }
}
