package com.example.IdleGame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    public static Player player;
    //should this be static?
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        //first load load screen until game is loaded, then switch to main once done

        //if no saved data
        player = new Player();
        //else load saved data
        //player.loadData();

        handler = new Handler();
        handler.postDelayed(runnable, 1000);


        update();
    }

    private Runnable runnable = new Runnable() {
        public void run() {
            int delay = 1000;

            player.addFunds(player.getTotalGps());


            update();
            handler.postDelayed(this, delay);
        }
    };

    public void update(){
        //update the texts of all buttons, etc, etc



        TextView txt = findViewById(R.id.txtTotalGold);
        txt.setText("Gold: " + player.getBalance() + "\n"
                + "GPS: " + player.getTotalGps());
    }



    public void goldMineClicked(View view){
        player.addFunds(player.getBaseClickPower());

        update();
    }

    public void openJobPage(View view) {
        //create the object to allow the second activity to start
        Intent IntentUpgrade = new Intent(this, JobPage.class);
        startActivity(IntentUpgrade);
    }

    public void openStorePage(View view){
        Intent IntentUpgrade = new Intent(this, StorePage.class);
        startActivity(IntentUpgrade);
       // setContentView(R.layout.MainPage);
    }

    //public void openHouse


    public void makePopupWindow(View view) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);


            View popupView = inflater.inflate(R.layout.popup_window, null);

        //****TRYING TO GET THIS TO WORK*****create dynamic string for popup depending on which is clicked
        //by it's Id name and level passed as parameters
        //String test = getString(R.string.DummyPopup,String.valueOf(view.getId()),1);
        // TextView text = popupView.findViewById(R.id.textView);
        //text.setText(test);
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);



        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    //copy of popup window for opening the recap
    public void makeRecapPopupWindow(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.recap_window, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}



