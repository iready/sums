
package org.lby.s12368.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="oldPassWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newPassWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loginID",
    "oldPassWord",
    "newPassWord"
})
@XmlRootElement(name = "updatePassWord")
public class UpdatePassWord {

    @XmlElementRef(name = "loginID", namespace = "http://webservice.server.webservice.qmhd.com.cn", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loginID;
    @XmlElementRef(name = "oldPassWord", namespace = "http://webservice.server.webservice.qmhd.com.cn", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oldPassWord;
    @XmlElementRef(name = "newPassWord", namespace = "http://webservice.server.webservice.qmhd.com.cn", type = JAXBElement.class, required = false)
    protected JAXBElement<String> newPassWord;

    /**
     * 获取loginID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoginID() {
        return loginID;
    }

    /**
     * 设置loginID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoginID(JAXBElement<String> value) {
        this.loginID = value;
    }

    /**
     * 获取oldPassWord属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOldPassWord() {
        return oldPassWord;
    }

    /**
     * 设置oldPassWord属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOldPassWord(JAXBElement<String> value) {
        this.oldPassWord = value;
    }

    /**
     * 获取newPassWord属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNewPassWord() {
        return newPassWord;
    }

    /**
     * 设置newPassWord属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNewPassWord(JAXBElement<String> value) {
        this.newPassWord = value;
    }

}
