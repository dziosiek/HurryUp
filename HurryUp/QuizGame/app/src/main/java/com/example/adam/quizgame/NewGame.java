package com.example.adam.quizgame;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adam.quizgame.game_engine.GameEngine;


public class NewGame extends Fragment {
    GameEngine gameEngine;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View myView = getView();
        gameEngine = new GameEngine(
                getActivity(),
                (TextView) myView.findViewById(R.id.points_id),
                (TextView) myView.findViewById(R.id.timer_id),
                (TextView)myView.findViewById(R.id.question_id),
                (TextView)myView.findViewById(R.id.answer_a_id),
                (TextView)myView.findViewById(R.id.answer_b_id),
                (TextView)myView.findViewById(R.id.answer_c_id),
                (TextView)myView.findViewById(R.id.answer_d_id));
        gameEngine.play();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_game, container, false);
    }










}
