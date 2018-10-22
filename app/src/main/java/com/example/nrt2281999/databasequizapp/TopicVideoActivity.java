package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class TopicVideoActivity extends Activity {
    /*
    Declaring the three main buttons to access different
    topics within the app. Declaration is made here so that
    inner methods can access these buttons
     */
    Button sqliteButton;
    Button contProButton;
    Button contResButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        //Assigning values to the buttons to link them to the buttons made in the layout
        sqliteButton = findViewById(R.id.sqliteButton);
        contProButton = findViewById(R.id.contProButton);
        contResButton = findViewById(R.id.contResButton);

        //Create an on-clicked animation for the button
        final AlphaAnimation buttonClicked = new AlphaAnimation(1f,0.7f);

        //Now we need to make an intent to move to the YouTube Activity through clicking the button
        sqliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClicked);
                Intent intent = new Intent(view.getContext(), YouTubeActivity.class);

                //Sending the youtube_id for the topic to the YouTube Activity to play the required video
                intent.putExtra("youtube_id","cp2rL3sAFmI");
                startActivity(intent);
            }
        });

        contProButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClicked);
                Intent intent = new Intent(view.getContext(), YouTubeActivity.class);

                //Sending the youtube_id for the topic to the YouTube Activity to play the required video
                intent.putExtra("youtube_id","N7Www8faKwA");
                startActivity(intent);}
        });

        contResButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClicked);
                Intent intent = new Intent(view.getContext(), YouTubeActivity.class);

                //Sending the youtube_id for the topic to the YouTube Activity to play the required video
                intent.putExtra("youtube_id","MPm0sW7gjIE");
                startActivity(intent);}
        });
    }

}
