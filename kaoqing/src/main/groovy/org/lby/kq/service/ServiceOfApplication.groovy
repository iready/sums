package org.lby.kq.service

import com.jfinal.core.Controller
import com.jfinal.plugin.activerecord.Record
import org.lby.kq.common.SysVar
import org.lby.kq.model.Apply

/**
 * Created by 邹宇泉 on 2016/7/7.
 */
class ServiceOfApplication implements SysVar {
    static List<Record> for_db(Controller controller) {
        List<Record> records = Apply.dao.find_db((String) controller.getSessionAttr(EMAIL))
        records.each {

        }
        return null;
    }
}
