package org.lby.kq.model.common;

import com.jfinal.plugin.activerecord.Db;
import org.lby.kq.common.SysVar;

import java.util.Arrays;
import java.util.List;

public class Manage_ implements SysVar {

    public static List<String> query_qx(String type, String email) {
        String str = Db.use(BASE).queryStr("SELECT group_concat(DISTINCT qrp.permi ORDER BY qrp.permi) l FROM qxgl_admin qd, qxgl_role_permi qrp WHERE qd.type = ? AND qd.email = ? AND qd.type = qrp.type", type, email);
        return Arrays.asList(str.split(","));
    }
}
