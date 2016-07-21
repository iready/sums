package org.lby.kq.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.lby.kq.common.SysVar;

public class Aop_Index implements Interceptor, SysVar {

    public void intercept(Invocation invocation) {
        String actionkey = invocation.getActionKey().replaceAll(invocation.getControllerKey() + "/", "");
        if (actionkey.contains("select")) {
            invocation.getController().getRequest().setAttribute(route_name, 1);
        } else
            invocation.getController().getRequest().setAttribute(route_name, 0);
        invocation.invoke();
    }
}
