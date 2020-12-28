package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Website extends AppCompatActivity {

    private WebView mWeb;
    /* bron back button:
    S. (2018, 24 oktober). Show Back Button in Child Activity - Android Studio | Tutorial. YouTube.
    https://www.youtube.com/watch?v=W1MSs8rBtB4&feature=youtu.be
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_website);
        Intent intent = getIntent();
        String link = intent.getData().toString();

        mWeb = (WebView) findViewById(R.id.webview);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl(link);
    }
    /* bron back button:
    S. (2018, 24 oktober). Show Back Button in Child Activity - Android Studio | Tutorial. YouTube.
    https://www.youtube.com/watch?v=W1MSs8rBtB4&feature=youtu.be
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}