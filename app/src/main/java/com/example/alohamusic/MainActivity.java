package com.example.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnUkelele, btnDrums;
    private MediaPlayer mpUkelele, mpDrums;

    private int isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the button
        btnUkelele = findViewById(R.id.btnUkulele);
        btnDrums = findViewById(R.id.btnDrums);

        // set the listeners for each button to the respective object below
        btnUkelele.setOnClickListener(listenerUkelele);
        btnDrums.setOnClickListener(listenerDrums);

        // set the Media Players
        mpUkelele = new MediaPlayer();
        mpUkelele = MediaPlayer.create(this, R.raw.ukulele);

        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        isPlaying = 0;
    }

    // listener object for Ukelele button
    Button.OnClickListener listenerUkelele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (isPlaying){
                //Music is Pause
                case 0:
                    mpUkelele.start();
                    isPlaying = 1;
                    btnUkelele.setText(R.string.btnUkulelePause);
                    btnDrums.setVisibility(View.INVISIBLE);
                    break;

                case 1:
                    mpUkelele.pause();
                    isPlaying = 0;
                    btnUkelele.setText(R.string.btnUkulele);
                    btnDrums.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    // listener object for Drums button
    Button.OnClickListener listenerDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (isPlaying){
                //Music is Pause
                case 0:
                    mpDrums.start();
                    isPlaying = 1;
                    btnDrums.setText(R.string.btnDrumsPause);
                    btnUkelele.setVisibility(View.INVISIBLE);
                    break;

                //Music is already playing
                case 1:
                    mpDrums.pause();
                    isPlaying = 0;
                    btnDrums.setText(R.string.btnDrums);
                    btnUkelele.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

}
