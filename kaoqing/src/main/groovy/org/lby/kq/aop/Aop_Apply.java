package org.lby.kq.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.lby.kq.common.SysVar;

/**
 * Created by 邹宇泉 on 2016/7/6.
 */
public class Aop_Apply implements Interceptor, SysVar {
    public void intercept(Invocation invocation) {
        String actionkey = invocation.getActionKey().replaceAll(invocation.getControllerKey() + "/", "");
        if (actionkey.contains("sp")) {
            invocation.getController().getRequest().setAttribute(route_name, 2);
        } else if (actionkey.contains("db")) {
            invocation.getController().getRequest().setAttribute(route_name, 3);
        } else
            invocation.getController().getRequest().setAttribute(route_name, 1);
        invocation.invoke();
    }
}
