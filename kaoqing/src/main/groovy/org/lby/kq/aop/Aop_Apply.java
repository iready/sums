package org.lby.kq.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.lby.kq.common.SysVar;

/**
 * Created by 邹宇泉 on 2016/7/6.
 */
public class Aop_Apply implements Interceptor, SysVar {
    public void intercept(Invocation invocation) {
        invocation.getController().getRequest().setAttribute(route_name, 1);
        invocation.invoke();
    }
}
