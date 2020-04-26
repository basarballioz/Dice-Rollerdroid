
package com.basarballioz.dicerollerdroid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class OneDiceActivity extends AppCompatActivity {

    TextView diceStatus;
    ImageView diceView;
    Button rollButton;
    CountDownTimer rollTimer = null;
    int diceNumber;
    TextView diceResult;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.one_dice_activity);


        //MAKE APPLICATION FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        diceStatus = findViewById(R.id.diceStatus);
        rollButton = findViewById(R.id.rollButton);
        diceView = findViewById(R.id.diceView);
        diceResult = findViewById(R.id.diceResult);
        diceStatus.setText("Press Roll!");
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        //Enable this ONLY IF you want to use OnClickListener method instead of onclick button
        /*diceView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //rollDice();
            }
        });*/
    }


    public void rollDice(View view) {

        MediaPlayer diceSound = MediaPlayer.create(this, R.raw.dicesound);
        diceSound.start();
        vibrator.vibrate(100);
        diceStatus.setText("Rolling...");
        final Random ranNumber = new Random();


        rollTimer = new CountDownTimer(3000, 50) {
            @Override
            public void onTick(final long millisUntilFinished) {

                //DISABLE ROLL BUTTON UNTIL COUNTDOWNTIMER EXPIRES
                rollButton.setEnabled(false);
                diceNumber = ranNumber.nextInt(6) + 1;

                    switch (diceNumber) {
                        case 1:
                            diceView.setImageResource(R.drawable.dice1);
                            diceResult.setText("1");
                            break;
                        case 2:
                            diceView.setImageResource(R.drawable.dice2);
                            diceResult.setText("2");
                            break;
                        case 3:
                            diceView.setImageResource(R.drawable.dice3);
                            diceResult.setText("3");
                            break;
                        case 4:
                            diceView.setImageResource(R.drawable.dice4);
                            diceResult.setText("4");
                            break;
                        case 5:
                            diceView.setImageResource(R.drawable.dice5);
                            diceResult.setText("5");
                            break;
                        case 6:
                            diceView.setImageResource(R.drawable.dice6);
                            diceResult.setText("6");
                            break;
                        default:
                            break;
                    }
                }


            @Override
            public void onFinish() {
                vibrator.vibrate(300);
                rollButton.setEnabled(true);
                showDiceNumber();
            }

        }.start();
    }

    public void showDiceNumber() {
        diceStatus.setText("Your dice is: ");
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}


