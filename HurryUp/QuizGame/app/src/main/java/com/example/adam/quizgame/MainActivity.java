package com.example.adam.quizgame;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adam.quizgame.background_sound.MyPlayer;
import com.example.adam.quizgame.database.Questions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //DB URL
    public static final String URL ="http://192.168.1.103/millionaires/question/read.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Questions.getInstance().createDatabase(getApplicationContext(),URL);

        Fragment fragment = new MainMenu();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_menu_frame_layout, fragment);
        transaction.commit();

        MyPlayer.getInstance().init(MainActivity.this,R.raw.bgtrack);
        MyPlayer.getInstance().start();


    }
    public static void switchFragment(Fragment fragment, int uri, FragmentActivity fragmentActivity){
        FragmentManager fm = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(uri, fragment);
        transaction.commit();
    }

}
