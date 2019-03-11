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
        String upgradeText = "You upgraded ";
        switch (view.getId())
        {
            case(R.id.jobLevel):
                upgradeText = upgradeText.concat("Stable");
                break;
            case(R.id.jobLevel2):
                upgradeText = upgradeText.concat("Carpenter");
                break;
            case(R.id.jobLevel3):
                upgradeText = upgradeText.concat("Mining");
                break;
            case(R.id.jobLevel4):
                upgradeText = upgradeText.concat("GraveDigging");
                break;
            case(R.id.jobLevel5):
                upgradeText =  upgradeText.concat("Necromancy");
                break;

                default:
                    upgradeText =   upgradeText.concat("error");
        }
        Toast myToast =  Toast.makeText(this, upgradeText,Toast.LENGTH_SHORT);
        myToast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
