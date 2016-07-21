package org.lby.s12368.webservice;

import javax.jws.WebService;
import java.util.UUID;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
@WebService(endpointInterface = "org.lby.s12368.webservice.SMSService")
public class SMSServiceImpl implements SMSService {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    public String reportSmsList(String loginId, String passWord, String xml) {
        System.out.println(loginId);
        System.out.println(passWord);
        System.out.println(xml);
        return null;
    }
}