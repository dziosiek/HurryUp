package com.example.adam.quizgame.game_engine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDialogFragment;

import com.example.adam.quizgame.MainActivity;
import com.example.adam.quizgame.MainMenu;
import com.example.adam.quizgame.NewGame;
import com.example.adam.quizgame.R;

public class ScoreDialog extends AppCompatDialogFragment {

    String title, message, positiveButton, negativeButton;
    boolean positiveValue, negativeValue;

    public boolean isPositiveValue() {
        return positiveValue;
    }

    public void setPositiveValue(boolean positiveValue) {
        this.positiveValue = positiveValue;
    }

    public boolean isNegativeValue() {
        return negativeValue;
    }

    public void setNegativeValue(boolean negativeValue) {
        this.negativeValue = negativeValue;
    }

    public String getNegativeButton() {
        return negativeButton;
    }

    public void setNegativeButton(String negativeButton) {
        this.negativeButton = negativeButton;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAllParams(String title, String message, String positiveButton,
                             String negativeButton, boolean positiveValue, boolean negativeValue){
        setTitle(title);
        setMessage(message);
        setPositiveButton(positiveButton);
        setNegativeButton(negativeButton);
        setNegativeValue(negativeValue);
        setPositiveValue(positiveValue);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPositiveButton() {
        return positiveButton;
    }

    public void setPositiveButton(String positiveButton) {
        this.positiveButton = positiveButton;
    }


    public ScoreDialog() {
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getTitle()).setMessage(getMessage())
                .setPositiveButton(getPositiveButton(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.switchFragment(new NewGame(),R.id.main_menu_frame_layout,getActivity());




                    }
                }).setNegativeButton(getNegativeButton(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.switchFragment(new MainMenu(),R.id.main_menu_frame_layout,getActivity());




            }
        });
        return builder.create();
    }
}
