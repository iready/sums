package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.joda.time.DateTime;
import org.lby.kq.aop.Aop_Statistics;
import org.lby.kq.common.SysVar;
import org.zyq.core.lang.T;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 邹宇泉 on 2016/7/7.
 */
@Before(value = Aop_Statistics.class)
public class Statistics extends Controller implements SysVar {
    public void index() {

    }

    public void sure_time() {
        Integer year = getParaToInt("year"), m = getParaToInt("month");
        if (year != null && m != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("day_max", T.getMaxDayOfMonth(year, m));
            renderJson(map);
            return;
        }
        renderNull();
    }
}
