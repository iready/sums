package org.zyq.conver_web.webservice.conver;

import javax.jws.WebService;

/**
 * Created by Administrator on 2016/6/28.
 */
@WebService
public interface IConver {

    void toPdf(String file_name, String file, String toMDD);

    void toSwf(String file_name, String file, String mdd);

}
