package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.lang.annotation.Annotation;

public class FirstQuestionActivity extends AppCompatActivity {

    Button iv_8, iv_6, iv_4, iv_2;
    Handler handler;
    MediaPlayer playerWin;
    LottieAnimationView animationWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        //playerWin = findViewById(R.raw.anim_win);
        animationWin = findViewById(R.id.animation_win);

        iv_8 = findViewById(R.id.imvquestion8);
        iv_6 = findViewById(R.id.imvquestion6);
        iv_4 = findViewById(R.id.imvquestion4);
        iv_2 = findViewById(R.id.imvquestion2);


        iv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playerWin.start();
                animationWin.setVisibility(View.VISIBLE);
                handler = new Handler();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        animationWin.setVisibility(View.VISIBLE);

                    }
                };

                handler.postDelayed(runnable,5000);


            }

        });
        iv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}