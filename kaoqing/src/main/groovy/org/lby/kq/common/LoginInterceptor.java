package org.lby.kq.common;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.lby.kq.model.Dept;
import org.lby.kq.model.User;
import org.lby.kq.model.common.Manage_;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements Interceptor, SysVar {

    @Override
    public void intercept(Invocation ai) {
        try {
            Controller controller = ai.getController();
            HttpSession session = controller.getSession();
            Object emailAttr = session.getAttribute("email");
            if (emailAttr == null) {
                HttpServletRequest request = controller.getRequest();
                AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
                if (principal != null && principal.getName() != null) {
                    String email = principal.getName();
                    User user = User.dao.queryByEmail(email);
                    session.setAttribute(EMAIL, email);
                    session.setAttribute(USER_NAME, user.getStr("XM"));
//					session.setAttribute(USER_ID, user.getInt("userId"));
                    session.setAttribute(DEPT_ID, user.getInt("orgId"));
                    session.setAttribute(FY, user.getStr("FY"));
                    session.setAttribute(DEPT_NAME, Dept.dao.queryDeptName(user.getInt("orgId")));
//					session.setAttribute(ROLES, Admin.dao.roles(email, user.getInt("orgId")));
                    session.setAttribute(PERMIS, Manage_.query_qx(role_qx, email));
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
                session.setAttribute(json_js_config, JsonKit.toJson(map));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ai.invoke();
        }
    }
}
