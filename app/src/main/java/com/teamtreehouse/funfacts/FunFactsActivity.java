package com.teamtreehouse.funfacts;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    final ColorWheel mColorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare View variables and assgin them to Views frim the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] facts = {
                        "Ants stretch when they wake up in the morning.",
                        "Ostriches can run faster than horses.",
                        "Olympic gold medals are actually made mostly of silver.",
                        "You are born with 300 bones; by the time you are an adult you will have 206.",
                        "It takes about 8 minutes for light from the Sun to reach Earth.",
                        "Some bamboo plants can grow almost a meter in just one day.",
                        "The state of Florida is bigger than England.",
                        "Some penguins can leap 2-3 meters out of the water.",
                        "On average, it takes 66 days to form a new habit.",
                        "Mammoths still walked the earth when the Great Pyramid was being built." };

                // the button was clicked, so update e fact label with a new fact
                String fact = ""; //"Ostriches can run faster than horses";

                //randomly select a fact
                Random randomGenerator = new Random(); //Construct a new Random number generator

                int randomNumber = randomGenerator.nextInt(3); //from 0 - 2
                fact = randomNumber + "";

                /* Convert the randomNumber to a text fact
                 * 0 = Ants stretch when they wake up in the morning.
                 * 1 = Ostriches can run faster than horses.
                 * 2 = Olympic gold medals are actually made mostly of silver.
                 */
                switch (randomNumber){
                    case 0:
                        fact = "Ants stretch when they wake up in the morning.";
                        break;
                    case 1:
                        fact = "Ostriches can run faster than horses.";
                        break;
                    case 2:
                        fact = "Olympic gold medals are actually made mostly of silver.";
                        break;
                }

                //update the label with our dynamic fact
                factLabel.setText(fact);
                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                color = mColorWheel.getColor();
                factLabel.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Message is created!", Toast.LENGTH_LONG).show();
        Log.d("FunFactsActivity", "from onCreated() method!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
