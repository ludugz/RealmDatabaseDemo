package com.myself.realmdemo.application;

import android.app.Application;

import com.myself.realmdemo.migration.MyMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by admin on 2/27/2019.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        if (instance == null)
            return instance = new MyApplication();
        else
            return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRealm();

        final RealmConfiguration configuration = new RealmConfiguration.Builder().name("sample.realm").schemaVersion(2).migration(new MyMigration()).build();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("tan")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
