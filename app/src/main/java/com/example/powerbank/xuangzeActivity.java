package com.example.powerbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class xuangzeActivity extends AppCompatActivity {
    private Button QBButton;
    private Button SentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuangze);//关于扫码与远程送货
        QBButton = (Button) findViewById(R.id.QR_button);
       QBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent 对象
                Intent intent = new Intent(xuangzeActivity.this,samaActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
        SentButton = (Button) findViewById(R.id.send_button);
        SentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent 对象
                Intent intent = new Intent(xuangzeActivity.this,DTActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });
    }
}