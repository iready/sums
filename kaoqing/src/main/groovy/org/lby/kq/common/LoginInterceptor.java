package org.lby.kq.common;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.apache.log4j.Logger;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.lby.kq.model.Apply;
import org.lby.kq.model.Dept;
import org.lby.kq.model.User;
import org.lby.kq.model.common.Manage_;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements Interceptor, SysVar {
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);


    public void intercept(Invocation ai) {
        try {
            Controller controller = ai.getController();
            HttpSession session = controller.getSession();
            String emailAttr = (String) session.getAttribute("email");
            if (emailAttr == null) {
                HttpServletRequest request = controller.getRequest();
                AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
                if (principal != null && principal.getName() != null) {
                    emailAttr = principal.getName();
                    User user = User.dao.queryByEmail(emailAttr);
                    session.setAttribute(EMAIL, emailAttr);
                    session.setAttribute(USER_NAME, user.getStr("XM"));
//					session.setAttribute(USER_ID, user.getInt("userId"));
                    session.setAttribute(DEPT_ID, user.getInt("orgId"));
                    session.setAttribute(FY, user.getStr("FY"));
                    session.setAttribute(DEPT_NAME, Dept.dao.queryDeptName(user.getInt("orgId")));
//					session.setAttribute(ROLES, Admin.dao.roles(email, user.getInt("orgId")));
                    session.setAttribute(PERMIS, Manage_.query_qx(role_qx, emailAttr));
//					session.setAttribute(SCOPES, RoleScope.dao.scopes(email, user.getInt("orgId")));
                    // session.setAttribute(JGBS, user.getInt("JGBS"));
                    // session.setAttribute(RYBS, user.getInt("RYBS"));
                    // session.setAttribute(ZW, user.getInt("ZW"));
                    // session.setAttribute(PHONE, user.getStr("SJHM"));
//					request.setAttribute("HELLO_", DayUtils.hello());
//					request.setAttribute(USER_NAME, user.getStr("XM"));
//					request.setAttribute(EMAIL, email.substring(0, email.indexOf("@gxfy.com")));
//					controller.setCookie(new Cookie(EMAIL, Base64Utils.encode(email)));
//					controller.setCookie(new Cookie(USER_NAME, Base64Utils.encode(user.getStr("XM"))));
                }
            }
            if (session.getAttribute(json_js_config) == null || debug) {
                Map<String, Object> map = new HashMap<>();
                map.put("mname", menu_name);
                map.put("murl", menu_url);
                map.put("permis", session.getAttribute(PERMIS));
                map.put("weidu", Apply.dao.db_count(emailAttr));
                session.setAttribute(json_js_config, JsonKit.toJson(map));
            }
            ai.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e, e);
        }
    }
}
