package com.example.nrt2281999.databasequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TopicQuiz extends Activity {

    //Declaring the components to link to the UI
    TextView questionTextView;
    Button trueButton;
    Button falseButton;

    //Defining the Questions array to store the questions
    Questions[] question = new Questions[30];

    //To keep track of which question is being asked
    int quesNumber = 0;

    //creating a "topic" object to store the topic name being transferred from the intent
    String topic;

    String TAG = "TopicQuiz";

    //To count the number of questions the user got right
    int rightQuesCounter = 0;

    //To count how many questions have been asked
    int quesCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_quiz);

        //Linking the components to the UI
        questionTextView = findViewById(R.id.quesTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);

        //Constructing the question objects with actual parameters
        //set of questions for sqlite
        question[0] = new Questions(R.string.question1, true, "This is true");
        question[1] = new Questions(R.string.question2, true, "True-By default android stores " +
                "your database in private file spaces of your application where other applications cannot access it ");
        question[2] = new Questions(R.string.question3, false, "False- you can create from using the constructor " +
                "of SQLiteOpenHelper sub class");
        question[3] = new Questions(R.string.question4, true,"This is true");
        question[4] = new Questions(R.string.question5, false, "This is false");
        question[5] = new Questions(R.string.question6, false," False- you must always call the method " +
                "before you begin reading values ");
        question[6] = new Questions(R.string.question7, false, "False- you must specifiy the selection criteria" +
                " that identifies the rows ");
        question[7] = new Questions(R.string.question8, true, "This is true");
        question[8] = new Questions(R.string.question9, true, "This is true");
        question[9] = new Questions(R.string.question10, true, "This is true, To create the database " +
                "openOrCreateDatabase() method is called ");


        //set of questions for Content Provider
        question[10] = new Questions(R.string.question11, true, "This is true");
        question[11] = new Questions(R.string.question12, true, "This is true");
        question[12] = new Questions(R.string.question13, true, "This is true");
        question[13] = new Questions(R.string.question14, false, "False – a content provider is used to act as a middle layer " +
                "and manage access to the data, the contract is used to contact the content provider ");
        question[14] = new Questions(R.string.question15, true, "This is true");
        question[15] = new Questions(R.string.question16, false, "False- it requires a content URI which uniquely identifies " +
                "a set of data – based off this the content provider knows which app you want to talk to ");
        question[16] = new Questions(R.string.question17, false, "False- each app has their own content provider ");
        question[17] = new Questions(R.string.question18, true, "This is true");
        question[18] = new Questions(R.string.question19, false, "False- this easily introduces bugs into the system. " +
                "It is recommended to use content providers instead");
        question[19] = new Questions(R.string.question20, false,"False- this easily introduces bugs into the system." +
                " It is recommended to use content providers instead" );


        //set of questions for Content Resolver
        question[20] = new Questions(R.string.question21, true, "This is true");
        question[21] = new Questions(R.string.question22, false, "False- a content resolver takes a URI and managers" +
                " (resolves) which provider it should go to ");
        question[22] = new Questions(R.string.question23, true, "This is true");
        question[23] = new Questions(R.string.question24, true, "This is true");
        question[24] = new Questions(R.string.question25, false, "False – uses a content resolver to help this ");
        question[25] = new Questions(R.string.question26, true, "This is true");
        question[26] = new Questions(R.string.question27, true, "This is true");
        question[27] = new Questions(R.string.question28, false, "False – a content resolver is used to determine which app’s content provider to use ");
        question[28] = new Questions(R.string.question29, true, "This is true");
        question[29] = new Questions(R.string.question30, false, "False- it does not need to know ");


        //Retrieving the intent sent
        Intent intent = getIntent();

        //Defining the "topic" object with the "topic_name" delivered by the intent
        topic = intent.getStringExtra("topic_name");

        //checking to see if the method getStringExtra worked or not, to see if topic is null.
        Log.d(TAG, "The name of the topic is: " + topic);

        //Setting the textView to the first question of the corresponding topic
        //Setting quesNumber to the corresponding first question number of the topic being asked
        if (topic.equals("sqlite")) {
            questionTextView.setText(question[0].getQuesStatement());
            quesNumber = 0;
        } else if (topic.equals("contentprovider")) {
            questionTextView.setText(question[10].getQuesStatement());
            quesNumber = 10;
        } else {
            questionTextView.setText(question[20].getQuesStatement());
            quesNumber = 20;
        }



        //setting an OnClickListener for the buttons to return a feedback on the user's answer and
        //move to the next question
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //increment the counter to get the quiz to stop moving to the next question if it's
                //the last on already
                quesCounter++;
                if (quesCounter < 10) {
                    //returning a feedback saying "correct answer" if the user has chosen the correct answer and
                    //"incorrect answer" otherwise
                    if (question[quesNumber].isAnsTrue()) {
                        Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        rightQuesCounter++;
                    } else {
                        Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
                        question[quesNumber].setWrong(true);
                    }

                    //incrementing quesNumber to move to the next question
                    quesNumber++;
                    questionTextView.setText(question[quesNumber].getQuesStatement());

                } else {
                    if (question[quesNumber].isAnsTrue()) {
                        Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        rightQuesCounter++;
                    } else {
                        Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();

                    }
                    //Checking to see if the rightQuesCounter worked or not
                    Log.d(TAG, "You have got " + rightQuesCounter + " out of 10");

                    //Having an intent to move to the Result screen while passing the rightQuesCounter to get the result
                    Intent intent = new Intent(TopicQuiz.this, Result.class);
                    intent.putExtra("rightQuesCounter", rightQuesCounter);

                    startActivity(intent);
                }

            }

        });

        falseButton.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View view) {
                                               //increment the counter to get the quiz to stop moving to the next question if it's
                                               //the last on already
                                               quesCounter++;
                                               if (quesCounter < 10) {
                                                   //returning a feedback saying "correct answer" if the user has chosen the correct answer and
                                                   //"incorrect answer" otherwise
                                                   if (question[quesNumber].isAnsTrue()) {
                                                       Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();


                                                   } else {
                                                       Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                       rightQuesCounter++;
                                                   }
                                                   //incrementing quesNumber to move to the next question
                                                   quesNumber++;
                                                   questionTextView.setText(question[quesNumber].getQuesStatement());
                                               } else {
                                                   if (question[quesNumber].isAnsTrue()) {
                                                       Toast.makeText(TopicQuiz.this, "Incorrect Answer", Toast.LENGTH_SHORT).show();


                                                   } else {
                                                       Toast.makeText(TopicQuiz.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                                                       rightQuesCounter++;
                                                   }

                                                   //Checking to see if the rightQuesCounter worked or not
                                                   Log.d(TAG, "You have got " + rightQuesCounter + " out of 10");

                                                   //Having an intent to move to the Result screen while passing the rightQuesCounter to get the result
                                                   Intent intent = new Intent(TopicQuiz.this, Result.class);
                                                   intent.putExtra("rightQuesCounter", rightQuesCounter);


                                                   startActivity(intent);
                                               }
                                           }
                                       }
        );
    }

}
