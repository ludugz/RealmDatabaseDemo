package com.myself.realmdemo.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by admin on 2/27/2019.
 */

public class Record extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;

    public Record() {

    }

    public Record(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
