package com.example.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;


//maybe better renamed as GameManager or game or something.
class Player{
    private long bankBalance = 0;
    private long totalGps = 0;
    private long clickPower = 1;
    //maybe have your base power + modified power? (1 click is worth 1% of your levels in whoever or whatever)

    //long clickPowerMultiplyer = 1;
    //int[][] quest progress
    //int[][] jobData (levels, if unlocked, etc)
    ///quest and job data can likely be combined

    public Player(){

        //if new game, do stuff
        //else load data?



    }

    public long getBalance(){
        return bankBalance;
    }

    public void addFunds(long money){
        bankBalance += money;
    }

    public void spendFunds(long payment){
        if(canAfford(payment)){
            bankBalance -= payment;
        }
        else{
            //error message window: "not enough gold" or whatever? should be handled before this point though
        }
    }

    public boolean canAfford(long cost){
        boolean canAfford = (cost <= bankBalance);

        return canAfford;
    }

    public long getClickPower(){
        return clickPower;
    }

    public void addClickPower(long num){
        clickPower += num;
    }

    //public void setBaseClickPower

    public void setTotalGps(long newGps){
        totalGps = newGps;
        //or if jobs are included here, call all their gps.
    }

    public long getTotalGps(){
        return totalGps;
    }




    public void update(){

    }

    //saveGame()?
    //loadGame()?

}

class Job {
    //Button button; //might not be needed. their "button" can just call a function to send data to what is necessary
    private String name;
    private int baseGold;
    private int level = 0;
    private long costOfNextLevel;
    //long nextLevelGrowthRate = 1.1;
    private int multiplier = 1;
    private long gps;
    private Boolean active = false;
    Boolean isNext = false;
    //int totalGoldGained = 0;


    public Job(int baseGoldValue) {

        //button = myButton;
        baseGold = baseGoldValue;
        name = "Gain " + baseGold + "g per second";
        costOfNextLevel = baseGold * 10;
        //nextLevelGrowthRate = costOfNextLevel

        //button.setVisibility(View.INVISIBLE);
        //button.setClickable(false);

        update();
    }

    public long getGps(){
        update();
        //totalGain += gps;
        return gps;
    }


    public void setMult(int mod){


    }

    public void buyLevel(int quantity){

        level += quantity;
        costOfNextLevel = (long)(costOfNextLevel *(Math.pow( (1.01), quantity)));
        update();

    }

    public long getCostOfLevels(int quantity){
        long totalCost = costOfNextLevel;

        return totalCost;
    }

    public boolean isActive(){
        return active;
    }


    public void setActive(){
        active = true;
        //button.setVisibility(View.VISIBLE);

        //button.setClickable(true);
    }

    public void update(){
        gps = baseGold * level;
        updateName();
    }

    private void updateName(){
        name = "Gaining " + gps + " gold per second\nCost for next level: " + costOfNextLevel;
        //button.setText(name);
    }

}

public class MainActivity extends AppCompatActivity {

    Player player;
    private Handler handler;

    private Job levelOne, levelTwo, levelThree, levelFour;

    //general formula to calculate how much an upgrade costs (exponential)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if no saved data
        player = new Player();
        //else load saved data

        handler = new Handler();
        handler.postDelayed(runnable, 1000);


        levelOne = new Job(1);
        levelOne.setActive();

        levelTwo = new Job(10);
        //levelTwo.setIsNext();


        update();

    }



    private Runnable runnable = new Runnable() {
        public void run() {
            int delay = 1000;
            update();

            long totalGps = 0;

            totalGps += (levelOne.getGps() + levelTwo.getGps());

            player.addFunds(totalGps);


            update();
            handler.postDelayed(this, delay);
        }
    };

    public void update(){
        //update the texts of all buttons, etc, etc

        levelOne.update();
        levelTwo.update();

        TextView txt = findViewById(R.id.txtClicks);
        txt.setText("Gold: " + player.getBalance() + "\n");
    }



    public void goldMineClicked(View view){
        player.addFunds(player.getClickPower());

        update();
    }

    public void goToUpgrade(View view) {
        //create the object to allow the second activity to start
        Intent IntentUpgrade = new Intent(this,SecondActivity.class);
        startActivity(IntentUpgrade);
    }

    public void goToStore( View view){
        Intent IntentStore = new Intent( this, Store.class);
        setContentView(R.layout.activity_main);
    }



}


//for buy max, can just do buy level while canAfford
//way to better do a 1 time call "this happened, so do this, then never check this condition again"
//pause/reset buttons for testing


/*
need:
check upgrade
update gold total>
open IAP store
open house
open (jobs/townhall)
close window / back
large num function/format (if funds > 1 trillion, switch to formate or something)
-music/sounds
mute

notes:
initial quest be something like "build a house so a blacksmith can move in" knid of thing?
 */

