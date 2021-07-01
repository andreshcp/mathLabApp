package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ThirdQuestionActivity extends AppCompatActivity {

    Button btnNextPage, btn8, btn4, btn2;
    MediaPlayer playerWin, playerLose;
    Handler handler;
    LottieAnimationView animLose_8,animLose_4,animWin_2,animWinner;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        //Animation ScaleUP/Down
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        tvSelectAnswer = findViewById(R.id.tv_select_answer);

        animLose_8 = findViewById(R.id.animation_lose_8);
        animLose_4 = findViewById(R.id.animation_lose_4);
        animWin_2 = findViewById(R.id.animation_win_2);

        playerLose = MediaPlayer.create(getApplicationContext(),R.raw.oh_no);
        playerWin = MediaPlayer.create(getApplicationContext(),R.raw.win_sound);

        btn8 = findViewById(R.id.btn8_8);
        btn4 = findViewById(R.id.btn4_8);
        btn2 = findViewById(R.id.btn2_8);
        btnNextPage = findViewById(R.id.btn_nextPage);

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
                Intent intent = new Intent(getApplicationContext(),ThirdQuestionActivity.class);
                startActivity(intent);
            }
        };

        btn8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP) {
                    animLose_8.startAnimation(scaleUp);
                } else if (event.getAction()==MotionEvent.ACTION_DOWN){
                    animLose_8.startAnimation(scaleDown);
                }
                return false;
            }
        });
        btn4.setOnTouchListener(new View.OnTouchListener() {
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

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FourQuestionActivity.class);
                startActivity(intent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose_8.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose_4.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animWin_2.setVisibility(View.VISIBLE);
                btnNextPage.setVisibility(View.VISIBLE);
                playerWin.start();
            }
        });

    }
}
