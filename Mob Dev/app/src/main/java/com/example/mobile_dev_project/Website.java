package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Website extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        Intent intent = getIntent();
        String link = intent.getData().toString();

        mWeb = (WebView) findViewById(R.id.webview);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl(link);
    }
}