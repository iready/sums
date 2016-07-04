package org.lby.kq.aop;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import org.lby.kq.common.SysVar;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Aop_Conf implements Interceptor, SysVar {

    @Override
    public void intercept(Invocation invocation) {
        invocation.getController().getRequest().setAttribute(route_name, 5);
        invocation.invoke();
    }
}
