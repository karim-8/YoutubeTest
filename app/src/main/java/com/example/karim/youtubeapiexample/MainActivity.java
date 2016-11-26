package com.example.karim.youtubeapiexample;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    //Api key
    public static final String Api_Key = "AIzaSyAZHwl2FrYY91PYgg7XUDWVhYaEbtukRPM";

    //video id
    public static final String Video_Id1 = "-m3V8w_7vhk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intialize the view
         youTubePlayerView = (YouTubePlayerView)
                findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(Api_Key, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if(null== youTubePlayer) return;

        // Start buffering
        if (!b) {
            youTubePlayer.cueVideo(Video_Id1);
        }

        // Add listeners to YouTubePlayer instance
        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override public void onAdStarted() { }
            @Override public void onError(YouTubePlayer.ErrorReason arg0) { }
            @Override public void onLoaded(String arg0) { }
            @Override public void onLoading() { }
            @Override public void onVideoEnded() { }
            @Override public void onVideoStarted() { }
        });


        youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
            @Override public void onBuffering(boolean arg0) { }
            @Override public void onPaused() { }
            @Override public void onPlaying() { }
            @Override public void onSeekTo(int arg0) { }
            @Override public void onStopped() { }
        });

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {
        //Include the code here
        Intent intent = new Intent(this,soso.class);
        startActivity(intent);
        return;
    }
}
