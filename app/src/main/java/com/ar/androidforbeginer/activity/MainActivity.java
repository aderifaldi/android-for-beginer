package com.ar.androidforbeginer.activity;

import android.content.Intent;
import android.net.Uri;
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
    private static final String DILO_URL = "http://bandung.dilo.id";

    private ImageView img_cover;
    private TextView txt_title, txt_vanue, txt_dilo_bandung;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cover = (ImageView) findViewById(R.id.img_cover);

        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_vanue = (TextView) findViewById(R.id.txt_vanue);
        txt_dilo_bandung = (TextView) findViewById(R.id.txt_dilo_bandung) ;

        //SET IMAGE FROM LOCAL ASSET
        img_cover.setImageResource(R.mipmap.android_beginner);

        //SET TEXT VIEW
        txt_title.setText(TITLE);
        txt_vanue.setText(VENUE);
        txt_dilo_bandung.setText(getResources().getString(R.string.dilo_bandung));

        //SET ON CLICK
        txt_dilo_bandung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDiloWebsite();
            }
        });

    }

    public void goTOListMember(View view){
        Intent intent = new Intent(getApplicationContext(), MemberListActivity.class);
        startActivity(intent);
    }

    public void goToDiloWebsite(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(DILO_URL));
        startActivity(intent);
    }

}
