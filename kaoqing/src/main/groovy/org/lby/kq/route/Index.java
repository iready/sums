package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.lby.kq.aop.Aop_Index;

@Before(value = Aop_Index.class)
public class Index extends Controller {
    //打卡页面
    public void index() {
        System.out.println();
    }
}