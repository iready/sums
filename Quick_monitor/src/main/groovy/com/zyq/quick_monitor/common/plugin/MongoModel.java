package com.zyq.quick_monitor.common.plugin;

import com.jfinal.kit.JsonKit;
import com.mongodb.*;
import com.mongodb.util.JSON;

public abstract class MongoModel<T> {
    public int save() {
        String va = MongodbPlugin.collList.get(this.getClass());
        if (va == null) {
            throw new com.mongodb.MongoException("未在插件中定义" + this.getClass());
        } else {
            return MongoKit.getCollection(va).insert(toDBObject(this)).getN();
        }
    }

    private DBObject toDBObject(Object object) {
        return (DBObject) JSON.parse(JsonKit.toJson(object));
    }
}
