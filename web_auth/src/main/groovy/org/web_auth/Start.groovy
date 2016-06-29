package org.web_auth

import org.zyq.http.DefaultHttpUtils
import org.zyq.http.HttpUtils
import org.zyq.http.entity.Config

/**
 * Created by Administrator on 2016/6/29.
 */
class Start {
    public static void main(String[] args) {
        HttpUtils httpUtils = new DefaultHttpUtils(new Config());
        println httpUtils.post('http://192.168.88.1/webAuth/', ['username': '软件运维', 'password': '123456', 'pwd': '123456', 'secret': 'true'])

    }
}
