package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetPlayers extends AppCompatActivity {

    int numPlayers;
    String player1, player2, player3, player4;

    @Override
    /**
     * displays proper view according to numPlayers
     */
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

    /**
     * called when the user clicks the 'start' button
     * takes player names as input according to numPlayers
     * calls the activity to start tracking scores
     */
    public void startGame(View view) {

        EditText playerOneEditText, playerTwoEditText, playerThreeEditText, playerFourEditText;
        // Create a new intent to start new activity with the given data
        Intent intent = new Intent(this, TrackScore.class);
        // Put the numPlayers in the intent
        intent.putExtra("Number of Players", numPlayers);

        // Put the player names in the intent
        switch (numPlayers) {
            case 2:
                playerOneEditText = (EditText) findViewById(R.id.editText);
                player1 = playerOneEditText.getText().toString();
                intent.putExtra("Player One", player1);

                playerTwoEditText = (EditText) findViewById(R.id.editText2);
                player2 = playerTwoEditText.getText().toString();
                intent.putExtra("Player Two", player2);

                break;
            case 3:
                playerOneEditText = (EditText) findViewById(R.id.editText);
                player1 = playerOneEditText.getText().toString();
                intent.putExtra("Player One", player1);

                playerTwoEditText = (EditText) findViewById(R.id.editText2);
                player2 = playerTwoEditText.getText().toString();
                intent.putExtra("Player Two", player2);

                playerThreeEditText = (EditText) findViewById(R.id.editText3);
                player3 = playerThreeEditText.getText().toString();
                intent.putExtra("Player Three", player3);

                break;
            case 4:
                playerOneEditText = (EditText) findViewById(R.id.editText);
                player1 = playerOneEditText.getText().toString();
                intent.putExtra("Player One", player1);

                playerTwoEditText = (EditText) findViewById(R.id.editText2);
                player2 = playerTwoEditText.getText().toString();
                intent.putExtra("Player Two", player2);

                playerThreeEditText = (EditText) findViewById(R.id.editText3);
                player3 = playerThreeEditText.getText().toString();
                intent.putExtra("Player Three", player3);

                playerFourEditText = (EditText) findViewById(R.id.editText4);
                player4 = playerFourEditText.getText().toString();
                intent.putExtra("Player Four", player4);

                break;
        }

        // Start the second activity
        startActivity(intent);
    }
}
