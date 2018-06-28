package com.sibythampi.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here

    // TODO: Declare member variables here:
    Button mbutton;
    Button nbutton;
    TextView questionh;
    int mindex;
    int mquestion;
    int mscore1;
    TextView mscore;
    ProgressBar mProgressBar;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int INCREMENT=(int)Math.ceil(100.0/mQuestionBank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton=(Button)findViewById(R.id.true_button);
        nbutton=(Button)findViewById(R.id.false_button);
        questionh=(TextView)findViewById(R.id.question_text_view);
        mquestion=mQuestionBank[mindex].getQuestionid();
        questionh.setText(mquestion);
        mscore=(TextView)findViewById(R.id.score);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        View.OnClickListener listenerw=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getApplicationContext(), "True Pressed!", Toast.LENGTH_SHORT).show();
                check(true);
                update();
            }
        };
        mbutton.setOnClickListener(listenerw);
        View.OnClickListener listenerwr=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "False Pressed!", Toast.LENGTH_SHORT).show();
                check(false);
                update();
            }
        };
        nbutton.setOnClickListener(listenerwr);


    }
    private void update()
    {
        mindex=(mindex+1) % mQuestionBank.length;
        if(mindex==0 && mscore1!=13)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game over!Thanks for playing Sibi's game");
            alert.setCancelable(false);
            alert.setMessage("Your score is "+ mscore1);
            alert.setPositiveButton("Bas kar ab!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();

        }
        else if(mindex==0 && mscore1==13)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game over!Thanks for playing Sibi's game");
            alert.setCancelable(false);
            alert.setMessage("Your score is "+ mscore1);
            alert.setPositiveButton("Bas kar ab jeet gaya na!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
        mquestion=mQuestionBank[mindex].getQuestionid();
        questionh.setText(mquestion);
        mProgressBar.incrementProgressBy(INCREMENT);
        mscore.setText("Score:"+mscore1+"/"+"13");

    }
    private void check(boolean answer){
        boolean get=mQuestionBank[mindex].isTruefalse();
        if(get==answer)
        {
            Toast.makeText(getApplicationContext(),R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mscore1=mscore1+1;
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }
}
