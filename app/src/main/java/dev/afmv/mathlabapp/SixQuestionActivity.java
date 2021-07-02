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

public class SixQuestionActivity extends AppCompatActivity {

    MediaPlayer playerWin, playerLose;
    LottieAnimationView animLose, animWin;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;
    Button btn48, btn824, btn416, btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_question);

        btnNextPage = findViewById(R.id.btn_nextPage_Six);
        btn48 = findViewById(R.id.btn_48);
        btn416 = findViewById(R.id.btn_416);
        btn824 = findViewById(R.id.btn_824);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        tvSelectAnswer = findViewById(R.id.tv_select_answer4);
        animWin = findViewById(R.id.animation_win_question_six);
        animLose = findViewById(R.id.animation_lose_question_six);

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
                Intent intent = new Intent(getApplicationContext(),SixQuestionActivity.class);
                startActivity(intent);
            }
        };

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SevenQuestionActivity.class);
                startActivity(intent);
            }
        });

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animWin.setVisibility(View.VISIBLE);
                btnNextPage.setVisibility(View.VISIBLE);
                playerWin.start();
                btn824.setVisibility(View.INVISIBLE);
                btn416.setVisibility(View.INVISIBLE);


            }
        });

        btn824.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();

            }
        });

        btn416.setOnClickListener(new View.OnClickListener() {
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