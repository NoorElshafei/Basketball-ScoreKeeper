package com.example.elshafie.lessontwouserinputupdated;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.Object;

import android.os.Handler;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    int counterA, counterB;
    TextView timerTextView, timerTextView1, timerTextView2;
    Button b, per, bBigT;
    int seconds, minutes, period = 1;


    CountDownTimer t = new CountDownTimer(24000, 1000) {


        public void onTick(long millisUntilFinished) {

            timerTextView.setText("" + millisUntilFinished / 1000);
        }

        public void onFinish() {
            timerTextView.setText("done!");

        }

    };
    CountDownTimer t1 = new CountDownTimer(600000, 1000) {


        public void onTick(long millisUntilFinished) {
            seconds = (int) (millisUntilFinished / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            timerTextView1.setText(String.format("%d:%02d", minutes, seconds));

        }

        public void onFinish() {
            timerTextView1.setText("done!");

        }

    };
    CountDownTimer t2 = new CountDownTimer(300000, 1000) {


        public void onTick(long millisUntilFinished) {
            seconds = (int) (millisUntilFinished / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            timerTextView1.setText(String.format("%d:%02d", minutes, seconds));

        }

        public void onFinish() {
            timerTextView1.setText("done!");

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = (TextView) findViewById(R.id.timer);
        timerTextView1 = (TextView) findViewById(R.id.bigTimer);
        timerTextView2 = (TextView) findViewById(R.id.periodText);
        b = (Button) findViewById(R.id.start);
        bBigT = (Button) findViewById(R.id.buttonBigTimer);
        per = (Button) findViewById(R.id.period1);


    }

    public void startTimer(View view) {

        if (b.getText().equals("RESET")) {
            b.setText("START");
            t.cancel();
            timerTextView.setText("24");

        } else {
            b.setText("RESET");
            t.cancel();
            t.start();
        }
       


    }

    public void bigTimer(View view) {

        if (bBigT.getText().toString().equals("RESET")) {

            if (timerTextView2.getText().toString().equals("OVER TIME")) {
                bBigT.setText("START");
                timerTextView1.setText("05:00");
                timerTextView.setText("24");
                b.setText("START");
                t2.cancel();
                t.cancel();
            } else {
                bBigT.setText("START");
                t1.cancel();
                t.cancel();
                timerTextView1.setText("10:00");
                timerTextView.setText("24");
            }

        } else if (timerTextView2.getText().toString().equals("OVER TIME")) {
            bBigT.setText("RESET");
            b.setText("RESET");
            t2.cancel();
            t2.start();
            t.start();

        } else {
            bBigT.setText("RESET");
            b.setText("RESET");
            t1.cancel();
            t1.start();
            t.start();
        }


    }

    public void period(View view) {
        if (period <= 3 || timerTextView2.getText().toString().equals("OVER TIME")) {
            if (timerTextView2.getText().toString().equals("OVER TIME")) {
                t2.cancel();
                t.cancel();
                timerTextView1.setText("05:00");
                timerTextView.setText("24");
                bBigT.setText("START");
                b.setText("START");
                period += 1;
                per.setText("" + period);
            } else {
                t1.cancel();
                t.cancel();
                timerTextView1.setText("10:00");
                timerTextView.setText("24");
                bBigT.setText("START");
                b.setText("START");
                period += 1;
                per.setText("" + period);
            }
        } else {
            t1.cancel();
            t.cancel();
            timerTextView1.setText("05:00");
            timerTextView.setText("24");
            bBigT.setText("START");
            b.setText("START");
            period = 1;
            per.setText("" + period);
            timerTextView2.setText("OVER TIME");

        }
    }


    public void threePointsA(View view) {
        counterA += 3;
        displayA(counterA);

    }

    public void twoPointsA(View view) {
        counterA += 2;
        displayA(counterA);
    }

    public void onePointA(View view) {
        counterA += 1;
        displayA(counterA);
    }

    public void threePointsB(View view) {
        counterB += 3;
        displayB(counterB);

    }

    public void twoPointsB(View view) {
        counterB += 2;
        displayB(counterB);
    }

    public void onePointB(View view) {
        counterB += 1;
        displayB(counterB);
    }

    public void reset(View view) {
        counterA = 0;
        counterB = 0;
        displayA(counterA);
        displayB(counterB);
        period = 1;
        per.setText("" + period);
        bBigT.setText("START");
        t1.cancel();
        timerTextView1.setText("10:00");
        b.setText("START");
        t.cancel();
        timerTextView.setText("24");
        timerTextView2.setText("PERIOD");
        t2.cancel();
    }

    public void displayA(int number) {
        TextView teamA = (TextView) findViewById(R.id.counter);
        teamA.setText("" + number);
    }

    public void displayB(int number) {
        TextView teamB = (TextView) findViewById(R.id.counter2);
        teamB.setText("" + number);
    }

}
