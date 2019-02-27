package com.myself.realmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myself.realmdemo.adapter.RecordsAdapter;
import com.myself.realmdemo.database.RealmManager;

public class ResultActivity extends AppCompatActivity {
    private RecyclerView mRvRealm;
    private RecordsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mRvRealm = findViewById(R.id.recycler_view_realm);
        mAdapter = new RecordsAdapter(RealmManager.recordsDao().loadRecords(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvRealm.setLayoutManager(linearLayoutManager);
        mRvRealm.setAdapter(mAdapter);

    }
}
