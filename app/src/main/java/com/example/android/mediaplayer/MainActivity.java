package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.bensound_ukulele);

    }

    public void playAudio(View view) {
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "I'm Done", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void pauseAudio(View view){
        mediaPlayer.pause();
    }

    public void stopAudio(View view){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer =  mediaPlayer.create(this, R.raw.bensound_ukulele);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null){
            mediaPlayer.release();
        }
    }

}
