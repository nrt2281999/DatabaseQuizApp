package com.example.nrt2281999.databasequizapp;

import java.io.Serializable;

public class Questions implements Serializable {
    //Defining the questionID and ansTrue field to construct a question object later
    //with quesStatement being its ID and ansTrue being if the ans to the ques is True or False
    //ifAnsIncorrect gives the feedback if the user does not get the right answer
    //isWrong let the feedback activity know which question did the user get wrong

    private int quesStatement;
    private boolean ansTrue;
    private String ifAnsIncorrect;
    private boolean isWrong = false;

    //constructor to make a new Question object
    public Questions(int stringReference, boolean answer) {
        quesStatement = stringReference;
        ansTrue = answer;
    }

    public Questions (int stringRefernce, boolean answer, String ifAnsIncorrect){
        quesStatement = stringRefernce;
        ansTrue = answer;
        this.ifAnsIncorrect = ifAnsIncorrect;
    }

    //getters and setters to use in other classes later
    public int getQuesStatement() {
        return quesStatement;
    }

    public void setQuesStatement(int quesStatement) {
        this.quesStatement = quesStatement;
    }

    public boolean isAnsTrue() {
        return ansTrue;
    }

    public void setAnsTrue(boolean ansTrue) {
        this.ansTrue = ansTrue;
    }

    public String getIfAnsIncorrect() {
        return ifAnsIncorrect;
    }

    public void setIfAnsIncorrect(String ifAnsIncorrect) {
        this.ifAnsIncorrect = ifAnsIncorrect;
    }
    public boolean isWrong() {
        return isWrong;
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
    }
}
