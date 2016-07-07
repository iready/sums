package org.lby.kq.common

import com.jfinal.kit.JsonKit

/**
 * Created by Administrator on 2016/7/1.
 */
class CLZ {
    public static Map m = ['first': 0, 'second': 2, 'third': 3, 'fourth': 4];
    public static Map apply_type = [0: '外出', 1: '请假', 2: '出差'];

    private static Map<Map, String> json_st = new HashMap<>();

    static String getJson(Map map) {
        if (json_st.get(map) == null) {
            json_st.put(map, JsonKit.toJson(map));
        }
        return json_st.get(map);
    }
}