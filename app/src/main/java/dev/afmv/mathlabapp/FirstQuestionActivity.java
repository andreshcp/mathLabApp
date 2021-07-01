package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.lang.annotation.Annotation;

public class FirstQuestionActivity extends AppCompatActivity {

    Button btn_8, btn_6, btn_4, btn_2,btnNextPage;
    Handler handler;
    MediaPlayer playerWin,playerLose,onBack;
    LottieAnimationView animationWin,animLose_2,animLose_4,animLose_6;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        //Animation ScaleUP/Down
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        //Buttons
        btn_2 = findViewById(R.id.btn2);
        btn_4 = findViewById(R.id.btn4);
        btn_6 = findViewById(R.id.btn6);
        btn_8 = findViewById(R.id.btn8);

        //Animations
        animationWin = findViewById(R.id.animation_win);
        animLose_2 = findViewById(R.id.animation_lose_2);

        tvSelectAnswer = findViewById(R.id.tv_select_answer);
        btnNextPage = findViewById(R.id.btn_nextPage);
        //Sounds
        playerWin = MediaPlayer.create(this,R.raw.win_sound);
        playerLose = MediaPlayer.create(this,R.raw.fail_trumpet);
        onBack = MediaPlayer.create(this,R.raw.oh_no);




        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //onBack.start();

                Intent intent = new Intent(getApplicationContext(),FirstQuestionActivity.class);
                startActivity(intent);
            }
        };

        btn_2.setOnTouchListener(new View.OnTouchListener() {
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
        btn_4.setOnTouchListener(new View.OnTouchListener() {
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
        btn_6.setOnTouchListener(new View.OnTouchListener() {
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


        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondQuestionActivity.class);
                startActivity(intent);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setText("Try Again!");
                animLose_2.setVisibility(View.VISIBLE);
                animationWin.setVisibility(View.INVISIBLE);
                playerLose.start();
                runnable.run();
            }

        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setText("Try Again!");
                animLose_2.setVisibility(View.VISIBLE);
                animationWin.setVisibility(View.INVISIBLE);
                playerLose.start();
                runnable.run();
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setText("Try Again!");
                animLose_2.setVisibility(View.VISIBLE);
                animationWin.setVisibility(View.INVISIBLE);
                playerLose.start();
                runnable.run();
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvSelectAnswer.setText("Try Again!");
                animationWin.setVisibility(View.VISIBLE);
                playerWin.start();
                tvSelectAnswer.setText("Correct!");
                btnNextPage.setVisibility(View.VISIBLE);
            }
        });

    }

}