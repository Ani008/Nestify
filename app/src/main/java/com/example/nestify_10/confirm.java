package com.example.nestify_10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class confirm extends AppCompatActivity {

    private EditText etName, etAddress, etPhone, etProfession, etMembers;
    private Button btnBookProperty;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        // Initialize UI components
        btnBack = findViewById(R.id.btnBack);
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        etProfession = findViewById(R.id.etProfession);
        etMembers = findViewById(R.id.etMembers);
        btnBookProperty = findViewById(R.id.btnBookProperty);

        // Back button click listener
        btnBack.setOnClickListener(view -> finish());  // Go back to the previous activity

        // Property is Book Button click listener
        btnBookProperty.setOnClickListener(view -> validateAndSubmit());
    }

    /**
     * Validates the form and submits the data
     */
    private void validateAndSubmit() {
        String name = etName.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String profession = etProfession.getText().toString().trim();
        String members = etMembers.getText().toString().trim();

        // Form validation
        if (name.isEmpty()) {
            etName.setError("Please enter your name");
            etName.requestFocus();
            return;
        }

        if (address.isEmpty()) {
            etAddress.setError("Please enter your address");
            etAddress.requestFocus();
            return;
        }

        if (phone.isEmpty() || phone.length() != 10) {
            etPhone.setError("Enter a valid phone number (10 digits)");
            etPhone.requestFocus();
            return;
        }

        if (profession.isEmpty()) {
            etProfession.setError("Please enter your profession");
            etProfession.requestFocus();
            return;
        }

        if (members.isEmpty()) {
            etMembers.setError("Please enter the number of members");
            etMembers.requestFocus();
            return;
        }

        // If all fields are valid
        Toast.makeText(this, "Property Booked Successfully!", Toast.LENGTH_LONG).show();
    }
}
