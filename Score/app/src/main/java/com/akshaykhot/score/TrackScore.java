package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TrackScore extends AppCompatActivity {

    int numPlayers;
    String player1, player2;
    int playerOneScore, playerTwoScore;

    @Override
    /**
     * get the numPlayers and playerNames from the intent
     * and displayes the proper view according to numPlayers
     */
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

    /**
     * when the user clicks 'add' button,
     *  1. get the numbers from the score boxes
     *  2. add the numbers to respective score
     *  3. show the numbers in the next row
     */
    public void add(View view) {

        //get the numbers from the text boxes
        EditText player1Score = (EditText) findViewById(R.id.editText7);
        int p1 = Integer.parseInt(player1Score.getText().toString());
        EditText player2Score = (EditText) findViewById(R.id.editText8);
        int p2 = Integer.parseInt(player2Score.getText().toString());

        // Add the scores into the view
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT, 1.0f);

        LinearLayout leftColumn = (LinearLayout) findViewById(R.id.leftColumn);
        TextView p1Score = new TextView(this);
        p1Score.setLayoutParams(param);
        p1Score.setText(Integer.toString(p1));
        p1Score.setGravity(Gravity.CENTER);
        p1Score.setTextSize(20);
        leftColumn.addView(p1Score);

        LinearLayout rightColumn = (LinearLayout) findViewById(R.id.rightColumn);
        TextView p2Score = new TextView(this);
        p2Score.setLayoutParams(param);
        p2Score.setText(Integer.toString(p2));
        p2Score.setGravity(Gravity.CENTER);
        p2Score.setTextSize(20);
        rightColumn.addView(p2Score);

        // Add the scores to current scores
        playerOneScore += p1;
        playerTwoScore += p2;

        // Make the fields blank for the next input
        player1Score.setText("");
        player2Score.setText("");
    }

    /**
     * when the user clicks 'finish' button,
     *  1. add all the numbers
     *  2. find the winner
     *  3. go to the 'winner' screen
     */
    public void finish(View view) {

        // Create a new intent to start new activity with the given data
        Intent intent = new Intent(this, Winner.class);
        // Put the numPlayers in the intent
        intent.putExtra("Number of Players", numPlayers);
        intent.putExtra("PlayerOne Score", playerOneScore);
        intent.putExtra("PlayerTwo Score", playerTwoScore);
        intent.putExtra("PlayerOne Name", player1);
        intent.putExtra("PlayerTwo Name", player2);

        // Start the second activity
        startActivity(intent);
    }




}
