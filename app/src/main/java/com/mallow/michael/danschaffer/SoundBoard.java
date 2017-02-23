package com.mallow.michael.danschaffer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class SoundBoard extends AppCompatActivity implements OnClickListener{
    private MediaPlayer player;
    private ImageButton sneakyBragButton, trainsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        sneakyBragButton = (ImageButton) findViewById(R.id.sneakyBragButton);
        trainsButton = (ImageButton) findViewById(R.id.trainsButton);
        sneakyBragButton.setOnClickListener(this);
        trainsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        changeNonClick();
        switch(v.getId()) {
            case R.id.sneakyBragButton:
                player = MediaPlayer.create(SoundBoard.this, R.raw.sneakybrag);

                break;
            case R.id.trainsButton:
                player = MediaPlayer.create(SoundBoard.this, R.raw.train);
                break;
            default:
                break;
        }
        //player.prepareAsync();
        player.start();
        while(player.isPlaying()) {
            changeNonClick();
        }
        player.stop();
        player = null;
        if(player == null) {

            changeClick();
        }

    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
    @Override
    public void onPause(){
        super.onPause();

        if(player != null) {
            player.deselectTrack(player.getAudioSessionId());
            player.stop();
            player.release();
            player = null;
        }
    }
    private boolean changeNonClick(){
        sneakyBragButton.setClickable(false);
        trainsButton.setClickable(false);
        return true;
    }
    private boolean changeClick(){
        sneakyBragButton.setClickable(true);
        trainsButton.setClickable(true);
        return true;
    }
}
