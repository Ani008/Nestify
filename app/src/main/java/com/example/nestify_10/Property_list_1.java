package com.example.nestify_10;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Property_list_1 extends AppCompatActivity {

    private TextView txtPropertyDetails;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list1);

        txtPropertyDetails = findViewById(R.id.txtPropertyDetails);
        btnBack = findViewById(R.id.btnBack);

        // Handle back button click
        btnBack.setOnClickListener(v -> finish());

        // Fetch and display property data
        loadPropertyData();
    }

    private void loadPropertyData() {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Properties").child("1 BHK");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    StringBuilder details = new StringBuilder();
                    for (DataSnapshot propertySnapshot : snapshot.getChildren()) {
                        String name = propertySnapshot.child("Name").getValue(String.class);
                        String area = propertySnapshot.child("Area").getValue(String.class);
                        String location = propertySnapshot.child("Location").getValue(String.class);
                        String price = propertySnapshot.child("Price").getValue(String.class);
                        String squareFeet = propertySnapshot.child("SquareFeet").getValue(String.class);
                        String type = propertySnapshot.child("Type").getValue(String.class);

                        details.append("🏡 Name: ").append(name).append("\n")
                                .append("📍 Location: ").append(location).append("\n")
                                .append("📏 Area: ").append(area).append("\n")
                                .append("📐 Square Feet: ").append(squareFeet).append("\n")
                                .append("💰 Price: ₹").append(price).append("\n")
                                .append("🏠 Type: ").append(type).append("\n\n");
                    }
                    txtPropertyDetails.setText(details.toString());
                } else {
                    txtPropertyDetails.setText("No properties available.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Property_list_1.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
