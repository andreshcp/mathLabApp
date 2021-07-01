package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

import okio.AsyncTimeout;

public class SecondQuestionActivity extends AppCompatActivity {

    Button iv_8, iv_1, iv_4, iv_2,btnNextPage;
    MediaPlayer playerWin,playerLose,onBack;
    LottieAnimationView animLose_1,animLose_2,animLose_8,animLose_4,animWinner;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);
        //Animation ScaleUP/Down
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);
        //TextView
        tvSelectAnswer = findViewById(R.id.tv_select_answer);

        //Buttons
        btnNextPage = findViewById(R.id.btn_nextPage);
        iv_1 = findViewById(R.id.imvquestion1_8);
        iv_2 = findViewById(R.id.imvquestion2_8);
        iv_8 = findViewById(R.id.imvquestion8_8);
        iv_4 = findViewById(R.id.imvquestion4_8);

        //Animations
        animLose_1 = findViewById(R.id.animation_lose_1);
        animLose_2 = findViewById(R.id.animation_lose_2);
        animLose_8 = findViewById(R.id.animation_lose_8);
        animLose_4 = findViewById(R.id.animation_lose_4);
        animWinner = findViewById(R.id.animation_winner);



        //Sounds
        playerWin = MediaPlayer.create(this,R.raw.win_sound);
        playerLose = MediaPlayer.create(this,R.raw.fail_trumpet);
        onBack = MediaPlayer.create(this,R.raw.oh_no);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //onBack.start();
                Intent intent = new Intent(getApplicationContext(),SecondQuestionActivity.class);
                startActivity(intent);
            }
        };



        iv_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    animLose_1.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN){
                    animLose_1.startAnimation(scaleDown);


                }
                return false;
            }

        });
        iv_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    animLose_2.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN){
                    animLose_2.startAnimation(scaleDown);
                }
                return false;
            }
        });
        iv_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    animLose_4.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN){
                    animLose_4.startAnimation(scaleDown);
                }
                return false;
            }
        });

        iv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnNextPage.setVisibility(View.VISIBLE);
                animWinner.setVisibility(View.VISIBLE);
                animLose_8.setVisibility(View.VISIBLE);
                animLose_8.setAnimation(R.raw.trilo_3);
                playerWin.start();



            }
        });
        iv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animLose_1.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }

        });
        iv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animLose_2.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();

            }
        });
        iv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animLose_4.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ThirdQuestionActivity.class);
                startActivity(intent);

            }
        });

    }

}