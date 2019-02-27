package com.myself.realmdemo.database;

import android.support.annotation.NonNull;

import com.myself.realmdemo.model.Record;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by admin on 2/27/2019.
 */

public class RecordsDao {

    private Realm mRealm;

    public RecordsDao(@NonNull Realm realm) {
        mRealm = realm;
    }

    public void saveRecords(final Record record) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mRealm.copyToRealmOrUpdate(record);
            }
        });
    }

    public RealmResults<Record> loadRecords() {
        return mRealm.where(Record.class).findAllAsync();
    }
}
