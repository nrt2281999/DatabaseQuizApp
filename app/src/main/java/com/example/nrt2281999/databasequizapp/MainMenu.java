package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {
    //Declaring UI variables.Declaration is made here so that inner methods can access these variables.
    Button learnButton;
    Button quizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Assigning values to the variables to link them to the matching UI components in the layout
        learnButton = findViewById(R.id.learnButton);
        quizButton = findViewById(R.id.quizButton);

        //Make an intent to send the user to the topicVideo Activity when the user clicks the "learn" button
        learnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, TopicVideoActivity.class);
                startActivity(intent);
            }
        });

        //Make an intent to send the user to the Quiz Selection Activity when the user clicks the "quiz" button
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, QuizSelection.class);
                startActivity(intent);
            }
        });
    }

}
