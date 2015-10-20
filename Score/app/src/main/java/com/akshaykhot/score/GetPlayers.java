package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetPlayers extends AppCompatActivity {

    int numPlayers;
    String player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        numPlayers = intent.getIntExtra("Number of Players", 2);

        // Display proper view depending on numPlayers
        switch (numPlayers) {
            case 2:
                setContentView(R.layout.two_players);
                break;
            case 3:
                setContentView(R.layout.three_players);
                break;
            case 4:
                setContentView(R.layout.four_players);
                break;
        }

    }

    public void startGame(View view) {
        // Create a new intent to start new activity with the given data
        Intent intent = new Intent(this, TrackScore.class);
        // Put the numPlayers in the intent
        intent.putExtra("Number of Players", numPlayers);

        // Put the player names in the intent
        switch (numPlayers) {
            case 2:
                EditText playerOneEditText = (EditText) findViewById(R.id.editText);
                player1 = playerOneEditText.getText().toString();
                intent.putExtra("Player One", player1);

                EditText playerTwoEditText = (EditText) findViewById(R.id.editText2);
                player2 = playerTwoEditText.getText().toString();
                intent.putExtra("Player Two", player2);

                break;
            case 3:
                setContentView(R.layout.three_players);
                break;
            case 4:
                setContentView(R.layout.four_players);
                break;
        }



        // Start the second activity
        startActivity(intent);
    }
}
