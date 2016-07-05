package org.lby.kq.service

import com.jfinal.core.Controller
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.lby.kq.common.SysVar
import org.lby.kq.model.BridgeConfigUnit
import org.lby.kq.model.ConfigTime
import org.lby.kq.model.Salary

import java.text.SimpleDateFormat

/**
 * Created by Administrator on 2016/7/5.
 */
class ServiceOfIndex implements SysVar {
    /**
     * 根据当前用户拿到合适的id
     *
     * @return
     */
    static String getConfId(Controller controller) {
        Integer dept_id = controller.getSessionAttr(DEPT_ID);
        String confId = BridgeConfigUnit.dao.find_conId(dept_id, 1l);
        if (confId == null || confId.trim().isEmpty()) {
            String fy = controller.getSessionAttr(FY);
            confId = BridgeConfigUnit.dao.find_conId(fy, 0l);
        }
        return confId;
    }

    /**
     * 判断打卡的有效性
     * @return
     */
    static Map<String, Object> judegeIsDK(Controller controller, int type) {
        String confId = getConfId(controller);
        Map<String, Object> result = new HashMap<>();
        result.put("result", false);
        if (confId == null || confId.trim().isEmpty()) {
            result.put("info", "未配置打卡信息");
            controller.renderJson(result);
        } else {
            String email = controller.getSessionAttr(EMAIL);
            //判断有没有打卡
            if (Salary.dao.isCanDK(email, type)) {
                ConfigTime configTime = ConfigTime.dao.findById(confId);
                String string_dk = null;
                Date date_now = new Date();
                String string_dk_pre = new SimpleDateFormat("yyyy-MM-dd").format(date_now).toString()
                Integer before_dk = null, after_dk = null;
                switch (type) {
                    case 0:
                        string_dk = configTime.first;
                        break;
                    case 1:
                        string_dk = configTime.second;
                        break;
                    case 2:
                        string_dk = configTime.third;
                        break;
                    case 3:
                        string_dk = configTime.fourth;
                        break;
                }
                if (type == 0 || type == 2) {
                    before_dk = configTime.getBeforeSb();
                    after_dk = configTime.getAfterSb();
                } else {
                    before_dk = configTime.getBeforeXb();
                    after_dk = configTime.getAfterXb();
                }
                //限定打卡时间
                DateTime date_dk = DateTime.parse(string_dk_pre + " " + string_dk, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
                //打卡时间在打卡限定时间内
                DateTime date_before_dk = date_dk.minusMinutes(before_dk);
                DateTime date_after_dk = date_dk.plusMinutes(after_dk);
                DateTime now = new DateTime();
                if (date_before_dk.isBefore(now) && date_after_dk.isAfter(now)) {
                    result.result = 'success';
                    new Salary().setId(controller.getUUId()).setYx(email).setTimeDj(date_now).setFy(controller.getSessionAttr(FY) as String).setDeptId(controller.getSessionAttr(DEPT_ID) as String).setConfid(confId).setType(type).save();
                    println '打卡成功'
                } else {
                    result.info = '打卡时间已过或者未到';
                }
            } else {
                result.info = '已经打过卡了';
            }
        }
        return result;
    }
}
