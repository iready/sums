package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.joda.time.DateTime;
import org.lby.kq.aop.Aop_Statistics;
import org.lby.kq.common.SysVar;
import org.lby.kq.service.ServiceOfSta;
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

    public void sure_tj() {
        Integer type = getParaToInt("unitType");
        String unit = getPara("unit");
        String days = getPara("i_days");
        Integer year = getParaToInt("year");
        Integer month = getParaToInt("month");
        ServiceOfSta.for_sure_tj(year, month, unit, type, days, this);
        renderNull();
    }
}