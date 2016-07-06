package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.lby.kq.aop.Aop_Apply;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.Apply;

import java.util.Date;

/**
 * Created by 邹宇泉 on 2016/7/6.
 */
@Before(value = Aop_Apply.class)
public class Application extends Controller implements SysVar {
    public void index() {
        setAttr("a", JsonKit.toJson(Apply.dao.find_sq((String) getSessionAttr(EMAIL))));
    }

    public void add() {

    }

    public void save() {
        try {
            Apply apply = getModel(Apply.class, "a");
            apply.setId(getUUId()).setSqr((String) getSessionAttr(EMAIL)).setTimeSq(new Date()).save();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redirect("/apply");
        }
    }

    public void sp() {

    }

    public void db() {

    }
}
