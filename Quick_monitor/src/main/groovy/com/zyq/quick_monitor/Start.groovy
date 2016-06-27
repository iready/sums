package com.zyq.quick_monitor

import com.jfinal.plugin.activerecord.Record
import com.zyq.quick_monitor.view.OP
import org.zyq.swing.SwingUtils

import javax.swing.*

class Start {
    public static void main(String[] args) {
        Class.forName("com.zyq.quick_monitor.common.Config");
        List<Record> list = [];
        JFrame frame = new JFrame("Quick_Monitor");
        SwingUtils.beatiful_up();
        SwingUtils.setjFrame(frame);
        SwingUtils.window_init_end(frame, new OP().$$$getRootComponent$$$());
//        println MongoKit.getCollection("jw_click").find(new BasicDBObject('userid', '12312')).count();
    }
}