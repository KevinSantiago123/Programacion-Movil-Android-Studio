package com.example.webandvideoview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class videoView extends AppCompatActivity {
    VideoView videoView;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = (VideoView) findViewById(R.id.videoView);

        mediaPlayer = MediaPlayer.create(this, R.raw.cancion);
        //Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(path);

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        ((ToggleButton) findViewById(R.id.toggleButton)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    mediaPlayer.start();
                } else{
                    mediaPlayer.pause();
                }
            }
        });
    }
}