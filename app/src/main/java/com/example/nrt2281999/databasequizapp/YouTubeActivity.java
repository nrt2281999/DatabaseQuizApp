package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/*all codes regarding the YouTube Activity is sourced from
https://www.udemy.com/master-android-7-nougat-java-app-development-step-by-step/learn/v4/t/lecture/5601506?start=0
 */
public class YouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //Declaring a Google API variable to access YouTube. This API Key can be retrieved from Google Console.
    static final String GOOGLE_API_KEY = "AIzaSyAkuLBVRvCNPGvwmq0-VhFhNkOOSlrAGZs";



    //Defining TAG for the onSuccessIninitalisation method to know which activity to refer to later on.
    private static final String TAG = "YoutubeActivity";

    String YOUTUBE_VIDEO_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get the current intent
        Intent intent = getIntent();

        //Declaring and defining the YouTube Video ID of the video to be played.
        YOUTUBE_VIDEO_ID = intent.getStringExtra("youtube_id");


        //Creating a constraint layout for the activity
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_you_tube, null);
        setContentView(layout);

        //Creating a view for the YouTube player and adding it to the layout
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);

        //Initialise the playerview with the Google API Key
        playerView.initialize(GOOGLE_API_KEY, this);
    }

    //Setting methods for when the activity is successfully initialised
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        //This sends back a message to the system to let us know the initilisation process was successful and who the provider is
        Log.d(TAG, "onInitiliasationSuccess: provider is: " + provider.getClass().toString());

        //Setting a listener to respond to the change in state of the video
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        //If the video was not restored, play a new video with the ID provided
        if (!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }


    //Setting methods for when the activity fails to initialise
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE = 1;
        //Checking to see if the error is user recoverable, if it is Google Dialog will display a message
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
        } else {
            String errorMessage = String.format("There was an error initialising the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }


    // Setting methods so that the app would lead the user to the questions part when video ends
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

            //making an intent to move back to the Main Menu
            Intent intentQues = new Intent(YouTubeActivity.this, MainMenu.class);
            startActivity(intentQues);

            //This sends back a message to the system let the programmer know method works when the video ends or not.
            Log.d(TAG, "Activity has ended");
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
