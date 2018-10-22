package com.example.nrt2281999.databasequizapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteQuiz extends Activity {

    //Declaring the components to link to the UI
    TextView questionTextView;
    Button trueButton;
    Button falseButton;

    //Defining the Questions array to store the questions
    Questions[] question = new Questions[5];

    //To keep track of which question is being asked
    int quesNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_quiz);

        //Linking the components to the UI
        questionTextView = findViewById(R.id.quesTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        //Constructing the question objects with actual parameters
        question[0] = new Questions(R.string.question1, true);
        question[1] = new Questions(R.string.question2, false);

        //Setting the textView to the first question
        questionTextView.setText(question[0].getQuesStatement());

        //setting an OnClickListener for the buttons to return a feedback on the user's answer and
        //move to the next question
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (question[quesNumber].isAnsTrue()) {
                    Toast.makeText(SQLiteQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SQLiteQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                }

                quesNumber++;
                questionTextView.setText(question[quesNumber].getQuesStatement());
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                if (question[quesNumber].isAnsTrue()){
                    Toast.makeText(SQLiteQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SQLiteQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }

                quesNumber++;
                questionTextView.setText(question[quesNumber].getQuesStatement());
            }});
    }

}
