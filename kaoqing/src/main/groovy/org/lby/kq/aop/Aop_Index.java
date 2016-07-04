package org.lby.kq.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.lby.kq.common.SysVar;

public class Aop_Index implements Interceptor, SysVar {

    public void intercept(Invocation invocation) {
        invocation.getController().getRequest().setAttribute(route_name, 0);
        invocation.invoke();
    }
}
