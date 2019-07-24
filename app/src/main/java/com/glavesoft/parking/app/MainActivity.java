package com.glavesoft.parking.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;

public class MainActivity extends AppCompatActivity {

    TextView tv_smid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_smid = findViewById(R.id.tv_smid);

        Main.getQueryID(this.getApplicationContext(), "channel", "message", 1, new Listener() {
            @Override
            public void handler(final String s) {    //开启子线程(非UI线程)执行耗时操作
                Log.d("flag", "query id: " + s);

                runOnUiThread(new Runnable() {       //调用runOnUiThread回到主线程更新UI
                    @Override
                    public void run() {
                        tv_smid.setText(s);
                    }
                });
            }
        });
    }
}