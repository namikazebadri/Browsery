package com.unisbadri.browsery.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unisbadri.browsery.options.BrowserOptions;

public class InAppBrowserActivity extends AppCompatActivity {

    protected BrowserOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void initialize(int layout) {
        setContentView(layout);

        this.options = getIntent().getParcelableExtra(BrowserOptions.BROWSER_OPTIONS);
    }
}
