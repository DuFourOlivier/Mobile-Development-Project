package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoPage extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textView = findViewById(R.id.image_description);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(WordListAdapter.EXTRA_MSG);
        textView.setText(msg);

        //textView.setText();
    }
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