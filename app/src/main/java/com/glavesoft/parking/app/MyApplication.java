package com.glavesoft.parking.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.Map;

import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;

public class MyApplication extends Application {

    public static String smid;
    String apiKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJfBMcqABFZVjLMyQy6nJXtC1jnZU7E/A+swH88uDtaJ7k8vaDVNB6F7EWE3t8faAUAWQ8kdyYsL7Cmax+Q0njsCAwEAAQ==";
    @Override
    public void onCreate() {
        super.onCreate();
        Context ctx = this.getApplicationContext();
        try {
            Main.init(ctx,apiKey);
            Log.d("flag","apikey: "+apiKey);
            Main.getQueryID(ctx, "channel", "message", 1, new Listener() {
                @Override
                public void handler(String s) {
                    Log.d("flag","query id: " + s);
                    smid = s;
                }
            });
        } catch (Exception e){
            Log.d("error", String.valueOf(e));

        }
    }
}
