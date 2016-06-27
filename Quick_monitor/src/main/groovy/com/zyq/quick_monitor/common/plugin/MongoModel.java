package com.zyq.quick_monitor.common.plugin;

import com.jfinal.kit.JsonKit;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Created by Administrator on 2016/6/24.
 */
public abstract class MongoModel<T> {
    public int save() {
        String va = MongodbPlugin.collList.get(this.getClass());
        if (va == null) {
            System.out.println("出错");
        } else {
            System.out.println(MongoKit.getCollection(va));
            return MongoKit.getCollection(va).insert(toDBObject(this)).getN();
        }
        return 0;
    }

    private DBObject toDBObject(Object object) {
        return (DBObject) JSON.parse(JsonKit.toJson(object));
    }
}
