package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondQuestionActivity extends AppCompatActivity {

    Button imvquestion8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        imvquestion8 = findViewById(R.id.imvquestion8);

        imvquestion8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ThirdQuestionActivity.class);
                startActivity(intent);
            }
        });
    }


}