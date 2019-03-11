package com.example.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

public static Integer money;



    public void goToUpgrade(View view)
    {
        //create the object to allow the second activity to start
        Intent IntentUpgrade = new Intent(this,SecondActivity.class);
        startActivity(IntentUpgrade);
    }
    public void goToStore(View view)
    {
        Intent IntentStore = new Intent(this,Store.class);
        startActivity(IntentStore);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
