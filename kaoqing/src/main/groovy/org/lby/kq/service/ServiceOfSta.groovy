package org.lby.kq.service

import com.jfinal.core.Controller
import org.joda.time.DateTime
import org.lby.kq.model.Anay_tj
import org.lby.kq.model.ConfigTime
import org.lby.kq.model.Dept
import org.lby.kq.model.Salary
import org.lby.kq.model.User

/**
 * Created by 邹宇泉 on 2016/7/8.
 */
class ServiceOfSta {
    static void for_sure_tj(Integer year, Integer month, String unit, Integer type, String days, Controller controller) {
        try {
            if (type == 0) {
                //统计法院的情况
                List<Salary> salaries = Salary.dao.find_by_fy(unit, year, month, days);
                anay_salarys(salaries, days, year, month);
            } else if (type == 1) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void anay_salarys(List<Salary> salaries, String days, Integer year, Integer month) {
        //部门、姓名、迟到（次）、早退（次）、旷工（次）、外出（次）、请假（天）、出差（天）
        List<Anay_tj> anay_tjs = new ArrayList<>();
//        纯粹根据java来统计
        List<String> names = [];//仅用来快速判断anay_tjs的name
        Map<String, List<Salary>> group_time = new HashMap<>();
        if (days == null) {

        }
        if (salaries != null) {
            salaries.each {
                it.yx = User.dao.queryByEmail(it.yx).getStr('XM');
                it.deptId = Dept.dao.findById(it.deptId).getStr('MC');
                String time = new DateTime(it.timeDj).toString("yyyy-MM-dd")
                if (group_time.containsKey(time)) {
                    group_time.get(time).add(it);
                } else {
                    List<Salary> s = new ArrayList<Salary>();
                    s.add(it);
                    group_time.put(time, s);
                }
            }
            group_time.each {
                for (int i = 0; i < 4; i++) {
                    Salary salary = it.value.find { iv -> return iv.type == i }
                    if (salary == null) {
                        //未打卡
                    } else {
                        Anay_tj anay_tj = null;
                        if (names.contains(salaries.yx)) {
                            anay_tj = anay_tjs.find { return it.name == salary.yx }
                        } else {
                            anay_tj = new Anay_tj();
                            anay_tjs.add(anay_tj);
                        }
                        ConfigTime configTime = ConfigTime.dao.findById(salary.confid);


                    }

                    println salary
                }
//                it.key
            }
        }
//        println anay_tjs
//        println salaries
    }
}
