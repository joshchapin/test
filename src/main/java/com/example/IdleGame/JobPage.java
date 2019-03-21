package com.example.IdleGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JobPage extends AppCompatActivity {

    String buyAmounts[] = {"x1", "x10", "x25", "x100"};//, "xMAX"};
    int buyAmountSelection;
    int buyAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_page);

        buyAmountSelection = 0;
        buyAmount = 1;
        //save/load previously selected choice

        updateText();

    }

    public void backButton(View view) {
        finish();
    }

    public void cycleBuyAmount(View view){
        //4 when including max
        if(buyAmountSelection == 3){
            buyAmountSelection = 0;
        }
        else{
            buyAmountSelection++;
        }

        updateText();
    }

    public void updateText(){
        TextView buyText = findViewById(R.id.txtBuyAmount);
        buyText.setText( "Buy: " + buyAmounts[buyAmountSelection]);

        TextView job1 = findViewById(R.id.txtJob1);
        TextView job2 = findViewById(R.id.txtJob2);
        TextView job3 = findViewById(R.id.txtJob3);
        TextView job4 = findViewById(R.id.txtJob4);
        TextView job5 = findViewById(R.id.txtJob5);

        job1.setText("Cost: " + MainPage.player.jobList[0].getCostOfLevels(1));
        job2.setText("Cost: " + MainPage.player.jobList[1].getCostOfLevels(1));
        job3.setText("Cost: " + MainPage.player.jobList[2].getCostOfLevels(1));
        job4.setText("Cost: " + MainPage.player.jobList[3].getCostOfLevels(1));
        job5.setText("Cost: " + MainPage.player.jobList[4].getCostOfLevels(1));



    }

    public void levelUp(View view) {

        switch(buyAmountSelection){
            case 0:
                buyAmount = 1;
                break;
            case 1:
                buyAmount = 10;
                break;
            case 2:
                buyAmount = 25;
                break;
            case 3:
                buyAmount = 100;
                break;
            //case 4: buyAmount = call and see what can be afforded
        }


        String upgradeText = "You bought " + buyAmount + " ";
        LayoutInflater inflater = getLayoutInflater();
        //get the view from the xml file to use as the visual part of the notification
        View toastLayout = inflater.inflate(R.layout.popup_window,null);
        //Gets what text object to put the string onto
        TextView header = toastLayout.findViewById(R.id.Pop_upText);

        //

        int jobTier = -1;

        switch (view.getId()) {
            case(R.id.btnBuyJob1):
                upgradeText = upgradeText.concat(getString(R.string.Job1));
                jobTier = 0;
                break;
            case(R.id.btnBuyJob2):
                upgradeText = upgradeText.concat(getString(R.string.Job2));
                jobTier = 1;
                break;
            case(R.id.btnBuyJob3):
                upgradeText = upgradeText.concat(getString(R.string.Job3));
                jobTier = 2;
                break;
            case(R.id.btnBuyJob4):
                upgradeText = upgradeText.concat(getString(R.string.Job4));
                jobTier = 3;
                break;
            case(R.id.btnBuyJob5):
                upgradeText =  upgradeText.concat(getString(R.string.Job5));
                jobTier = 4;
                break;

            default:
                upgradeText =   upgradeText.concat("error");
        }


        if(jobTier != -1){
            long cost = MainPage.player.jobList[jobTier].getCostOfLevels(1);
            if(MainPage.player.canAfford(cost)){
                MainPage.player.spendFunds(cost);
                MainPage.player.jobList[jobTier].buyLevel(1);
                MainPage.player.update();
            }
        }

        header.setText(upgradeText);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();

        updateText();

    }

}
