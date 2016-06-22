package entity;

/**
 * Created by Yuquan Zou on 2015/12/25.
 */
public class Email {
    private String Own;//邮件发起人
    private String target;//邮件接收人
    private String subject;//标题
    private String content;//内容

    public Email() {
    }

    public Email(String own, String target, String subject, String content) {
        Own = own;
        this.target = target;
        this.subject = subject;
        this.content = content;
    }

    public String getOwn() {
        return Own;
    }

    public void setOwn(String own) {
        Own = own;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
