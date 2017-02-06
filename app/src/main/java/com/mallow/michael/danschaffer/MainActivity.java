package com.mallow.michael.danschaffer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import static android.R.anim.slide_out_right;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        MobileAds.initialize(getApplicationContext(),  "ca-app-pub-4454388433676329/5980135297");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    public void chooseRandom(View view){
        Intent intent = new Intent(this,RandomSaying.class);
        //overridePendingTransition(slide_in_left,slide_out_right);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, slide_out_right);
    }
    public void chooseSoundboard(View view){
        Intent intent = new Intent(this, SoundBoard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
      //  overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }



}
