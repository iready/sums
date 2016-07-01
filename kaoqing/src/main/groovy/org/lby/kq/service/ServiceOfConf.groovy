package org.lby.kq.service

import com.jfinal.plugin.activerecord.Record
import org.lby.kq.model.User

class ServiceOfConf {

    static List<Record> for_view_list(List<Record> records) {
        records.each {
            it.set('provider', User.dao.queryByEmail(it.getStr('provider')).get("XM"));
        }
        return records;
    }
}