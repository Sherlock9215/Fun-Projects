package com.akshaykhot.score;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoOfPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_of_players);
    }

    /**
     * called when the user clicks the appropriate button
     */
    public void sendNumPlayers(View view) {

        // variable to store number of players(default is 2)
        int numPlayers = 2;

        // Find out which button was clicked, from the button(which is a view) id
        switch (view.getId()) {
            case R.id.button2:
                Button button2 = (Button) findViewById(R.id.button2);
                numPlayers = 2;
                break;
            case R.id.button3:
                Button button3 = (Button) findViewById(R.id.button3);
                numPlayers = 3;
                break;
            case R.id.button4:
                Button button4 = (Button) findViewById(R.id.button4);
                numPlayers = 4;
                break;
        }

        // Create a new intent to start new activity with the given data
        Intent intent = new Intent(this, GetPlayers.class);
        // Put the numPlayers in the intent
        intent.putExtra("Number of Players", numPlayers);
        // Start the second activity
        startActivity(intent);
    }



}
