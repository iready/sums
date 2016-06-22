package entity;

/**
 * Created by Yuquan Zou on 2015/12/25.
 */
public class SMS {

    private String user;
    private String phone;
    private String content;

    public SMS() {

    }

    public SMS(String user, String phone, String content) {
        this.user = user;
        this.phone = phone;
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

