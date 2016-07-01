package org.lby.kq.route;

import com.jfinal.core.Controller;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.ConfigTime;

import java.util.UUID;

public class Conf extends Controller implements SysVar {
    public void index() {

    }

    public void view_list() {
        setAttr("c", ConfigTime.dao.find_by_email((String) getSessionAttr(EMAIL)));
    }

    public void save() {
        getModel(ConfigTime.class, "c").setProvider((String) getSessionAttr(EMAIL)).setId(UUID.randomUUID().toString()).save();
        redirect("/config/view_list");
    }

    public void view_edit() {

    }
}