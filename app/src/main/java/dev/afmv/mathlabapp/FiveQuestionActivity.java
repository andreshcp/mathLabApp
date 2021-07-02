package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class FiveQuestionActivity extends AppCompatActivity {

    MediaPlayer playerWin, playerLose;
    LottieAnimationView animLose, animWin;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;
    Button btn716, btn78, btn1640, btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_question);

        btnNextPage = findViewById(R.id.btn_nextPage);
        btn716 = findViewById(R.id.btn_716);
        btn78 = findViewById(R.id.btn_78);
        btn1640 = findViewById(R.id.btn_1640);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        tvSelectAnswer = findViewById(R.id.tv_select_answer4);
        animWin = findViewById(R.id.animation_win_question_five);
        animLose = findViewById(R.id.animation_lose_question_five);

        playerLose = MediaPlayer.create(getApplicationContext(),R.raw.oh_no);
        playerWin = MediaPlayer.create(getApplicationContext(),R.raw.win_sound);

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
                Intent intent = new Intent(getApplicationContext(),FiveQuestionActivity.class);
                startActivity(intent);
            }
        };

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SixQuestionActivity.class);
                startActivity(intent);
            }
        });

        btn716.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });

        btn78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animWin.setVisibility(View.VISIBLE);
                btnNextPage.setVisibility(View.VISIBLE);
                playerWin.start();
                btn716.setVisibility(View.INVISIBLE);
                btn78.setVisibility(View.INVISIBLE);
            }
        });

        btn1640.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();

            }
        });

    }
}