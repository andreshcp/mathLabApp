package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;

    MediaPlayer playerSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        playerSplash = MediaPlayer.create(this,R.raw.start_sound_splash);


    }

    @Override
    protected void onStart() {
        playerSplash.start();

        handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(),FirstActivity.class);
                startActivity(intent);
            }
        };

        handler.postDelayed(runnable,5000);
        super.onStart();
    }
}