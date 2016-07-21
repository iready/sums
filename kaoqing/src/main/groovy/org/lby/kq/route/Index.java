package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.apache.log4j.Logger;
import org.lby.kq.aop.Aop_Index;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.ConfigTime;
import org.lby.kq.model.Salary;
import org.lby.kq.service.ServiceOfIndex;

import java.util.HashMap;
import java.util.Map;

@Before(value = Aop_Index.class)
public class Index extends Controller implements SysVar {
    private static Logger logger = Logger.getLogger(Index.class);

    //打卡页面
    public void index() {
        String email = getSessionAttr(EMAIL);
        String confId = ServiceOfIndex.getConfId(this);
        setAttr("salarys", JsonKit.toJson(Salary.dao.find_email_now(email)));
        setAttr("confId", confId);
        ConfigTime configTime = ConfigTime.dao.findById(confId);
        if (confId != null) setAttr("c", JsonKit.toJson(configTime));
            /*按钮显示判断*/
        if (configTime != null)
            setAttr("btn_show", JsonKit.toJson(ServiceOfIndex.btn_analysis(configTime)));
    }

    public void select() {
        Map<String, Object> map = new HashMap<>();
        map.put("", "");
        setAttr("c", JsonKit.toJson(map));
    }

    /**
     * 打卡
     */
    public void dk() {
        Integer type = getParaToInt("type", 0);
        renderJson(ServiceOfIndex.judegeIsDK(this, type));
    }

    public void ajax_time() {

    }
}