package com.sheygam.java_19_16_03_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button startSecondBtn;
    private TextView myTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        startSecondBtn = findViewById(R.id.start_second_btn);
        myTxt = findViewById(R.id.my_txt);

        Intent intent = getIntent();
//        String name = intent.getStringExtra("NAME");
//        String email = intent.getStringExtra("EMAIL");
//        int age = intent.getIntExtra("AGE",50);
//        myTxt.setText(name + " " + email + " " + age);

        Bundle extras = intent.getExtras();
        if(extras != null) {
            String name = extras.getString("NAME", "empty");
            String email = extras.getString("EMAIL", "example@mail.com");
            int age = extras.getInt("AGE", 50);
            myTxt.setText(name + " " + email + " " + age);
        }
        startSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
//                intent.putExtra("NAME","some name");
                startActivity(intent);
            }
        });
    }
}
