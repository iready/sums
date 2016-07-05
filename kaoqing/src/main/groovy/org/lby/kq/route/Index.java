package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.lby.kq.aop.Aop_Index;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.BridgeConfigUnit;
import org.lby.kq.model.ConfigTime;

@Before(value = Aop_Index.class)
public class Index extends Controller implements SysVar {
    //打卡页面
    public void index() {
        String confId = getConfId();
        setAttr("confId", confId);
        if (confId != null) {
            setAttr("c", JsonKit.toJson(ConfigTime.dao.findById(confId)));
        }
    }

    private String getConfId() {
        Integer dept_id = getSessionAttr(DEPT_ID);
        String confId = BridgeConfigUnit.dao.find_conId(dept_id, 1l);
        if (confId == null || confId.trim().isEmpty()) {
            String fy = getSessionAttr(FY);
            confId = BridgeConfigUnit.dao.find_conId(fy, 0l);
        }
        return confId;
    }

    /**
     * 打卡
     */
    public void dk() {
        String confId = getConfId();
        if (confId == null || confId.trim().isEmpty()) {
            Integer type = getParaToInt("type");
            System.out.println(type);
        }
        renderNull();
    }
}