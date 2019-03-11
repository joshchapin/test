package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Store extends AppCompatActivity {

    public void backButton(View view)
    {
        Intent goBack = new Intent(this,MainActivity.class);
        startActivity(goBack);
    }

    public void Buy_Pressed(View view)
    {
        Toast myToast;
        switch (view.getId())
        {
            case R.id.First_Button:
                 myToast =  Toast.makeText(this, "You bought 24 hours skip", Toast.LENGTH_SHORT);
                break;
            case R.id.Second_Button:
                myToast =  Toast.makeText(this, "You bought 48 hours skip", Toast.LENGTH_SHORT);
                break;
            case R.id.Third_Button:
                myToast =  Toast.makeText(this, "You bought 72 hours skip", Toast.LENGTH_SHORT);
                break;
                default:
                    myToast =  Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT);

        }
        myToast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
    }
}
