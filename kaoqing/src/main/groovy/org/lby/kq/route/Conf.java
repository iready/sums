package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.apache.log4j.Logger;
import org.lby.kq.aop.Aop_Conf;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.BridgeConfigUnit;
import org.lby.kq.model.ConfigTime;
import org.lby.kq.model.common.Manage_;
import org.lby.kq.service.ServiceOfConf;

import java.util.Date;

@Before(value = Aop_Conf.class)
public class Conf extends Controller implements SysVar {
    private static Logger logger = Logger.getLogger(Conf.class);

    public void index() {
        setAttr("isEdit", false);
        setAttr("c", "0");
        setAttr("u", "0");
    }

    public void del() {
        try {
            ConfigTime.dao.deleteById(getPara());
        } catch (Exception e) {
            logger.error(e, e);
            e.printStackTrace();
        } finally {
            renderNull();
        }
    }

    public void view_list() {
        try {
            setAttr("c", ServiceOfConf.for_view_list(ConfigTime.dao.find_by_fy((String) getSessionAttr(FY))));
        } catch (Exception e) {
            logger.error(e, e);
            e.printStackTrace();
        }
    }

    public void save() {
        BridgeConfigUnit bcu = getModel(BridgeConfigUnit.class, "u");
        ConfigTime configTime = getModel(ConfigTime.class, "c");
        if (configTime != null) {
            configTime.setProvider((String) getSessionAttr(EMAIL));
            if (configTime.getId() != null) {
                configTime.setCreateTime(new Date()).update();
            } else {
                configTime.setId(getUUId()).setCreateTime(new Date()).save();
            }
            BridgeConfigUnit.dao.clean_by_config(configTime);
            bcu.setConfId(configTime.getId()).setId(getUUId()).save();
        }
        redirect("/config/view_list");
    }

    public void edit() {
        ConfigTime bc = ConfigTime.dao.findById(getPara());
        setAttr("c", JsonKit.toJson(bc)).setAttr("isEdit", true);
        setAttr("u", JsonKit.toJson(BridgeConfigUnit.dao.find_by_config(bc)));
        renderJsp("index.jsp");
    }

    /**
     * ajax_重复性验证
     */
    public void ajax_cf_yz() {
        Long ut = getParaToLong("unitType");
        String u = getPara("unit");
        String id = getPara("id");
        try {
            if (ut != null && u != null) {
                String render = null;
                if (id.isEmpty())
                    render = BridgeConfigUnit.dao.count_by_unit_unitType(u, ut) + "";
                else
                    render = BridgeConfigUnit.dao.count_by_unit_unitType(u, ut, id) + "";
                renderText(render);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        renderNull();
    }
}