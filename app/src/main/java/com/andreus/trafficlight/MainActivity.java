package com.andreus.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.graphics.Color.BLACK;

public class MainActivity extends AppCompatActivity {
    private LinearLayout b_1;
    private LinearLayout b_2;
    private LinearLayout b_3;
    private LinearLayout b_4;
    private LinearLayout b_5;
    private LinearLayout b_6;
    private boolean Start_Stop = false;
    private Button button;
    private int counter = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_1 = findViewById(R.id.bulb_1);
        b_2 = findViewById(R.id.bulb_2);
        b_3 = findViewById(R.id.bulb_3);
        b_4 = findViewById(R.id.bulb_4);
        b_5 = findViewById(R.id.bulb_5);
        b_6 = findViewById(R.id.bulb_6);
        button = findViewById(R.id.button1);
        tv = findViewById(R.id.textView_1);

     }

    public void onClickStart(View view) {
        if (!Start_Stop){
            button.setText("STOP");
            Start_Stop = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (Start_Stop){
                        counter++;
                        tv.setText(String.valueOf(counter));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                switch (counter){
                                    case 1:
                                        b_1.setBackgroundColor(getResources().getColor(R.color.red));
                                        b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_4.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_5.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_6.setBackgroundColor(getResources().getColor(R.color.grey));
                                        break;
                                    case 2:
                                        b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                                        b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_4.setBackgroundColor(getResources().getColor(R.color.green));
                                        b_5.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_6.setBackgroundColor(getResources().getColor(R.color.grey));
                                    case 3:
                                        b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_3.setBackgroundColor(getResources().getColor(R.color.green));
                                        b_4.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_5.setBackgroundColor(getResources().getColor(R.color.yellow));
                                        b_6.setBackgroundColor(getResources().getColor(R.color.grey));

                                        break;
                                    case 4:
                                        b_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_4.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_5.setBackgroundColor(getResources().getColor(R.color.grey));
                                        b_6.setBackgroundColor(getResources().getColor(R.color.red));
                                        counter = 0;
                                }

                            }
                        });
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        } else {
            button.setText("START");
            Start_Stop = false;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Start_Stop = false;
    }
}
