package com.example.vishy.project1;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean readerEnabled = false;
    boolean largeFontSize = false;
    boolean nightMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_story_book);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        //savedInstanceState.putBoolean("mainLayout", mainLayout);
        savedInstanceState.putBoolean("readerEnabled", readerEnabled);
        savedInstanceState.putBoolean("largeFontSize", largeFontSize);
        savedInstanceState.putBoolean("nightMode", nightMode);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        //mainLayout = savedInstanceState.getBoolean("mainLayout");
        readerEnabled = savedInstanceState.getBoolean("readerEnabled");
        largeFontSize = savedInstanceState.getBoolean("largeFontSize");
        nightMode = savedInstanceState.getBoolean("nightMode");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_story_book, menu);
        MenuItem item = menu.findItem(R.id.readerEnabled);
        item.setChecked(readerEnabled);
        item = menu.findItem(R.id.largeFontSize);
        item.setChecked(largeFontSize);
        item = menu.findItem(R.id.nightMode);
        item.setChecked(nightMode);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.readerEnabled:
                if (item.isChecked()) {
                    item.setChecked(false);
                    readerEnabled = false;
                } else {
                    item.setChecked(true);
                    readerEnabled = true;

                }

                break;
            case R.id.largeFontSize:
                if (item.isChecked()) {
                    item.setChecked(false);
                    largeFontSize = false;
                } else {
                    item.setChecked(true);
                    largeFontSize = true;
                }

                break;
            case R.id.nightMode:
                if (item.isChecked()) {
                    item.setChecked(false);
                    nightMode = false;
                } else {
                    item.setChecked(true);
                    nightMode = true;
                }

                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }



    public void aboutMessage(MenuItem item) {

        //Log.e("About", "Story reader Version 1.0\n" +
        //        " @2016  vishwanath.paraddi@gmail.com");
        //Toast.makeText(StoryBookActivity.this, "Story reader Version 1.0\n @2016  vishwanath.paraddi@gmail.com",
        //        Toast.LENGTH_LONG).show();
        View view = findViewById(R.id.app_bar);
        if (null != view) {
            Snackbar.make(view, "Story reader Version 1.0\n" +
                    " @2016  vishwanath.paraddi@gmail.com", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
    }

    public void loadContents(View view) {
        String textTitle = "";
        int imageId = 0;
        String textStory = "";

        switch (view.getId()) {
            case R.id.index1:
                textTitle = getResources().getString(R.string.title1);
                imageId = R.drawable.monkey_crocodile;
                textStory = getResources().getString(R.string.story1);

                break;
            case R.id.index2:
                textTitle = getResources().getString(R.string.title2);
                imageId = R.drawable.the_shepherd_and_the_wolf;
                textStory = getResources().getString(R.string.story2);

                break;

            case R.id.index3:
                textTitle = getResources().getString(R.string.title3);
                imageId = R.drawable.four_friends_and_the_hunter;
                textStory = getResources().getString(R.string.story3);

                break;
            case R.id.index4:
                textTitle = getResources().getString(R.string.title4);
                imageId = R.drawable.the_talkative_tortoise;
                textStory = getResources().getString(R.string.story4);
                break;
            case R.id.index5:
                textTitle = getResources().getString(R.string.title5);
                imageId = R.drawable.the_bell_and_the_cat;
                textStory = getResources().getString(R.string.story5);
                break;
            case R.id.index6:
                textTitle = getResources().getString(R.string.title6);
                imageId = R.drawable.the_jackal_and_the_arrow;
                textStory = getResources().getString(R.string.story6);
                break;
            case R.id.index7:
                textTitle = getResources().getString(R.string.title7);
                imageId = R.drawable.the_wind_and_the_sun;
                textStory = getResources().getString(R.string.story7);
                break;
            case R.id.index8:
                textTitle = getResources().getString(R.string.title8);
                imageId = R.drawable.the_lion_and_the_hare;
                textStory = getResources().getString(R.string.story8);
                break;
            default:
                Snackbar.make(view, "Contents not available", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }

        Intent myIntent = new Intent(MainActivity.this, LoadContentActivity.class);
        myIntent.putExtra("textTitle", textTitle);
        myIntent.putExtra("imageId", imageId);
        myIntent.putExtra("textStory", textStory);
        myIntent.putExtra("readerEnabled", readerEnabled);
        myIntent.putExtra("largeFontSize", largeFontSize);
        myIntent.putExtra("nightMode", nightMode);
        MainActivity.this.startActivity(myIntent);


    }




}
