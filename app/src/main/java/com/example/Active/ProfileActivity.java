package com.example.Active;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.model.User;
import com.example.model.UserManager;
import com.example.teamprm392.R;

public class ProfileActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    //set text view
    TextView phoneNumber;
    TextView name;
    TextView address;

    TextView btn_logout;

    private void bottomNavigation(){
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
//        LinearLayout profileBtn=findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, CartActivity.class));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigation();

        //get and show user detail
        phoneNumber = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        btn_logout = findViewById(R.id.btn_logout);

        UserManager userManager = new UserManager();

        User user = userManager.getUser();

        phoneNumber.setText("Phone number: "+user.getPhoneNumber());
        name.setText("Name: "+user.getName());
        address.setText("Address: "+user.getAddress());

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.logout();
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            }
        });
    }
}