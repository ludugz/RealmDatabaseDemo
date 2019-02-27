package com.myself.realmdemo.database;

import io.realm.Realm;

/**
 * Created by admin on 2/27/2019.
 */

public class RealmManager {

    private static Realm mRealm;

    public static Realm open() {
        mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

    public static void close() {
        if (mRealm != null) {
            mRealm.close();
        }
    }

    public static RecordsDao recordsDao() {
        checkForOpenRealm();
        return new RecordsDao(mRealm);
    }

    private static void checkForOpenRealm() {
        if (mRealm == null || mRealm.isClosed()) {
            throw new IllegalStateException("RealmManager: Realm is closed, call open() method first");
        }
    }
}
