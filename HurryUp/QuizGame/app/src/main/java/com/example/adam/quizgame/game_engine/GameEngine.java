package com.example.adam.quizgame.game_engine;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adam.quizgame.MainActivity;
import com.example.adam.quizgame.R;
import com.example.adam.quizgame.database.Question;
import com.example.adam.quizgame.database.Questions;

import java.util.List;
import java.util.Random;

public class GameEngine implements View.OnClickListener {

    FragmentActivity activity;
    MyTimer myTimer;
    private int countOfPoints = 0;
    private TextView points, timer, question, answerA, answerB, answerC, answerD;
    public List<Question> questions = Questions.getInstance().getQuestionsList();
    Question singleQuestion;
    public GameEngine(FragmentActivity activity, TextView points, TextView timer, TextView question, TextView answerA, TextView answerB, TextView answerC, TextView answerD) {
        this.activity = activity;
        this.timer = timer;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.points = points;
        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);
        myTimer = new MyTimer(60);
        myTimer.start();



    }

    public int getCountOfPoints() {
        return countOfPoints;
    }

    public void play(){
        loadQuestion();
    }
    public boolean chooseAnswer(String answer){
        return true;
    }

    void setText(TextView tv, String content){
        tv.setText(content);
    }

    void setTextViews(){
        setText(this.points,Integer.toString(countOfPoints));
        setText(this.question,singleQuestion.getQuestionContent());
        setText(this.answerA,singleQuestion.getAnswerA());
        setText(this.answerB,singleQuestion.getAnswerB());
        setText(this.answerC,singleQuestion.getAnswerC());
        setText(this.answerD,singleQuestion.getAnswerD());
    }

    void loadQuestion(){
        Random random = new Random();
        int n = random.nextInt(this.questions.size());
        this.singleQuestion = questions.get(n);
        questions.remove(n);
        setTextViews();
    }

    void addPoints(int points){
        countOfPoints += points;
    }

    void check(String answer, String correctAnswer){
        if(answer.equals(correctAnswer)){
            addPoints(singleQuestion.getPoints());
            myTimer.update(10+singleQuestion.getPoints()/10);

        }
        else myTimer.update(-10-singleQuestion.getPoints()/10);


        play();

    }

    @Override
    public void onClick(View v) {
        String answer="";
        switch (v.getId()){
            case R.id.answer_a_id:
                answer = "a";
                break;
            case R.id.answer_b_id:
                answer = "b";
                break;
            case R.id.answer_c_id:
                answer = "c";
                break;
            case R.id.answer_d_id:
                answer = "d";
                break;

        }
        check(answer,singleQuestion.getCorrectAnswer());

    }

    class MyTimer{
        CountDownTimer cdt;
        long seconds;
        public MyTimer(long seconds) {
            this.seconds = seconds;
        }

        void stop(){
            cdt.cancel();
        }
        void update(int n){
            stop();
            setSeconds(n+this.seconds);
            start();
        }

        public void setSeconds(long seconds) {
            this.seconds = seconds;
        }

        void start(){
            cdt =new CountDownTimer(this.seconds*1000, 1000) {


                public void onTick(long millisUntilFinished) {
                    seconds = millisUntilFinished/1000;
                    timer.setText(Long.toString(millisUntilFinished / 1000));
                }

                public void onFinish() {
                    timer.setText("GAME OVER");
                    ScoreDialog dialog = new ScoreDialog();
                    dialog.setAllParams("Gratulacje !","Zdobyłeś "+getCountOfPoints()+ " pkt","Zagraj jeszcze raz",
                            "Wyjdź",true,true);
                    dialog.show(activity.getSupportFragmentManager(),"example dialog");


                }
            }.start();
        }

    }

}
