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

public class GeneralInfo extends Activity {
    //code for putting a video in the background: https://www.youtube.com/watch?v=tPeDn18FrGY&feature=youtu.be
    //Declaring the video view and button in the UI
    VideoView videoView;
    Button nextButton;
    TextView textView;

    //Declaring a counter to set the button to set the right text after each other
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);

        //Linking the video view to the one in the UI
        videoView = findViewById(R.id.videoView3);

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

        //Linking the button and textView to the ones in the UI
        nextButton=findViewById(R.id.nextButton2);
        textView=findViewById(R.id.textView4);

        textView.setText("This application will discuss how databases application works by focusing" +
                " on the 3 main components that define it");

        //set an OnClickListener to move to the next text or description of the umbrella topic
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0) {
                    textView.setText("These components are datasourse, in this case SQLite is chosen because" +
                            " of its popularity and convenience");
                    counter++;
                }
                else if (counter==1){
                    textView.setText("The other 2 are Content Provider and Content Resolver");
                    counter++;
                }
                else if (counter==2){
                    textView.setText("These 3 are the foundations to a database app, the communication flow goes as follow");
                    counter++;
                }
                else if (counter==3){
                    textView.setText("App <=> Content Resolver <=> Content Provider <=> Data Source (SQLite)");
                    counter++;
                }
                else {
                    Intent intent=new Intent(GeneralInfo.this, MainMenu.class);
                    startActivity(intent);

                }
            }
        });
    }

}
