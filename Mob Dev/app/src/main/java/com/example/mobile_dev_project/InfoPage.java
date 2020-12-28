package com.example.mobile_dev_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;
import java.net.URL;
import java.util.List;

public class InfoPage extends AppCompatActivity {
    private TextView mdescription;
    private TextView mtitle;
    private ImageView mimage;
    private Button mbutton;
    private Button mMaps;
    static int imagerec;
    /* bron back button:
    S. (2018, 24 oktober). Show Back Button in Child Activity - Android Studio | Tutorial. YouTube.
    https://www.youtube.com/watch?v=W1MSs8rBtB4&feature=youtu.be
    */
    /* Bron maps:
    Delessio, C., Conder, S., & Darcey, L. (z.d.). Working with ImageViews and Bitmaps in Android Application Development | Examining ImageView | InformIT. Informit.van
    https://www.informit.com/articles/article.aspx?p=2423187
    */
    /* bron webview:
    Coding in Flow. (2017, 23 oktober). WebView - Android Studio Tutorial [Video]. YouTube.
     https://www.youtube.com/watch?v=TUXui5ItBkM
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mdescription = findViewById(R.id.Description);
        mtitle = findViewById(R.id.Title);
        mimage = findViewById(R.id.picture);
        mbutton = findViewById(R.id.button);
        mMaps = findViewById(R.id.buttonmaps);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(DBListAdapter.EXTRA_MSG);
        String title = intent.getStringExtra(DBListAdapter.EXTRA_TITLE);
        String imageName = intent.getStringExtra(DBListAdapter.EXTRA_IMAGE);
        String link = intent.getStringExtra(DBListAdapter.EXTRA_LINK);
        Uri maps = intent.getData();
        imagerec = Integer.parseInt(imageName);
        mimage.setImageResource(imagerec);
        mdescription.setText(msg);
        mtitle.setText(title);
        Log.d("TAG", "onCreate: INFORMATION URI MAPS.EMPTY " + maps.toString());
        if(maps.toString() == Uri.EMPTY.toString() )
        {
            mMaps.setVisibility(View.INVISIBLE);
        }

        //mimage.setImageResource(R.drawable.ic_action_name);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webintent = new Intent(v.getContext(),Website.class);
                webintent.setData(Uri.parse(link));
                startActivity(webintent);

            }
        });

            /* Bron maps:
            Delessio, C., Conder, S., & Darcey, L. (z.d.). Working with ImageViews and Bitmaps in Android Application Development | Examining ImageView | InformIT. Informit.van
            https://www.informit.com/articles/article.aspx?p=2423187
            */
        mMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapsintent = new Intent();
                mapsintent.setAction(intent.ACTION_VIEW);
                mapsintent.setData(maps);
                startActivity(mapsintent);
            }
        });




    /* bron back button:
    S. (2018, 24 oktober). Show Back Button in Child Activity - Android Studio | Tutorial. YouTube.
    https://www.youtube.com/watch?v=W1MSs8rBtB4&feature=youtu.be
    */
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