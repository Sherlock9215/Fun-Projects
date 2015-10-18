package com.akshaykhot.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /**
     * called when the user clicks the Send button
     */
    public void startApp(View view) {

        // Do something in responses to the button
        Intent intent = new Intent(this, NumPlayers.class);
        startActivity(intent);
    }
}
