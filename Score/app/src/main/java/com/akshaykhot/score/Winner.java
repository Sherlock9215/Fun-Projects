package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_two);

        String player1, player2;
        int playerOneScore, playerTwoScore;

        // Get the message from the intent
        Intent intent = getIntent();
        player1 = intent.getStringExtra("PlayerOne Name");
        player2 = intent.getStringExtra("PlayerTwo Name");
        playerOneScore = intent.getIntExtra("PlayerOne Score", 0);
        playerTwoScore = intent.getIntExtra("PlayerTwo Score", 0);

        // Get a handle on the TextViews for player names
        TextView winnerTextView = (TextView) findViewById(R.id.textView12);
        // Set the text(name of the winner)
        if (playerOneScore > playerTwoScore) {
            winnerTextView.setText("Winner is: " + player1);
        } else if (playerTwoScore > playerOneScore){
            winnerTextView.setText("Winner is: " + player2);
        } else {
            winnerTextView.setText("Score is tied");
        }

        // Display all the scores
        TextView playerOneTextView = (TextView) findViewById(R.id.textView15);
        TextView playerTwoTextView = (TextView) findViewById(R.id.textView16);
        playerOneTextView.setText(player1 + ": " + playerOneScore);
        playerTwoTextView.setText(player2 + ": " + playerTwoScore);
    }
}
