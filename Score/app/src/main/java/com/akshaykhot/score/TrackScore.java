package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TrackScore extends AppCompatActivity {

    int numPlayers;
    String player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the number of players and their names from the intent
        Intent intent = getIntent();
        numPlayers = intent.getIntExtra("Number of Players", 2);
        player1 = intent.getStringExtra("Player One");
        player2 = intent.getStringExtra("Player Two");

        // Display proper view depending on numPlayers
        switch (numPlayers) {
            case 2:
                setContentView(R.layout.two_score);

                // Get a handle on the TextViews for player names
                TextView playerOneTextView = (TextView) findViewById(R.id.textView8);
                TextView playerTwoTextView = (TextView) findViewById(R.id.textView9);
                // Set the text(names)
                playerOneTextView.setText(player1);
                playerTwoTextView.setText(player2);
                break;
            case 3:
                setContentView(R.layout.three_score);
                break;
            case 4:
                setContentView(R.layout.four_score);
                break;
        }
    }


}
