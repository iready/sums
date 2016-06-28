package org.zyq.conver_web.webservice.conver;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/6/28.
 */
@WebService(endpointInterface = "org.zyq.conver_web.webservice.conver.IConver", targetNamespace = "http://webservice.conver.com")
public class IConverImpl implements IConver {

    @Override
    public void toPdf(String file_name, byte[] file) {
        
    }

    @Override
    public void toSwf(String file_name, byte[] file) {

    }
}
