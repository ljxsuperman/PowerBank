package com.example.powerbank;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReturnActivity extends AppCompatActivity {
    private Button btn_xl1;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        btn_xl1 = findViewById(R.id.btn_xl);
        btn_xl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建Intent 对象
                Intent intent = new Intent(ReturnActivity.this, Classification.class);
                //启动Activity
                startActivity(intent);
            }
        });
        initEvent();
    }

    private void initEvent() {
        button1 = findViewById(R.id.button1);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
            }
        });

    }

    private void showDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ts);
        builder.setTitle("提示");
        builder.setMessage("归还成功！欢迎下次使用~");
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
