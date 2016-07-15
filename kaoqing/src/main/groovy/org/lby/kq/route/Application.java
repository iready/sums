package org.lby.kq.route;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.lby.kq.aop.Aop_Apply;
import org.lby.kq.common.SysVar;
import org.lby.kq.model.Apply;
import org.lby.kq.service.ServiceOfApplication;

import java.util.Date;

/**
 * Created by 邹宇泉 on 2016/7/6.
 */
@Before(value = Aop_Apply.class)
public class Application extends Controller implements SysVar {
    public void index() {
        try {
            setAttr("a", JsonKit.toJson(Apply.dao.page_sq(getParaToInt("page", 1), getParaToInt("pageSize", 10), (String) getSessionAttr(EMAIL))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add() {

    }

    /**
     * 保存
     */
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

    /**
     * 审批
     */
    public void sp() {
        setAttr("a", JsonKit.toJson(ServiceOfApplication.for_sp(this)));
    }

    /**
     * ajax_sp
     */
    public void ajax_sp() {
        try {
            String id = getPara("id"), re = getPara("sp_reason");
            Integer state = getParaToInt("state");
            Apply apply = Apply.dao.findById(id);
            if (apply != null && id != null && state != null && re != null) {
                apply.setState(state).setTimeSp(new Date()).setSpReason(re).update();
            }
            renderText("审批成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 待办
     */
    public void db() {
        setAttr("a", JsonKit.toJson(ServiceOfApplication.for_db(this)));
    }

}
