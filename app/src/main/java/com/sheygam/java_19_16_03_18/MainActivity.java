package com.sheygam.java_19_16_03_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startSecondBtn, okBtn;
    private TextView nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSecondBtn = findViewById(R.id.start_second_btn);
        okBtn = findViewById(R.id.start_name_btn);
        nameTxt = findViewById(R.id.name_txt);
        okBtn.setOnClickListener(this);
        startSecondBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start_second_btn){
            int age = 32;
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("NAME","User");
            intent.putExtra("EMAIL","user@mail.com");
            intent.putExtra("AGE",age);
            startActivity(intent);
        }else if(v.getId() == R.id.start_name_btn){
            Intent intent = new Intent(this,NameActivity.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MY_TAG", "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        if (resultCode == RESULT_OK){
            if(requestCode == 1 && data!=null){
                String name = data.getStringExtra("NAME");
                nameTxt.setText(name);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
