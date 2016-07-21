package org.lby.s12368.config;

import org.zyq.core.lang.Encode;

import java.io.File;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
public class enc {
    public static void main(String[] args) {
        Encode.change(new File("D:\\JAVA\\workspace\\mine\\sums\\sms12368\\src\\main\\groovy\\org\\lby\\s12368\\client"), "gbk", "utf-8");
    }
}
