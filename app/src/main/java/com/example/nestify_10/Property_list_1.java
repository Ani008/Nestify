package com.example.nestify_10;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private LinearLayout containerLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list1);

        containerLayout = findViewById(R.id.linearLayoutContainer);

        // Load property details from Firebase
        fetch1BHKProperties();
    }

    private void fetch1BHKProperties() {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Properties").child("1 BHK");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                containerLayout.removeAllViews();

                if (snapshot.exists()) {
                    for (DataSnapshot propertySnapshot : snapshot.getChildren()) {
                        String name = propertySnapshot.child("Name").getValue(String.class);
                        String location = propertySnapshot.child("Location").getValue(String.class);
                        String area = propertySnapshot.child("Area").getValue(String.class);
                        String price = propertySnapshot.child("Price").getValue(String.class);
                        String squareFeet = propertySnapshot.child("SquareFeet").getValue(String.class);
                        String type = propertySnapshot.child("Type").getValue(String.class);

                        addPropertyToUI(name, location, area, price, squareFeet, type);
                    }
                } else {
                    Log.e("Firebase Data", "No properties found.");
                    Toast.makeText(Property_list_1.this, "No properties found.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Property_list_1.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addPropertyToUI(String name, String location, String area, String price, String squareFeet, String type) {
        // Creating a CardView layout dynamically
        View propertyView = getLayoutInflater().inflate(R.layout.activity_property_card, null);

        ImageView imgProperty = propertyView.findViewById(R.id.imgProperty);
        TextView txtName = propertyView.findViewById(R.id.txtPropertyName);
        TextView txtLocation = propertyView.findViewById(R.id.txtPropertyLocation);
        TextView txtprice = propertyView.findViewById(R.id.txtPropertyPrice);

        imgProperty.setImageResource(R.drawable.bhk_1); // Set a default image from drawable
        txtName.setText(name);
        txtLocation.setText(location);
        txtprice.setText(price);

        // On click, go to new activity with all details
        propertyView.setOnClickListener(v -> {
            Intent intent = new Intent(Property_list_1.this, PropertyDetails.class);
            intent.putExtra("Name", name);
            intent.putExtra("Location", location);
            intent.putExtra("Area", area);
            intent.putExtra("Price", price);
            intent.putExtra("SquareFeet", squareFeet);
            intent.putExtra("Type", type);
            startActivity(intent);
        });

        // Add the property layout to the main container
        containerLayout.addView(propertyView);
    }
}
