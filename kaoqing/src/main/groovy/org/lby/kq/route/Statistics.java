package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.joda.time.DateTime;
import org.lby.kq.aop.Aop_Statistics;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.Dept;
import org.lby.kq.model.Salary;
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
        Integer y = T.getNowYear();
        Integer m = T.getNowMonth();
        Map<String, Object> map = new HashMap<>();
        map.put("fy", getSessionAttr(FY));
        map.put("deptId", getSessionAttr(DEPT_ID));
        map.put("dept_name", Dept.dao.queryDeptName((Integer) getSessionAttr(DEPT_ID)));
        map.put("fyname", Dept.dao.queryFyName((String) getSessionAttr(FY)));
        map.put("now_year", y);
        map.put("yx_year", Salary.dao.days());
        map.put("now_month", m);
        map.put("max_day", T.getMaxDayOfMonth(y, m));
        map.put("first_week", new DateTime(y + "-" + m + "-01").getDayOfWeek());
        setAttr("r", JsonKit.toJson(map));
    }

    public void sure_time() {
        Integer year = getParaToInt("year"), m = getParaToInt("month");
        if (year != null && m != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("day_max", T.getMaxDayOfMonth(year, m));
            map.put("first_week", new DateTime(year + "-" + m + "-01").getDayOfWeek());
            renderJson(map);
            return;
        }
        renderNull();
    }

    /**
     * 确定统计
     */
    public void sure_tj() {
        Integer type = getParaToInt("unitType");
        String unit = getPara("unit");
        String days = getPara("i_days");
        Integer year = getParaToInt("year");
        Integer month = getParaToInt("month");
        ServiceOfSta.for_sure_tj(year, month, unit, type, days, this);
    }

    public void execl_dc() {
        Integer type = getParaToInt("unitType");
        String unit = getPara("unit");
        String days = getPara("i_days");
        Integer year = getParaToInt("year");
        Integer month = getParaToInt("month");
        ServiceOfSta.for_execl_dc(year, month, unit, type, days, this);
    }
}