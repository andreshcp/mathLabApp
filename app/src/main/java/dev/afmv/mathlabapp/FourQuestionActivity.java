package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class FourQuestionActivity extends AppCompatActivity {

    MediaPlayer playerWin, playerLose;
    LottieAnimationView animLose;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_question);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        tvSelectAnswer = findViewById(R.id.tv_select_answer);
        animLose = findViewById(R.id.animation_lose_4);


    }
}