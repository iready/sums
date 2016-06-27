package com.zyq.quick_monitor.common;


import com.zyq.quick_monitor.common.plugin.MongodbPlugin;
import com.zyq.quick_monitor.entity.Mstsc;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Config {
    static {
        MongodbPlugin mongodbPlugin = new MongodbPlugin("core");
        mongodbPlugin.addMapping("mstsc", Mstsc.class);
        mongodbPlugin.start();
    }
}
