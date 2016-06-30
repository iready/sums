package org.lby.kq.common;

import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.ModelRecordElResolver;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import org.apache.log4j.BasicConfigurator;
import org.lby.kq.model._MappingKit;
import org.lby.kq.route.Conf;
import org.lby.kq.route.Index;

/**
 * Created by Administrator on 2016/6/30.
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


    public void configConstant(Constants constants) {
        constants.setEncoding("utf-8");
        constants.setDevMode(false);
        constants.setViewType(ViewType.JSP);
        constants.setBaseViewPath("/WEB-INF/view");
        BasicConfigurator.configure();
    }


    public void configRoute(Routes routes) {
        routes.add("/", Index.class);
        routes.add("/config", Conf.class, "/conf");
    }


    public void configPlugin(Plugins plugins) {
        DruidPlugin druidPlugin = getKaoQingPlugin();
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin).setShowSql(true);
        _MappingKit.mapping(activeRecordPlugin);
        plugins.add(druidPlugin).add(activeRecordPlugin);
    }


    public void configInterceptor(Interceptors interceptors) {

    }


    public void configHandler(Handlers handlers) {

    }

    @Override
    public void afterJFinalStart() {
        super.afterJFinalStart();
        ModelRecordElResolver.setResolveBeanAsModel(true);
    }
}
