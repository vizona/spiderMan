package com.example.spiderman;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HeroPage extends AppCompatActivity {
    MediaPlayer spiderpork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.heropage_main);
        final Button buttonChange = findViewById(R.id.buttonCambiaPagina);
        final Button buttonStartEroe = findViewById(R.id.buttonStartEroe);
        final Button buttonStopEroe = findViewById(R.id.buttonStopEroe);
        buttonStopEroe.setVisibility(View.INVISIBLE);

        buttonStartEroe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spiderpork = MediaPlayer.create(getApplicationContext(),R.raw.spiderpork);
                spiderpork.start();
                buttonStartEroe.setVisibility(View.INVISIBLE);
                buttonStopEroe.setVisibility(View.VISIBLE);
            }
        });
        buttonStopEroe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSound(buttonStartEroe,buttonStopEroe);

            }
        });
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage();
            }
        });


    }
    public void changePage() {
        spiderpork.stop();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void stopSound(Button b1, Button b2) {
        spiderpork.stop();
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.INVISIBLE);
    }
}
