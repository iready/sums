package org.lby.kq.model.common;

import com.jfinal.plugin.activerecord.Db;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.lby.kq.common.SysVar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manage_ implements SysVar {

    public static List<String> query_qx(String type, String email) {
        String str = Db.use(BASE).queryStr("SELECT group_concat(DISTINCT qrp.permi ORDER BY qrp.permi) l FROM qxgl_admin qd, qxgl_role_permi qrp WHERE qd.type = ? AND qd.email = ? AND qd.type = qrp.type", type, email);
        if (str == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(str.split(","));
    }

    /**
     * 根据部门查看之高院用户能够看到基层院用户
     *
     * @return
     */
    public static String query_previw(String type, String system_type) {
        if ("K00".equals(system_type)) {
            return " like 'K%' ";
        } else {
            if (system_type.endsWith("0")) {
                return " like '" + system_type.substring(0, 2) + "%' ";
            } else {
                return " like '" + system_type + "' ";
            }

        }
    }
}