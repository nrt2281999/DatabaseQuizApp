package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class TopicListActivity extends Activity {
    /*
    Declaring the three main buttons to access different
    topics within the app. Declaration is made here so that
    inner methods can access these buttons
     */
    Button topic1Button;
    Button topic2Button;
    Button topic3Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        //Assigning values to the buttons to link them to the buttons made in the layout
        topic1Button = findViewById(R.id.topic1Button);
        topic2Button = findViewById(R.id.topic2Button);
        topic3Button = findViewById(R.id.topic3Button);

        //Create an on-clicked animation for the button
        final AlphaAnimation buttonClicked = new AlphaAnimation(1f,0.7f);

        //Now we need to make an intent to move to the YouTube Activity through clicking the "Topic" Button
        topic1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClicked);
                Intent intent = new Intent(view.getContext(), YouTubeActivity.class);

                //Sending the youtube_id for the topic to the YouTube Activity to play the required video
                intent.putExtra("youtube_id","cp2rL3sAFmI");
                startActivity(intent);
            }
        });

    }

}
