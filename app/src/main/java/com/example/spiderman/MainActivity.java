package com.example.spiderman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonStart = findViewById(R.id.buttonStart);
        final Button buttonStop = findViewById(R.id.buttonStop);
        final Button cambiaEroe = findViewById(R.id.buttonEroe);
        buttonStop.setVisibility(View.INVISIBLE);
        cambiaEroe.setVisibility(View.INVISIBLE);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = MediaPlayer.create(getApplicationContext(), R.raw.sman);
                s1.start();
                buttonStart.setVisibility(View.INVISIBLE);
                cambiaEroe.setVisibility(View.VISIBLE);
                buttonStop.setVisibility(View.VISIBLE);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSound(buttonStart, buttonStop);
            }
        });

        cambiaEroe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage();
            }

        });

    }

    public void changePage() {
        s1.stop();
        Intent i = new Intent(this, HeroPage.class);
        startActivity(i);

    }

    public void stopSound(Button b1, Button b2) {
        s1.stop();
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.INVISIBLE);
    }

}
