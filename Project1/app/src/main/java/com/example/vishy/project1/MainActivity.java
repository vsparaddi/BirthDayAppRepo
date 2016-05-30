package com.example.vishy.project1;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.vishy.project1.Model.StoryModel;

import java.util.ArrayList;
import java.util.List;


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


        final List<StoryModel> rowListItem = getAllStoryList();

        GridLayoutManager lLayout = new GridLayoutManager(MainActivity.this, 2);


        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);

        if (null != rView) {
            rView.setHasFixedSize(true);
            rView.setLayoutManager(lLayout);

            RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
            rView.setAdapter(rcAdapter);

            rView.addOnItemTouchListener(
                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            String textTitle = rowListItem.get(position).getTitle();
                            int imageId = rowListItem.get(position).getImageId();
                            String textStory = rowListItem.get(position).getStory();

                            Intent myIntent = new Intent(MainActivity.this, LoadContentActivity.class);

                            myIntent.putExtra("textTitle", textTitle);
                            myIntent.putExtra("imageId", imageId);
                            myIntent.putExtra("textStory", textStory);
                            myIntent.putExtra("readerEnabled", readerEnabled);
                            myIntent.putExtra("largeFontSize", largeFontSize);
                            myIntent.putExtra("nightMode", nightMode);
                            MainActivity.this.startActivity(myIntent);
                        }
                    })
            );
        }
    }

    private List<StoryModel> getAllStoryList() {

        List<StoryModel> allStory = new ArrayList<>();

        allStory.add(new StoryModel(getString(R.string.title1),
                (R.drawable.monkey_croco),
                (R.drawable.monkey_crocodile),
                getString(R.string.story1)));
        allStory.add(new StoryModel(getString(R.string.title2),
                (R.drawable.shepherd_and_wolf_icon),
                (R.drawable.the_shepherd_and_the_wolf),
                getString(R.string.story2)));
        allStory.add(new StoryModel(getString(R.string.title3),
                (R.drawable.four_friends_icon),
                (R.drawable.four_friends_and_the_hunter),
                getString(R.string.story3)));
        allStory.add(new StoryModel(getString(R.string.title4),
                (R.drawable.talkative_tortoise),
                (R.drawable.the_talkative_tortoise),
                getString(R.string.story4)));
        allStory.add(new StoryModel(getString(R.string.title5),
                (R.drawable.cat_bell),
                (R.drawable.the_bell_and_the_cat),
                getString(R.string.story5)));
        allStory.add(new StoryModel(getString(R.string.title6),
                (R.drawable.jackal_arrow),
                (R.drawable.the_jackal_and_the_arrow),
                getString(R.string.story6)));
        allStory.add(new StoryModel(getString(R.string.title7),
                (R.drawable.wind_sun),
                (R.drawable.the_wind_and_the_sun),
                getString(R.string.story7)));
        allStory.add(new StoryModel(getString(R.string.title8),
                (R.drawable.lion_hare_ion),
                (R.drawable.the_lion_and_the_hare),
                getString(R.string.story8)));
        return allStory;
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

        View view = findViewById(R.id.app_bar);
        if (null != view) {
            Snackbar.make(view, "STORY TIME   Ver 1.0\n" +
                    " @2016 vishwanath.paraddi@gmail.com", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
    }
}
