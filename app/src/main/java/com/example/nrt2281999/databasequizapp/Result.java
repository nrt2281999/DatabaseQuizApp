package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class Result extends Activity {
    //code for putting a video in the background: https://www.youtube.com/watch?v=tPeDn18FrGY&feature=youtu.be
    //Declaring the video view and button in the UI
    VideoView videoView;
    Button homeButton;
    TextView textView;
    TextView resultTextView;
    int noRightQues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Linking the video view to the one in the UI
        videoView = findViewById(R.id.videoView2);

        //Defining the location of the video
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bd_vid);

        //Setting the location for the video
        videoView.setVideoURI(uri);

        //Starting the video
        videoView.start();

        //Setting the loop for the video so it would repeat
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        //Linking the button to the one in the UI
        homeButton = findViewById(R.id.home_button2);

        //set an on-click listener so it would go to the main screen when clicked
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainMenu.class);
                startActivity(intent);
            }
        });

        //Linking the text views to the ones in the UI
        textView = findViewById(R.id.textView);
        resultTextView = findViewById(R.id.textView2);

        //Retrieving the intent sent to this activity to retrieve the rightQuesCounter to see how many
        //questions did the user get right
        Intent intent = getIntent();
        noRightQues = intent.getIntExtra("rightQuesCounter",0);

        //Setting the result as a text for the textView
        resultTextView.setText(noRightQues+" out of 7");


    }

}
