package com.sheygam.java_19_16_03_18;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputName;
    private Button okBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        inputName = findViewById(R.id.input_name);
        okBtn = findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ok_btn){
            String name = inputName.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("NAME",name);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
