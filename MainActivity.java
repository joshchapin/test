package com.example.myapplication;

//Devan was here

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
//bleeeeeeeeeeeeeeeeeeeeeeh
    //Blorg
    public void loanMe(View view)
    {
       Toast myToast =  Toast.makeText(this, "You got 1 million dollars", Toast.LENGTH_SHORT);
       myToast.show();
       setMoney(view);

    }

    public void setMoney(View view)
    {
        TextView loanAmountTextView = findViewById(R.id.Money);
        String moneyString = loanAmountTextView.getText().toString();
        money = Integer.parseInt(moneyString);
        money++;
        loanAmountTextView.setText(money.toString());
    }
    public void goToUpgrade(View view)
    {
        //create the object to allow the second activity to start
        Intent IntentUpgrade = new Intent(this,SecondActivity.class);
        startActivity(IntentUpgrade);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout layoutTest = new LinearLayout(this);
//        ImageView imageTest = new ImageView(this);
//
//        imageTest.setImageResource(R.drawable.Sample);
//        imageTest.setAdjustViewBounds(true);
//        imageTest.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        layoutTest.addView(imageTest);
//        setContentView(layoutTest);

    }
}
