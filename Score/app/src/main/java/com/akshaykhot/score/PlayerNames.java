package com.akshaykhot.score;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayerNames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        // Get the message from the intent
        Intent intent = getIntent();
        int numPlayers = intent.getIntExtra("Number of Players", 4);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("No. of Players: " + numPlayers);


/*
        // Create the appropriate display depending on number of players
        switch (numPlayers) {
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
*/
    }


}
