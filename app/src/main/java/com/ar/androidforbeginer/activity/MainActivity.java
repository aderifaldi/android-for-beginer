package com.ar.androidforbeginer.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ar.androidforbeginer.R;
import com.ar.androidforbeginer.app.adapter.MemberListAdapter;
import com.ar.androidforbeginer.app.api.ApiGetMember;
import com.ar.androidforbeginer.app.model.Member;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog loading;
    private RecyclerView list_member;
    private LinearLayoutManager linearLayoutManager;
    private MemberListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = new ProgressDialog(this);
        loading.show();

        list_member = (RecyclerView) findViewById(R.id.list_member);

        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MemberListAdapter(this);

        list_member.setLayoutManager(linearLayoutManager);
        list_member.setAdapter(adapter);

        getDataFromAPI();

    }

    /**
     * GET DATA FROM API
     */
    private void getDataFromAPI(){

        ApiGetMember apiGetMember = new ApiGetMember(getApplicationContext()) {
            @Override
            public void onFinishRequest(boolean success, String returnItem) {

                loading.dismiss();

                if (success){
                    if (data != null){
                        if (data.getAlert().getAlert_code() == 0){

                            for (Member member : data.getMember()){
                                adapter.getListMember().add(member);
                                adapter.notifyDataSetChanged();
                            }

                        }
                    }
                }

            }
        };
        apiGetMember.executeAjax();
    }

}
