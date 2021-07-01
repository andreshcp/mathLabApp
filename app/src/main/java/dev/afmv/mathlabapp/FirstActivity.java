package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    private Button btnNextPage, btnReturnPage;
    MediaPlayer player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        player1 = MediaPlayer.create(getApplicationContext(),R.raw.audio1_1);

        btnNextPage = findViewById(R.id.btn_nextPage);
        btnReturnPage = findViewById(R.id.btn_returnPage);

        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                btnNextPage.setVisibility(View.VISIBLE);
            }
        };*/

        btnReturnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //runnable.run();

    }

    @Override
    protected void onStart() {
        Runnable runna = new Runnable() {
            @Override
            public void run() {

                btnNextPage.setVisibility(View.VISIBLE);
                btnReturnPage.setVisibility(View.VISIBLE);
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runna,8000);
        player1.start();
        super.onStart();
    }

    @Override
    protected void onStop() {
        player1.stop();
        super.onStop();
    }
}