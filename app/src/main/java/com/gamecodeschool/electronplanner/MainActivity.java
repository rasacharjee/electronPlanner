package com.gamecodeschool.electronplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.layStart);

        layout.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext(),electronAdmin.class));
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeLeft();
                startActivity(new Intent(getApplicationContext(),electronUser.class));
            }
            });
    }
}
