package com.example.vishy.project1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bluejamesbond.text.DocumentView;

import java.util.Locale;


public class LoadContentActivity extends AppCompatActivity {

    TextToSpeech tts;
    boolean readerEnabled = false;
    boolean largeFontSize = false;
    boolean nightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String textTitle = intent.getStringExtra("textTitle");
        int imageId = intent.getIntExtra("imageId", 0);
        String textStory = intent.getStringExtra("textStory");
        readerEnabled = intent.getBooleanExtra("readerEnabled", false);
        largeFontSize = intent.getBooleanExtra("largeFontSize", false);
        nightMode = intent.getBooleanExtra("nightMode", false);

        setContentView(R.layout.content_story_book2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (null != toolbar) {
            toolbar.setTitle(textTitle);
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if (imageView != null) {
            imageView.setBackgroundResource(imageId);
        }

         final DocumentView storyView = (DocumentView) findViewById(R.id.textView1);

        if (storyView != null) {
            storyView.setText(textStory);

            if (largeFontSize) {
                storyView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            }
            else {
                storyView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            }
           if (nightMode) {
                storyView.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
                storyView.getDocumentLayoutParams().setTextColor(ContextCompat.getColor(this, R.color.white));
            } else {
                storyView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
               storyView.getDocumentLayoutParams().setTextColor(ContextCompat.getColor(this, R.color.black));
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (null != fab) {
            if (!readerEnabled)
                fab.setVisibility(View.INVISIBLE);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //        .setAction("Action", null).show();
                    if (readerEnabled)
                        reader(storyView);
                }
            });

        }

    }

    @Override
    public void onBackPressed() {


        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onBackPressed();
    }

    @Override
    public void onStart() {


        tts = new TextToSpeech(LoadContentActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {

                    int result = tts.setLanguage(Locale.US);

                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("error", "This Language is not supported");
                    }

                    tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {

                        @Override
                        public void onStart(String utteranceId) {
                            Log.d("TAG", "onStart ( utteranceId :" + utteranceId + " ) ");
                        }

                        @Override
                        public void onError(String utteranceId) {
                            Log.d("TAG", "onError ( utteranceId :" + utteranceId + " ) ");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
                                    if (null != button)
                                        button.setImageResource(R.drawable.speak);

                                }
                            });
                        }

                        @Override
                        public void onDone(String utteranceId) {
                            Log.d("TAG", "onDone ( utteranceId :" + utteranceId + "  ) ");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
                                    if (null != button)
                                        button.setImageResource(R.drawable.speak);

                                }
                            });

                        }

                    });

                } else
                    Log.e("error", "Initialization Failed!");
            }
        });
        super.onStart();
    }


    @Override
    protected void onStop() {

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onStop();
    }

    public void reader(View view) {

        if (tts.isSpeaking()) {
            tts.playSilentUtterance(750, TextToSpeech.QUEUE_FLUSH, null);

            FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
            if (null != button)
                button.setImageResource(R.drawable.speak);
        } else {

            TextView textView = (TextView) findViewById(R.id.textView1);
            if (null != textView) {
                String text = textView.getText().toString();
                ConvertTextToSpeech(text);

                FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
                if (null != button)
                    button.setImageResource(R.drawable.stop);
            }

        }
    }

    private void ConvertTextToSpeech(String text) {

        if (text == null || "".equals(text)) {
            text = "Content not available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {

            String utteranceId = this.hashCode() + "UniqueID";
            Bundle params = new Bundle();
            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, utteranceId);

            tts.speak(text, TextToSpeech.QUEUE_FLUSH, params, utteranceId);
            //tts.synthesizeToFile(text,null,"/sdcard/temp","stringId" );
        }

    }
}

