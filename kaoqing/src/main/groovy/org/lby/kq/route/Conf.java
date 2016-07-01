package org.lby.kq.route;

import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.ConfigTime;
import org.lby.kq.service.ServiceOfConf;

import java.util.Date;
import java.util.UUID;

public class Conf extends Controller implements SysVar {
    public void index() {
        setAttr("isEdit", false);
    }

    public void del() {
        ConfigTime.dao.findById(getPara()).delete();
        renderNull();
    }

    public void view_list() {
        setAttr("c", ServiceOfConf.for_view_list(ConfigTime.dao.find_by_email((String) getSessionAttr(EMAIL))));
    }

    public void save() {
        ConfigTime configTime = getModel(ConfigTime.class, "c");
        if (configTime != null) {
            configTime.setProvider((String) getSessionAttr(EMAIL));
            if (configTime.getId() != null) {
                configTime.setCreateTime(new Date()).update();
            } else {
                configTime.setId(UUID.randomUUID().toString()).setCreateTime(new Date()).save();
            }
        }
        redirect("/config/view_list");
    }

    public void edit() {
        setAttr("c", JsonKit.toJson(ConfigTime.dao.findById(getPara()))).setAttr("isEdit", true);
        renderJsp("index.jsp");
    }
}