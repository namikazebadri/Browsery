package com.unisbadri.browsery.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unisbadri.browsery.activities.DefaultBrowserActivity;
import com.unisbadri.browsery.options.BrowserOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BrowserOptions options = new BrowserOptions();
        options.setUrl("http://");
        options.setTitle("");
        options.trackHistory(true);

        Intent intent = new Intent(this, DefaultBrowserActivity.class);
        intent.putExtra(BrowserOptions.BROWSER_OPTIONS, options);

        startActivity(intent);
    }
}
