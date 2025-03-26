package com.example.nestify_10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PropertyDetails_2BHK extends AppCompatActivity {

    private TextView txtName, txtLocation, txtArea, txtPrice, txtSquareFeet, txtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        // Initialize UI Components
        txtName = findViewById(R.id.txtPropertyName);
        txtLocation = findViewById(R.id.txtPropertyLocation);
        txtArea = findViewById(R.id.txtPropertyArea);
        txtPrice = findViewById(R.id.txtPropertyPrice);
        txtSquareFeet = findViewById(R.id.txtPropertySquareFeet);
        txtType = findViewById(R.id.txtPropertyType);

        // Get data from Intent
        String name = getIntent().getStringExtra("Name");
        String location = getIntent().getStringExtra("Location");
        String area = getIntent().getStringExtra("Area");
        String price = getIntent().getStringExtra("Price");
        String squareFeet = getIntent().getStringExtra("SquareFeet");
        String type = getIntent().getStringExtra("Type");

        // Display data
        txtName.setText("Name: " + name);
        txtLocation.setText("Location: " + location);
        txtArea.setText("Area: " + area);
        txtPrice.setText("Price: " + price);
        txtSquareFeet.setText("Square Feet: " + squareFeet);
        txtType.setText("Type: " + type);
    }
}
