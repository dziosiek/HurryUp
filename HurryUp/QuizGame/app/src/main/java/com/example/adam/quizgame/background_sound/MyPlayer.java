package com.example.adam.quizgame.background_sound;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.adam.quizgame.MainActivity;
import com.example.adam.quizgame.R;

public class MyPlayer {
    private static final MyPlayer ourInstance = new MyPlayer();

    MediaPlayer player;

    public void init(Context context, int uri){
        player = MediaPlayer.create(context,uri);


    }
    public void start(){
        this.player.start();
    }

    public static MyPlayer getInstance() {
        return ourInstance;
    }

    private MyPlayer() {
    }
}
