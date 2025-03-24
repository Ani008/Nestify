package com.example.nestify_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_option extends Activity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseRef;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        // Initialize UI components
        usernameTextView = findViewById(R.id.username);
        mAuth = FirebaseAuth.getInstance();


        // Initialize CardViews
        ImageView card1BHK = findViewById(R.id.img1bhk);
        ImageView card2BHK = findViewById(R.id.img2bhk);
        ImageView cardPG = findViewById(R.id.imgPg);  // ✅ PG CardView

        // Navigate to Property_list_1 (1 BHK)
        card1BHK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_option.this, Property_list_1.class);
                intent.putExtra("PROPERTY_TYPE", "1 BHK");
                startActivity(intent);
            }
        });

        // Navigate to Property_list_2 (2 BHK)
        card2BHK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_option.this, Property_list_2.class);
                intent.putExtra("PROPERTY_TYPE", "2 BHK");
                startActivity(intent);
            }
        });

        // ✅ Navigate to Property_list_3 (PG)
        cardPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_option.this, Property_list_3.class);
                intent.putExtra("PROPERTY_TYPE", "PG");
                startActivity(intent);
            }
        });

        // Fetch username
        fetchUsername();
    }

    private void fetchUsername() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);

            databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        username = snapshot.child("name").getValue(String.class);
                        usernameTextView.setText(username);
                    } else {
                        Toast.makeText(activity_option.this, "User data not found", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(activity_option.this, "Failed to load user data", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "No authenticated user found", Toast.LENGTH_SHORT).show();
        }
    }
}
