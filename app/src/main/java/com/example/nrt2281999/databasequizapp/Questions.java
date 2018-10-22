package com.example.nrt2281999.databasequizapp;

public class Questions {
    //Defining the questionID and ansTrue field to construct a question object later
    //with quesStatement being its ID and ansTrue being if the ans is True or False
    private int quesStatement;
    private boolean ansTrue;

    //constructor to make a new Question object
    public Questions (int stringReference, boolean answer){
        quesStatement =stringReference;
        ansTrue = answer;
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
}
