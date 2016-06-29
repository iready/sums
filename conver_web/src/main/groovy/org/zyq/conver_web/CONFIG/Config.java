package org.zyq.conver_web.config;

import com.jfinal.config.*;
import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/6/28.
 */
public class Config extends JFinalConfig {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);

    public void afterJFinalStart() {
        super.afterJFinalStart();
        BasicConfigurator.configure();
    }

    @Override
    public void beforeJFinalStop() {
        super.beforeJFinalStop();
        fixedThreadPool.shutdownNow();
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
