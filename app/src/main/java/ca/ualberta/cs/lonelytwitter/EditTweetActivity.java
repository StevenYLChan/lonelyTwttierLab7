package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Gson gson = new Gson();
        NormalTweet ob = gson.fromJson(getIntent().getStringExtra("data"), NormalTweet.class);

        TextView txtView = (TextView) findViewById(R.id.textView);
        txtView.setText(ob.getMessage());


    }
}
