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

    // Number of players
    int numPlayers;

    // Player names
    String player1, player2, player3, player4;

    // PlayerScores
    int playerOneScore, playerTwoScore, playerThreeScore, playerFourScore;

    @Override
    /**
     * get the numPlayers and playerNames from the intent
     * and displays the proper view according to numPlayers
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView playerOneTextView, playerTwoTextView, playerThreeTextView, playerFourTextView;

        // Get the number of players from the intent
        Intent intent = getIntent();
        numPlayers = intent.getIntExtra("Number of Players", 2);

        // Display proper view depending on numPlayers
        switch (numPlayers) {
            case 2:
                setContentView(R.layout.two_score);

                // Get the player names
                player1 = intent.getStringExtra("Player One");
                player2 = intent.getStringExtra("Player Two");

                // Get a handle on the TextViews for player names
                playerOneTextView = (TextView) findViewById(R.id.textView8);
                playerTwoTextView = (TextView) findViewById(R.id.textView9);
                // Set the text(names)
                playerOneTextView.setText(player1);
                playerTwoTextView.setText(player2);

                break;
            case 3:
                setContentView(R.layout.three_score);

                // Get the player names
                player1 = intent.getStringExtra("Player One");
                player2 = intent.getStringExtra("Player Two");
                player3 = intent.getStringExtra("Player Three");

                // Get a handle on the TextViews for player names
                playerOneTextView = (TextView) findViewById(R.id.textView8);
                playerTwoTextView = (TextView) findViewById(R.id.textView9);
                playerThreeTextView = (TextView) findViewById(R.id.textView10);
                // Set the text(names)
                playerOneTextView.setText(player1);
                playerTwoTextView.setText(player2);
                playerThreeTextView.setText(player3);

                break;
            case 4:
                setContentView(R.layout.four_score);

                // Get the player names
                player1 = intent.getStringExtra("Player One");
                player2 = intent.getStringExtra("Player Two");
                player3 = intent.getStringExtra("Player Three");
                player4 = intent.getStringExtra("Player Four");

                // Get a handle on the TextViews for player names
                playerOneTextView = (TextView) findViewById(R.id.textView8);
                playerTwoTextView = (TextView) findViewById(R.id.textView9);
                playerThreeTextView = (TextView) findViewById(R.id.textView10);
                playerFourTextView = (TextView) findViewById(R.id.textView11);
                // Set the text(names)
                playerOneTextView.setText(player1);
                playerTwoTextView.setText(player2);
                playerThreeTextView.setText(player3);
                playerFourTextView.setText(player4);

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

        //default parameter setup
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT, 1.0f);

        EditText player1Score, player2Score, player3Score, player4Score;
        int p1, p2, p3, p4;
        LinearLayout column1, column2, column3, column4;
        TextView p1Score, p2Score, p3Score, p4Score;

        switch(numPlayers) {

            case 2:

                //get the numbers from the text boxes
                player1Score = (EditText) findViewById(R.id.editText7);
                p1 = Integer.parseInt(player1Score.getText().toString());
                player2Score = (EditText) findViewById(R.id.editText8);
                p2 = Integer.parseInt(player2Score.getText().toString());

                // Add the scores into the view
                column1 = (LinearLayout) findViewById(R.id.Column1);
                p1Score = new TextView(this);
                p1Score.setLayoutParams(param);
                p1Score.setText(Integer.toString(p1));
                p1Score.setGravity(Gravity.CENTER);
                p1Score.setTextSize(20);
                column1.addView(p1Score);

                column2 = (LinearLayout) findViewById(R.id.Column2);
                p2Score = new TextView(this);
                p2Score.setLayoutParams(param);
                p2Score.setText(Integer.toString(p2));
                p2Score.setGravity(Gravity.CENTER);
                p2Score.setTextSize(20);
                column2.addView(p2Score);

                // Add the scores to current scores
                playerOneScore += p1;
                playerTwoScore += p2;

                // Make the fields blank for the next input
                player1Score.setText("");
                player2Score.setText("");

                break;

            case 3:

                //get the numbers from the text boxes
                player1Score = (EditText) findViewById(R.id.editText7);
                p1 = Integer.parseInt(player1Score.getText().toString());
                player2Score = (EditText) findViewById(R.id.editText8);
                p2 = Integer.parseInt(player2Score.getText().toString());
                player3Score = (EditText) findViewById(R.id.editText9);
                p3 = Integer.parseInt(player3Score.getText().toString());

                // Add the scores into the view
                column1 = (LinearLayout) findViewById(R.id.Column1);
                p1Score = new TextView(this);
                p1Score.setLayoutParams(param);
                p1Score.setText(Integer.toString(p1));
                p1Score.setGravity(Gravity.CENTER);
                p1Score.setTextSize(20);
                column1.addView(p1Score);

                column2 = (LinearLayout) findViewById(R.id.Column2);
                p2Score = new TextView(this);
                p2Score.setLayoutParams(param);
                p2Score.setText(Integer.toString(p2));
                p2Score.setGravity(Gravity.CENTER);
                p2Score.setTextSize(20);
                column2.addView(p2Score);

                column3 = (LinearLayout) findViewById(R.id.Column3);
                p3Score = new TextView(this);
                p3Score.setLayoutParams(param);
                p3Score.setText(Integer.toString(p3));
                p3Score.setGravity(Gravity.CENTER);
                p3Score.setTextSize(20);
                column3.addView(p3Score);

                // Add the scores to current scores
                playerOneScore += p1;
                playerTwoScore += p2;
                playerThreeScore += p3;


                // Make the fields blank for the next input
                player1Score.setText("");
                player2Score.setText("");
                player3Score.setText("");

                break;

            case 4:

                //get the numbers from the text boxes
                player1Score = (EditText) findViewById(R.id.editText7);
                p1 = Integer.parseInt(player1Score.getText().toString());
                player2Score = (EditText) findViewById(R.id.editText8);
                p2 = Integer.parseInt(player2Score.getText().toString());
                player3Score = (EditText) findViewById(R.id.editText9);
                p3 = Integer.parseInt(player3Score.getText().toString());
                player4Score = (EditText) findViewById(R.id.editText10);
                p4 = Integer.parseInt(player4Score.getText().toString());

                // Add the scores into the view
                column1 = (LinearLayout) findViewById(R.id.Column1);
                p1Score = new TextView(this);
                p1Score.setLayoutParams(param);
                p1Score.setText(Integer.toString(p1));
                p1Score.setGravity(Gravity.CENTER);
                p1Score.setTextSize(20);
                column1.addView(p1Score);

                column2 = (LinearLayout) findViewById(R.id.Column2);
                p2Score = new TextView(this);
                p2Score.setLayoutParams(param);
                p2Score.setText(Integer.toString(p2));
                p2Score.setGravity(Gravity.CENTER);
                p2Score.setTextSize(20);
                column2.addView(p2Score);

                column3 = (LinearLayout) findViewById(R.id.Column3);
                p3Score = new TextView(this);
                p3Score.setLayoutParams(param);
                p3Score.setText(Integer.toString(p3));
                p3Score.setGravity(Gravity.CENTER);
                p3Score.setTextSize(20);
                column3.addView(p3Score);

                column4 = (LinearLayout) findViewById(R.id.Column4);
                p4Score = new TextView(this);
                p4Score.setLayoutParams(param);
                p4Score.setText(Integer.toString(p4));
                p4Score.setGravity(Gravity.CENTER);
                p4Score.setTextSize(20);
                column4.addView(p4Score);

                // Add the scores to current scores
                playerOneScore += p1;
                playerTwoScore += p2;
                playerThreeScore += p3;
                playerFourScore += p4;

                // Make the fields blank for the next input
                player1Score.setText("");
                player2Score.setText("");
                player3Score.setText("");
                player4Score.setText("");

                break;
        }


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
        intent.putExtra("PlayerThree Score", playerThreeScore);
        intent.putExtra("PlayerFour Score", playerFourScore);

        intent.putExtra("PlayerOne Name", player1);
        intent.putExtra("PlayerTwo Name", player2);
        intent.putExtra("PlayerThree Name", player3);
        intent.putExtra("PlayerFour Name", player4);

        // Start the second activity
        startActivity(intent);
    }




}
