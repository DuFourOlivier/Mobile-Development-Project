package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class InfoPage extends AppCompatActivity {
    private TextView mdescription;
    private TextView mtitle;
    private ImageView mimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mdescription = findViewById(R.id.Description);
        mtitle = findViewById(R.id.Title);
        mimage = findViewById(R.id.picture);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(DBListAdapter.EXTRA_MSG);
        String title = intent.getStringExtra(DBListAdapter.EXTRA_TITLE);


        mdescription.setText(msg);
        mtitle.setText(title);
        mimage.setImageResource(R.drawable.ic_action_name);



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