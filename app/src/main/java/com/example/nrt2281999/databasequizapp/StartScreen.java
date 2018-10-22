package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

//Please read the README note before reading these files
public class StartScreen extends AppCompatActivity {
    //Declaring UI variables.Declaration is made here so that inner methods can access these variables.
    Button nextButton;
    TextView appName;
    TextView appDesc;
    TextView appDesc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        //Assigning values to the variables to link them to the matching UI components in the layout
        nextButton = findViewById(R.id.nextButton);
        appName = findViewById(R.id.appName);
        appDesc = findViewById(R.id.appDesc);
        appDesc2=findViewById(R.id.appDesc2);

        //Setting the description text
        appDesc.setText("Lessons on databases in Android");
        appDesc2.setText("Quizzes");

        /*
        Instantiating AlphaAnimation objects to
        create a fade in effect for the descriptions and the next button
        Source: https://stackoverflow.com/questions/11444051/textview-animation-fade-in-wait-fade-out
         */
        AlphaAnimation descFadeIn = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation buttonFadeIn = new AlphaAnimation(0.0f, 1.0f);

        //Setting the duration for the fade in effect for the description and button
        descFadeIn.setDuration(3000);
        buttonFadeIn.setDuration(3000);

        //Setting duration before the fade in effect
        buttonFadeIn.setStartOffset(1400);

        //Provoke the method to start the fade in animation
        appDesc.startAnimation(descFadeIn);
        appDesc2.startAnimation(descFadeIn);
        nextButton.startAnimation(buttonFadeIn);

        //Create an on-clicked animation for the button
        final AlphaAnimation buttonClicked = new AlphaAnimation(1f,0.4f);

        /*Now we need to make an intent to move to the Main Menu through clicking the "Next" Button
        https://stackoverflow.com/questions/20241857/android-intent-cannot-resolve-constructor */
        
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClicked);
                Intent intent = new Intent(view.getContext(),MainMenu.class);
                startActivity(intent);

            }
        });

    }
}
