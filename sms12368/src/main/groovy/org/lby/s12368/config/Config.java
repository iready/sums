package org.lby.s12368.config;

import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
public class Config extends JFinalConfig {
    static Prop prop = null;

    static {
        prop = PropKit.use("db.properties");
    }


    public static DruidPlugin druidFactory(DruidPlugin druidPlugin) {
        return druidPlugin.setValidationQuery("SELECT 1").set(5, 1, 20).setMaxActive(40).setMaxWait(10000).setValidationQuery("select 1").setTestOnBorrow(true).setTestWhileIdle(true).setTimeBetweenEvictionRunsMillis(10000);
    }

    public static DruidPlugin getKaoQingPlugin() {
        return druidFactory(new DruidPlugin(PropKit.get("kq_url"), PropKit.get("kq_user"), PropKit.get("kq_pas")));
    }

    public static DruidPlugin getBasePlugin() {
        return druidFactory(new DruidPlugin(PropKit.get("base_url"), PropKit.get("base_user"), PropKit.get("base_pas")));
    }


    public void configConstant(Constants constants) {

    }


    public void configRoute(Routes routes) {

    }


    public void configPlugin(Plugins plugins) {

    }


    public void configInterceptor(Interceptors interceptors) {

    }


    public void configHandler(Handlers handlers) {

    }
}
