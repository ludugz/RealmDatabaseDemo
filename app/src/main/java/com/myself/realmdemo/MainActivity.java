package com.myself.realmdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myself.realmdemo.AppUtils.Constants;
import com.myself.realmdemo.adapter.RecordsAdapter;
import com.myself.realmdemo.database.RealmManager;
import com.myself.realmdemo.database.RecordsDao;
import com.myself.realmdemo.model.Record;

import java.util.ArrayList;
import java.util.List;

import io.realm.ObjectServerError;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSave;
    private Button mBtnLoad;
    private EditText mEdtId;
    private EditText mEdtName;
    private List<Record> mRecordList = new ArrayList<>();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RealmManager.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RealmManager.open();
//        initUser();

        mBtnSave = findViewById(R.id.btn_save_data);
        mBtnLoad = findViewById(R.id.btn_load_data);
        mBtnSave.setOnClickListener(this);
        mBtnLoad.setOnClickListener(this);
        mEdtId = findViewById(R.id.edt_id);
        mEdtName = findViewById(R.id.edt_name);
    }

    private void initUser() {
        SyncCredentials credentials = SyncCredentials.usernamePassword("abcc", "Whysheied2", true);

//        SyncUser.loginAsync(credentials, "https://assist.us1a.cloud.realm.io", new SyncUser.Callback() {
//            @Override
//            public void onSuccess(SyncUser user) {
//                Log.i("tntan", "onSuccess: ");
//            }
//
//            @Override
//            public void onError(ObjectServerError error) {
//                Log.i("tntan", "onError: " + error.toString());
//
//            }
//        });



        String authURL = "https://assist.us1a.cloud.realm.io";
        SyncCredentials credentials_2 = SyncCredentials.usernamePassword("bog", "tan", true);

        SyncUser.Callback callback = new SyncUser.Callback() {
            @Override
            public void onSuccess(SyncUser user) {
                                Log.i("tntan", "onSuccess: ");
            }

            @Override
            public void onError(ObjectServerError error) {
                Log.i("tntan", "onError: " + error.toString());

            }
        };
        SyncUser.loginAsync(credentials_2, authURL, callback);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save_data:
                Record record = new Record(mEdtId.getText().toString(), mEdtName.getText().toString());
                saveRealmData(record);
                break;
            case R.id.btn_load_data:
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void saveRealmData(Record record) {
        RealmManager.recordsDao().saveRecords(record);
    }

    private void loadRealmData() {
        RealmManager.recordsDao().loadRecords();
    }
}
