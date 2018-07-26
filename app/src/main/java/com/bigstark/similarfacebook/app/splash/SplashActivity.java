package com.bigstark.similarfacebook.app.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bigstark.similarfacebook.util.Constants;
import com.bigstark.similarfacebook.R;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (isFinishing()) {
                return;
            }

            Intent intent = new Intent(Constants.ACTION_GOTO_HOME);
            startActivity(intent);

        }, 1000);
    }


}
