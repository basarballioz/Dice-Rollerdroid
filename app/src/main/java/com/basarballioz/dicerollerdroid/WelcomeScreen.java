package com.basarballioz.dicerollerdroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    ImageView welcomeDiceView;
    TextView welcomeText;
    Button oneDiceRoller;
    Button twoDiceRoller;
    Button gitHubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //MAKE FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        welcomeDiceView = findViewById(R.id.welcomeDiceView);
        welcomeText = findViewById(R.id.welcomeText);
        oneDiceRoller = findViewById(R.id.oneDiceRoller);
        twoDiceRoller = findViewById(R.id.twoDiceRoller);
        gitHubButton = findViewById(R.id.gitHubButton);


    }

    public void openGitHub(View view) {
        Intent gitHub = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/basarballioz"));
        startActivity(gitHub);
    }

    public void rollOneDice(View view) {
        Intent oneDice = new Intent(WelcomeScreen.this, OneDiceActivity.class);
        startActivity(oneDice);
    }

    public void rollTwoDice(View view) {
        Intent twoDice = new Intent(WelcomeScreen.this, TwoDiceActivity.class);
        startActivity(twoDice);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
