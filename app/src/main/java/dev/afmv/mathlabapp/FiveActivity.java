package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class FiveActivity extends AppCompatActivity {

    private Button btnNextPage, btnReturnPage;
    MediaPlayer player5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        player5 = MediaPlayer.create(this,R.raw.audio_5);
        btnNextPage = findViewById(R.id.btn_nextPage);
        btnReturnPage = findViewById(R.id.btn_returnPage);
        btnReturnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FourActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SixActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
        player5.start();
        super.onStart();
    }

    @Override
    protected void onStop() {
        player5.stop();
        super.onStop();
    }
}