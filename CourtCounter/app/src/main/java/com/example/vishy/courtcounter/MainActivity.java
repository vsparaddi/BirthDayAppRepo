package com.example.vishy.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    // Tracks the score for Team A and Team B
    int scoreTA = 0, scoreTB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String jamesbond = "hi";
        String jamesBond = "hello";
        String s = jamesBond + jamesbond;
*/
        if (savedInstanceState != null) {
            scoreTA = savedInstanceState.getInt("scoreTA");
            scoreTB = savedInstanceState.getInt("scoreTB");
        }
        displayTA(scoreTA);
        displayTB(scoreTB);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreTA", scoreTA);
        outState.putInt("scoreTB", scoreTB);
    }

    /**
     * Increase the score by Team A 1 point.
     */
    public void AddOneTA(View v) {
        scoreTA = scoreTA + 1;
        displayTA(scoreTA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void AddTwoTA(View v) {
        scoreTA = scoreTA + 2;
        displayTA(scoreTA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void AddThreeTA(View v) {
        scoreTA = scoreTA + 3;
        displayTA(scoreTA);
    }

    /**
     * Increase the score by Team B 1 point.
     */
    public void AddOneTB(View v) {
        scoreTB = scoreTB + 1;
        displayTB(scoreTB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void AddTwoTB(View v) {
        scoreTB = scoreTB + 2;
        displayTB(scoreTB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void AddThreeTB(View v) {
        scoreTB = scoreTB + 3;
        displayTB(scoreTB);
    }

    public void resetScore(View v) {
        scoreTA = 0;
        scoreTB = 0;
        displayTA(scoreTA);
        displayTB(scoreTB);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayTA(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.team_a_score);
        if(null != quantityTextView)
            quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayTB(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.team_b_score);
        if(null != quantityTextView)
            quantityTextView.setText("" + number);
    }
    /*
This method displays the given price on the screen.
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

*/

}