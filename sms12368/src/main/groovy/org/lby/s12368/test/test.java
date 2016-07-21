package org.lby.s12368.test;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.lby.s12368.bean.Message;
import org.lby.s12368.client.SMS;
import org.lby.s12368.client.SMSPortType;
import org.zyq.core.algorithm.Des;
import org.zyq.core.algorithm.MD5;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
public class test {
    private static final QName SERVICE_NAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "SMS");
    private static String login_id = "Gxfy12368";
    private static String password;
    SMSPortType port = null;
    URL wsdl = new URL("http://192.2.102.157/services/SMS?wsdl");

    public test() throws MalformedURLException {
        try {
            password = new Des("B9A7942CB9").encrypt(MD5.encode("Gxfy12368"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        port = new SMS(wsdl, SERVICE_NAME).getSMSHttpSoap12Endpoint();
    }

    @Test
    public void mtSmsList() throws IllegalAccessException {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("SMS");
        root.addAttribute("type", "sendSms");
        root.add(new Message("13299266512", "联通测试1").toElement());
//        root.add(new Message("18172328353", "电信测试2").toElement());
//        root.add(new Message("15778409992", "移动测试3").toElement());
        String result = port.mtSmsList(login_id, password, doc.asXML());
        System.out.println(result);
    }

    @Test
    public void statisticsSmsList() {
        String result = port.statisticsSmsList(login_id, password);
        System.out.println(result);
    }

    @Test
    public void updatePassWord() throws Exception {
        String new_pass = "123";
        new_pass = new Des("B9A7942CB9").encrypt(MD5.encode(new_pass));
        String result = port.updatePassWord(login_id, password, new_pass);
        System.out.println(result);
    }
}