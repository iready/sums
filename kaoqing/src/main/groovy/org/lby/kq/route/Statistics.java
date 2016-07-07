package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.lby.kq.aop.Aop_Statistics;
import org.lby.kq.common.SysVar;

/**
 * Created by 邹宇泉 on 2016/7/7.
 */
@Before(value = Aop_Statistics.class)
public class Statistics extends Controller implements SysVar {
    public void index() {

    }
}
