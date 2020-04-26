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

public class TwoDiceActivity extends AppCompatActivity {

    ImageView dice1View;
    ImageView dice2View;
    TextView diceStatus;
    Button rollButton;
    CountDownTimer rollTimer = null;
    int dice1Number;
    int dice2Number;
    TextView dice1Result;
    TextView dice2Result;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_dice_activity);

        //MAKE FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dice1View = findViewById(R.id.dice1View);
        dice2View = findViewById(R.id.dice2View);
        diceStatus = findViewById(R.id.diceStatus);
        rollButton = findViewById(R.id.rollButton);
        dice1Result = findViewById(R.id.dice1Result);
        dice2Result = findViewById(R.id.dice2Result);
        diceStatus.setText("Press Roll!");
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

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

                dice1Number = ranNumber.nextInt(6) + 1;
                dice2Number = ranNumber.nextInt(6) + 1;

                switch (dice1Number) {
                    case 1:
                        dice1View.setImageResource(R.drawable.dice1);
                        dice1Result.setText("1");
                        break;
                    case 2:
                        dice1View.setImageResource(R.drawable.dice2);
                        dice1Result.setText("2");
                        break;
                    case 3:
                        dice1View.setImageResource(R.drawable.dice3);
                        dice1Result.setText("3");
                        break;
                    case 4:
                        dice1View.setImageResource(R.drawable.dice4);
                        dice1Result.setText("4");
                        break;
                    case 5:
                        dice1View.setImageResource(R.drawable.dice5);
                        dice1Result.setText("5");
                        break;
                    case 6:
                        dice1View.setImageResource(R.drawable.dice6);
                        dice1Result.setText("6");
                        break;
                }

                switch (dice2Number) {
                    case 1:
                        dice2View.setImageResource(R.drawable.dice1);
                        dice2Result.setText("1");
                        break;
                    case 2:
                        dice2View.setImageResource(R.drawable.dice2);
                        dice2Result.setText("2");
                        break;
                    case 3:
                        dice2View.setImageResource(R.drawable.dice3);
                        dice2Result.setText("3");
                        break;
                    case 4:
                        dice2View.setImageResource(R.drawable.dice4);
                        dice2Result.setText("4");
                        break;
                    case 5:
                        dice2View.setImageResource(R.drawable.dice5);
                        dice2Result.setText("5");
                        break;
                    case 6:
                        dice2View.setImageResource(R.drawable.dice6);
                        dice2Result.setText("6");
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
        diceStatus.setText("Total: " + (dice1Number + dice2Number));
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
