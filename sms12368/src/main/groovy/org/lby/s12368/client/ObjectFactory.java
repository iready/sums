
package org.lby.s12368.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.lby.s12368.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdatePassWordLoginID_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "loginID");
    private final static QName _UpdatePassWordOldPassWord_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "oldPassWord");
    private final static QName _UpdatePassWordNewPassWord_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "newPassWord");
    private final static QName _UpdatePassWordResponseReturn_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "return");
    private final static QName _StatisticsSmsListPassWord_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "passWord");
    private final static QName _MtSmsListStrXml_QNAME = new QName("http://webservice.server.webservice.qmhd.com.cn", "strXml");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.lby.s12368.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePassWord }
     * 
     */
    public UpdatePassWord createUpdatePassWord() {
        return new UpdatePassWord();
    }

    /**
     * Create an instance of {@link UpdatePassWordResponse }
     * 
     */
    public UpdatePassWordResponse createUpdatePassWordResponse() {
        return new UpdatePassWordResponse();
    }

    /**
     * Create an instance of {@link StatisticsSmsList }
     * 
     */
    public StatisticsSmsList createStatisticsSmsList() {
        return new StatisticsSmsList();
    }

    /**
     * Create an instance of {@link StatisticsSmsListResponse }
     * 
     */
    public StatisticsSmsListResponse createStatisticsSmsListResponse() {
        return new StatisticsSmsListResponse();
    }

    /**
     * Create an instance of {@link MtSmsList }
     * 
     */
    public MtSmsList createMtSmsList() {
        return new MtSmsList();
    }

    /**
     * Create an instance of {@link MtSmsListResponse }
     * 
     */
    public MtSmsListResponse createMtSmsListResponse() {
        return new MtSmsListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "loginID", scope = UpdatePassWord.class)
    public JAXBElement<String> createUpdatePassWordLoginID(String value) {
        return new JAXBElement<String>(_UpdatePassWordLoginID_QNAME, String.class, UpdatePassWord.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "oldPassWord", scope = UpdatePassWord.class)
    public JAXBElement<String> createUpdatePassWordOldPassWord(String value) {
        return new JAXBElement<String>(_UpdatePassWordOldPassWord_QNAME, String.class, UpdatePassWord.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "newPassWord", scope = UpdatePassWord.class)
    public JAXBElement<String> createUpdatePassWordNewPassWord(String value) {
        return new JAXBElement<String>(_UpdatePassWordNewPassWord_QNAME, String.class, UpdatePassWord.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "return", scope = UpdatePassWordResponse.class)
    public JAXBElement<String> createUpdatePassWordResponseReturn(String value) {
        return new JAXBElement<String>(_UpdatePassWordResponseReturn_QNAME, String.class, UpdatePassWordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "loginID", scope = StatisticsSmsList.class)
    public JAXBElement<String> createStatisticsSmsListLoginID(String value) {
        return new JAXBElement<String>(_UpdatePassWordLoginID_QNAME, String.class, StatisticsSmsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "passWord", scope = StatisticsSmsList.class)
    public JAXBElement<String> createStatisticsSmsListPassWord(String value) {
        return new JAXBElement<String>(_StatisticsSmsListPassWord_QNAME, String.class, StatisticsSmsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "return", scope = StatisticsSmsListResponse.class)
    public JAXBElement<String> createStatisticsSmsListResponseReturn(String value) {
        return new JAXBElement<String>(_UpdatePassWordResponseReturn_QNAME, String.class, StatisticsSmsListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "loginID", scope = MtSmsList.class)
    public JAXBElement<String> createMtSmsListLoginID(String value) {
        return new JAXBElement<String>(_UpdatePassWordLoginID_QNAME, String.class, MtSmsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "passWord", scope = MtSmsList.class)
    public JAXBElement<String> createMtSmsListPassWord(String value) {
        return new JAXBElement<String>(_StatisticsSmsListPassWord_QNAME, String.class, MtSmsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "strXml", scope = MtSmsList.class)
    public JAXBElement<String> createMtSmsListStrXml(String value) {
        return new JAXBElement<String>(_MtSmsListStrXml_QNAME, String.class, MtSmsList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.server.webservice.qmhd.com.cn", name = "return", scope = MtSmsListResponse.class)
    public JAXBElement<String> createMtSmsListResponseReturn(String value) {
        return new JAXBElement<String>(_UpdatePassWordResponseReturn_QNAME, String.class, MtSmsListResponse.class, value);
    }

}
