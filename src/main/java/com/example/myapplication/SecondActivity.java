package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public void backButton(View view)
    {
        Intent goBack = new Intent(this,MainActivity.class);
        startActivity(goBack);
    }

    public void levelUp(View view)
    {
        Toast myToast =  Toast.makeText(this, "Need Visual for button presses", Toast.LENGTH_SHORT);
        myToast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
