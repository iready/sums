package org.lby.kq.common;


public interface SysVar {
        String sys_In = "http://147.1.4.52:5200";//接口地址
//    String sys_In = "http://147.1.7.12:81";//接口地址
    String sys_pq = "http://147.1.4.53:8191";//排期地址

    String USER_ID = "USER_ID_";// 用户ID
    String DEPT_ID = "DEPT_ID_";// 部门ID
    String USER_NAME = "USER_NAME_";// 用户名
    String EMAIL = "EMAIL_";// 邮箱
    String PHONE = "PHONE_";// 手机
    String JGBS = "JGBS_";// 机构标识
    String RYBS = "RYBS_";// 人员标识
    String FY = "FY_";// 法院
    String ZW = "ZW_";// 职务
    String DEPT_NAME = "dept_name_____";//全名
    String BASE = "base__";
    String KQ = "kq__";

    String route_name = "_route_name";
    String route_index = "_index";
    String[] menu_name = new String[]{"我要打卡", "查询", "我的申请", "我的审批", "我的待办", "统计", "参数配置", "权限管理"};
    String[] menu_url = new String[]{"/", "/select", "/apply", "/apply/sp", "/apply/db", "/statistics", "/config/view_list", "http://147.1.4.53:8008/admin/home/kq"};

    String role_qx = "kq";
    String PERMIS = "pri$$";

    String json_js_config = "!@#$!config";

    boolean debug = true;
}