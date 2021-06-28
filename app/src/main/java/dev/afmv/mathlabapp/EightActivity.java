package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EightActivity extends AppCompatActivity {

    private Button btnNextPage, btnReturnPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);

        btnNextPage = findViewById(R.id.btn_nextPage);
        btnReturnPage = findViewById(R.id.btn_returnPage);
        btnReturnPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SevenActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NineActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}