package org.lby.kq.common;

import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.ModelRecordElResolver;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import org.lby.kq.model.Dept;
import org.lby.kq.model.User;
import org.lby.kq.model._MappingKit;
import org.lby.kq.route.Conf;
import org.lby.kq.route.Index;

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
        constants.setEncoding("utf-8");
        constants.setDevMode(false);
        constants.setViewType(ViewType.JSP);
        constants.setBaseViewPath("/WEB-INF/view");
//        BasicConfigurator.configure();
    }


    public void configRoute(Routes routes) {
        routes.add("/", Index.class, "/index");
        routes.add("/config", Conf.class, "/conf");
    }


    public void configPlugin(Plugins plugins) {
        {/*本项目配置*/
            DruidPlugin dkq = getKaoQingPlugin();
            ActiveRecordPlugin ar_kq = new ActiveRecordPlugin(dkq).setShowSql(true);
            _MappingKit.mapping(ar_kq);
            plugins.add(dkq).add(ar_kq);
        }
        {/*6.23配置*/
            DruidPlugin druidPlugin23 = getBasePlugin();
            ActiveRecordPlugin ar23 = new ActiveRecordPlugin(SysVar.BASE, druidPlugin23).setShowSql(true);
            ar23.addMapping(User.TABLE_NAME, "userId", User.class);
            ar23.addMapping(Dept.TABLE_NAME, "orgId", Dept.class);
            plugins.add(druidPlugin23).add(ar23);
        }
    }


    public void configInterceptor(Interceptors interceptors) {
        interceptors.add(new LoginInterceptor());
    }


    public void configHandler(Handlers handlers) {

    }

    @Override
    public void afterJFinalStart() {
        super.afterJFinalStart();
        ModelRecordElResolver.setResolveBeanAsModel(true);
    }
}
