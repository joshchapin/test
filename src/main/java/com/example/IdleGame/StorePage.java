package com.example.IdleGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StorePage extends AppCompatActivity {

    public void backButton(View view)
    {
        finish();
    }

    public void Buy_Pressed(View view) {
        LayoutInflater inflater = getLayoutInflater();
        //get the view from the xml file to use as the visual part of the notification
        View toastLayout = inflater.inflate(R.layout.popup_window,null);
        //Gets what text object to put the string onto
        TextView header = toastLayout.findViewById(R.id.Pop_upText);
        switch (view.getId())
        {
            case R.id.First_Button:

                 header.setText(getString(R.string.Store_Message,"24 hours"));
                //myToast =  Toast.makeText(this, "You bought 24 hours skip", Toast.LENGTH_SHORT);
                break;
            case R.id.Second_Button:
                header.setText(getString(R.string.Store_Message,"48 hours"));
                //myToast =  Toast.makeText(this, "You bought 48 hours skip", Toast.LENGTH_SHORT);
                break;
            case R.id.Third_Button:
                header.setText(getString(R.string.Store_Message,"72 hours"));
                //myToast =  Toast.makeText(this, "You bought 72 hours skip", Toast.LENGTH_SHORT);
                break;
            case R.id.Special_button:
                header.setText("Donate To Poor College Students");
                //myToast =  Toast.makeText(this, "Donate to Poor College Students", Toast.LENGTH_SHORT);
                break;
            case R.id.Special_button2:
                header.setText("Upcoming Trump Reskin");
                //myToast =  Toast.makeText(this, "Trump Idle ReSkin??", Toast.LENGTH_SHORT);
                break;
                default:
                    header.setText("ERROR");
                    //myToast =  Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT);

        }

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_page);
    }
}
