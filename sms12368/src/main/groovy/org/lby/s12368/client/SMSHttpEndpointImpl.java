
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.lby.s12368.client;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-07-20T15:58:27.135+08:00
 * Generated source version: 3.1.6
 * 
 */

@javax.jws.WebService(
                      serviceName = "SMS",
                      portName = "SMSHttpEndpoint",
                      targetNamespace = "http://webservice.server.webservice.qmhd.com.cn",
                      wsdlLocation = "http://192.2.102.157/services/SMS?wsdl",
                      endpointInterface = "org.lby.s12368.client.SMSPortType")
                      
public class SMSHttpEndpointImpl implements SMSPortType {

    private static final Logger LOG = Logger.getLogger(SMSHttpEndpointImpl.class.getName());

    /* (non-Javadoc)
     * @see org.lby.s12368.client.SMSPortType#mtSmsList(java.lang.String  loginID ,)java.lang.String  passWord ,)java.lang.String  strXml )*
     */
    public java.lang.String mtSmsList(java.lang.String loginID,java.lang.String passWord,java.lang.String strXml) { 
        LOG.info("Executing operation mtSmsList");
        System.out.println(loginID);
        System.out.println(passWord);
        System.out.println(strXml);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.lby.s12368.client.SMSPortType#updatePassWord(java.lang.String  loginID ,)java.lang.String  oldPassWord ,)java.lang.String  newPassWord )*
     */
    public java.lang.String updatePassWord(java.lang.String loginID,java.lang.String oldPassWord,java.lang.String newPassWord) { 
        LOG.info("Executing operation updatePassWord");
        System.out.println(loginID);
        System.out.println(oldPassWord);
        System.out.println(newPassWord);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.lby.s12368.client.SMSPortType#statisticsSmsList(java.lang.String  loginID ,)java.lang.String  passWord )*
     */
    public java.lang.String statisticsSmsList(java.lang.String loginID,java.lang.String passWord) { 
        LOG.info("Executing operation statisticsSmsList");
        System.out.println(loginID);
        System.out.println(passWord);
        try {
            java.lang.String _return = "";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
