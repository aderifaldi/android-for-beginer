package com.ar.androidforbeginer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ar.androidforbeginer.R;

/**
 * Created by aderifaldi on 28-Apr-16.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TITLE = "Android Training For Beginner";
    private static final String VENUE = "Gd. Bale Motekar UNPAD, Jln. Banda No.40 Bandung";

    private ImageView img_cover;
    private TextView txt_title, txt_vanue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cover = (ImageView) findViewById(R.id.img_cover);
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_vanue = (TextView) findViewById(R.id.txt_vanue);

        //SET IMAGE FROM LOCAL ASSET
        img_cover.setImageResource(R.mipmap.android_beginner);

        //SET TEXT VIEW
        txt_title.setText(TITLE);
        txt_vanue.setText(VENUE);

    }

    public void goTOListMember(View view){
        Intent intent = new Intent(getApplicationContext(), MemberListActivity.class);
        startActivity(intent);
    }

}
