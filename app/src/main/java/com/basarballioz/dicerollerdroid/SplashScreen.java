package com.basarballioz.dicerollerdroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        //MAKE FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread splashThread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(2600);
                    Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
                    startActivity(intent);
                    finish();
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splashThread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
