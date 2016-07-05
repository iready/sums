package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.lby.kq.aop.Aop_Index;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.BridgeConfigUnit;
import org.lby.kq.model.ConfigTime;
import org.lby.kq.service.ServiceOfIndex;

import java.util.HashMap;
import java.util.Map;

@Before(value = Aop_Index.class)
public class Index extends Controller implements SysVar {
    //打卡页面
    public void index() {
        String confId = ServiceOfIndex.getConfId(this);
        setAttr("confId", confId);
        if (confId != null) {
            setAttr("c", JsonKit.toJson(ConfigTime.dao.findById(confId)));
        }
    }

    /**
     * 打卡
     */
    public void dk() {
        Integer type = getParaToInt("type", 0);
        renderJson(ServiceOfIndex.judegeIsDK(this, type));
    }

}