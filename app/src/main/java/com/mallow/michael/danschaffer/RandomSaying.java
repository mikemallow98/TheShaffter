package com.mallow.michael.danschaffer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class RandomSaying extends AppCompatActivity {
    private final int NUM_OF_SAYINGS = 2;
    private static boolean isPlaying =false;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_saying);

    }

    public void playAudio(View view){
        if(isPlaying) {
        }
        else{
            isPlaying = true;
            Random r1 = new Random();
            switch(r1.nextInt(NUM_OF_SAYINGS)) {
                case 0:
                    player =  MediaPlayer.create(RandomSaying.this, R.raw.sneakybrag);
                    break;
                case 1:
                    player = MediaPlayer.create(RandomSaying.this, R.raw.train);
                    break;
                default:
                    break;
            }
            player.start();
            while(player.isPlaying()){

            }
            player.release();
            isPlaying = false;
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onPause(){
        super.onPause();
        if(player != null){
            player.release();
            player = null;
        }
    }


}
