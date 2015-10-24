package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.*;

public class Winner extends AppCompatActivity {

    // Number of players
    int numPlayers;

    // Player names
    String player1, player2, player3, player4;

    // PlayerScores
    int playerOneScore, playerTwoScore, playerThreeScore, playerFourScore;

    @Override
    /**
     * called when the user clicks the 'finish' button
     * displays winner from the player scores
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView winnerTextView;
        TextView playerOneTextView, playerTwoTextView, playerThreeTextView, playerFourTextView;
        TreeMap<Integer, String> playerNameToScore;
        NavigableMap sortedplayerNameToScore;

        // Get the message from the intent
        Intent intent = getIntent();
        numPlayers = intent.getIntExtra("Number of Players", 2);

        switch (numPlayers) {

            case 2:

                setContentView(R.layout.winner_two);
                player1 = intent.getStringExtra("PlayerOne Name");
                player2 = intent.getStringExtra("PlayerTwo Name");
                playerOneScore = intent.getIntExtra("PlayerOne Score", 0);
                playerTwoScore = intent.getIntExtra("PlayerTwo Score", 0);

                // Get a handle on the TextViews for player names
                winnerTextView = (TextView) findViewById(R.id.textView12);
                // Set the text(name of the winner)
                if (playerOneScore > playerTwoScore) {
                    winnerTextView.setText("Winner is: " + player1);
                } else if (playerTwoScore > playerOneScore) {
                    winnerTextView.setText("Winner is: " + player2);
                } else {
                    winnerTextView.setText("Score is tied");
                }

                // Display all the scores
                playerOneTextView = (TextView) findViewById(R.id.textView15);
                playerTwoTextView = (TextView) findViewById(R.id.textView16);

                playerOneTextView.setText(player1 + ": " + playerOneScore);
                playerTwoTextView.setText(player2 + ": " + playerTwoScore);

                break;

            case 3:

                setContentView(R.layout.winner_three);
                player1 = intent.getStringExtra("PlayerOne Name");
                player2 = intent.getStringExtra("PlayerTwo Name");
                player3 = intent.getStringExtra("PlayerThree Name");
                playerOneScore = intent.getIntExtra("PlayerOne Score", 0);
                playerTwoScore = intent.getIntExtra("PlayerTwo Score", 0);
                playerThreeScore = intent.getIntExtra("PlayerThree Score", 0);

                // Get a handle on the TextViews for player names
                winnerTextView = (TextView) findViewById(R.id.textView12);

                // Find the winner by sorting the scores
                playerNameToScore = new TreeMap<Integer, String>();
                playerNameToScore.put(playerOneScore, player1);
                playerNameToScore.put(playerTwoScore, player2);
                playerNameToScore.put(playerThreeScore, player3);

                // Sort the players according to score in descending order
                sortedplayerNameToScore = playerNameToScore.descendingMap();

                // Set the text(name of the winner)
                winnerTextView.setText(sortedplayerNameToScore.firstEntry().getValue() + " is Winner");

                // Display all the scores in descending order
                playerOneTextView = (TextView) findViewById(R.id.textView15);
                playerTwoTextView = (TextView) findViewById(R.id.textView16);
                playerThreeTextView = (TextView) findViewById(R.id.textView17);

                playerOneTextView.setText(player1 + ": " + playerOneScore);
                playerTwoTextView.setText(player2 + ": " + playerTwoScore);
                playerThreeTextView.setText(player3 + ": " + playerThreeScore);

                break;

            case 4:

                setContentView(R.layout.winner_four);

                player1 = intent.getStringExtra("PlayerOne Name");
                player2 = intent.getStringExtra("PlayerTwo Name");
                player3 = intent.getStringExtra("PlayerThree Name");
                player4 = intent.getStringExtra("PlayerFour Name");
                playerOneScore = intent.getIntExtra("PlayerOne Score", 0);
                playerTwoScore = intent.getIntExtra("PlayerTwo Score", 0);
                playerThreeScore = intent.getIntExtra("PlayerThree Score", 0);
                playerFourScore = intent.getIntExtra("PlayerFour Score", 0);

                // Get a handle on the TextViews for player names
                winnerTextView = (TextView) findViewById(R.id.textView12);

                // Find the winner by sorting the scores
                playerNameToScore = new TreeMap<Integer, String>();
                playerNameToScore.put(playerOneScore, player1);
                playerNameToScore.put(playerTwoScore, player2);
                playerNameToScore.put(playerThreeScore, player3);
                playerNameToScore.put(playerFourScore, player4);

                // Sort the players according to score in descending order
                sortedplayerNameToScore = playerNameToScore.descendingMap();

                // Set the text(name of the winner)
                winnerTextView.setText(sortedplayerNameToScore.firstEntry().getValue() + " is Winner");

                // Display all the scores in descending order
                playerOneTextView = (TextView) findViewById(R.id.textView15);
                playerTwoTextView = (TextView) findViewById(R.id.textView16);
                playerThreeTextView = (TextView) findViewById(R.id.textView17);
                playerFourTextView = (TextView) findViewById(R.id.textView18);

                playerOneTextView.setText(player1 + ": " + playerOneScore);
                playerTwoTextView.setText(player2 + ": " + playerTwoScore);
                playerThreeTextView.setText(player3 + ": " + playerThreeScore);
                playerFourTextView.setText(player4 + ": " + playerFourScore);

                break;
        }

    }

}
