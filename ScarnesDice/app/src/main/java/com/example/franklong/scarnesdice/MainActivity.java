package com.example.franklong.scarnesdice;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView javaNumberTextView;
    ImageView javaImageView;
    int currentRoundScore;
    TextView javaRoundScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //javaNumberTextView = (TextView) findViewById(R.id.number_textview);
        javaImageView = (ImageView) findViewById(R.id.dice_image);
        currentRoundScore = 0;
        javaRoundScore = (TextView) findViewById(R.id.round_score);
    }

    public void random(View view) {
        int randomNum = (int) (Math.random() * 6) + 1;
        currentRoundScore += randomNum;
        javaRoundScore.setText("" + currentRoundScore);

        switch (randomNum){
            case 1 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice1));
                break;
            case 2 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice2));
                break;
            case 3 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice3));
                break;
            case 4 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice4));
                break;
            case 5 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice5));
                break;
            case 6 :
                javaImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dice6));
                break;
        }
        //javaNumberTextView.setText("" + randomNum);
    }
}
