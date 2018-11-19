package com.example.adam.quizgame.database;

public class Question{
    int id,points;
    String questionContent, answerA, answerB, answerC, answerD, correctAnswer;

    public Question(String questionContent, int id, int points, String answerA,
                    String answerB, String answerC, String answerD, String correctAnswer) {

        this.questionContent = questionContent;
        this.id = id;
        this.points = points;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }



    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", points=" + points +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public int getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
