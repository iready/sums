package org.lby.s12368.bean;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.bean.BeanElement;
import org.dom4j.dom.DOMText;
import org.dom4j.tree.BaseElement;
import org.dom4j.tree.DefaultText;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * Created by 邹宇泉 on 2016/7/20.
 */
public class Message {
    public String SmsID;
    public String RecvNum;
    public String Content;
    public String CourtCode = "2750";
    public String CaseType = "999";
    public String BusinessCode = "999";
    public String SystemCode = "999";

    public Message(String recvnum, String content) {
        RecvNum = recvnum;
        Content = content;
        SmsID = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("SMS");
        root.addAttribute("type", "sendSms");
        root.add(new Message("13299266512", "测试咯").toElement());
        System.out.println(document.asXML());
    }

    public Element toElement() throws IllegalAccessException {
        Element element = new BaseElement("Message");
        for (Field field : Message.class.getDeclaredFields()) {
            element.addAttribute(field.getName(), (String) field.get(this));
        }
        return element;
    }
}
