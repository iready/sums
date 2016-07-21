package org.lby.s12368.webservice;

import javax.jws.WebService;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
@WebService
public interface SMSService {
    String reportSmsList(String loginId, String passWord, String xml);
}