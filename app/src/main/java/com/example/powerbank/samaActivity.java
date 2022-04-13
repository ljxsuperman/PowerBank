package com.example.powerbank;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
    public class samaActivity extends AppCompatActivity {
        Button btn;
        Button bttn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sama);
            //隐藏系统默认的标题
            bttn = (Button) findViewById(R.id.bttn);
            bttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //创建Intent 对象
                    Intent intent = new Intent(samaActivity.this,ZiquActivity.class);
                    //启动Activity
                    startActivity(intent);
                }
            });
            ActionBar actionBar = getSupportActionBar();
            if(actionBar!=null){
                actionBar.hide();
            }
            //初始化相机权限
            ZXingLibrary.initDisplayOpinion(this);
            btn = findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //先判断手机版本是否在6.0以上，如果在6.0以上则需要动态申请权限
                    if (Build.VERSION.SDK_INT > 22) {
                        if (ContextCompat.checkSelfPermission(samaActivity.this,
                                android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            //先判断有没有权限 ，没有就在这里进行权限的申请
                            ActivityCompat.requestPermissions(samaActivity.this,
                                    new String[]{android.Manifest.permission.CAMERA}, 1);
                        } else {
                            //说明已经获取到摄像头权限了 想干嘛干嘛
                            Intent intent = new Intent(samaActivity.this, CaptureActivity.class);
                            startActivityForResult(intent, 1);
                        }
                    } else {
                        //这个说明系统版本在6.0之下，不需要动态获取权限。
                        Intent intent = new Intent(samaActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, 1);
                    }
                }
            });
        }
        //获取手机相机权限
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 1) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, CaptureActivity.class);
                    startActivityForResult(intent, 1);
                } else {
                    Toast.makeText(samaActivity.this, "请打开相机权限", Toast.LENGTH_SHORT).show();
                }
            }
        }
        //处理扫描结果
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        //获取到扫描的结果
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Log.d("res:",result);
                    }
                }
            }
        }
    }
