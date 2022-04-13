package com.example.powerbank;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RentActivity extends AppCompatActivity {
    private Button btn_xl1;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        btn_xl1 = (Button) findViewById(R.id.btn_xl);
        btn_xl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent 对象
                Intent intent = new Intent(RentActivity.this,xuangzeActivity.class);
                //启动Activity
                startActivity(intent);
            }
        });

    }


}