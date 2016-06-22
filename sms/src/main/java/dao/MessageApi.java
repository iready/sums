package dao;

import entity.Email;
import entity.SMS;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuquan Zou on 2015/12/25.
 */
public class MessageApi {
    private static final String SQLSMSINSERT = "INSERT INTO sms2( FROM_ID, PHONE, CONTENT, SEND_TIME, SEND_FLAG,TASK,FAIL_CODE,FAIL_TEXT) VALUES (?,?,?,now(),'0','0','','')";
    private static final String SQLEMAILINSERT = "INSERT INTO email ( FROM_ID, TO_ID, TO_ID2, COPY_TO_ID, SECRET_TO_ID, SUBJECT, CONTENT, SEND_TIME, ATTACHMENT_ID, ATTACHMENT_NAME, READ_FLAG, SEND_FLAG, DELETE_FLAG, SMS_REMIND, BOX_ID, IMPORTANT, WJLX, WJSP) VALUES ( ?, ?, ?, '', '', ?, ?, now(), '', '', '0', '1', '0', '', 0, '0', 0, 0)";
    private static final String SQLUSERSELECTBYID = "select YOUXIANG yx from org_user where userId=?";
    private static final String SQLUSERFINDMB = "select  * from org_user  WHERE substring_index(YOUXIANG,'@gxfy.com',1)=?";
    private static Logger logger = Logger.getLogger(MessageApi.class);

    public static void SendEmail(Email email) {
        String own = transfer(email.getOwn()), target = transfer(email.getTarget());
        if (own != null && target != null) {
            Connection connection = JdbcUtils.getEmailConnection();
            try {
                QueryRunner queryRunner = new QueryRunner();
                queryRunner.update(connection, SQLEMAILINSERT, own, target, target + ",", email.getSubject(), email.getContent());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.close(connection);
            }
        }
    }

    /**
     * 能够接受内网人员id，邮箱，以及邮箱前缀
     *
     * @param user
     * @param content
     */
    public static void SendSMS(String user[], String content) {
        List<SMS> smsList = new ArrayList<SMS>();
        Connection connection = JdbcUtils.getUserConnection();
        try {
            QueryRunner queryRunner = new QueryRunner();
            for (String f : user) {
                SMS sms = new SMS();
                String username = transfer(f);
                Object phone = queryRunner.query(connection, SQLUSERFINDMB, new ScalarHandler("sjhm"), username);
                if (username == null || phone == null) {

                    continue;
                }
                sms.setUser(username);
                sms.setPhone(phone.toString());
                sms.setContent(content);
                SendSMS(sms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * @param smss 多条短信
     */
    public static void SendSMS(List<SMS> smss) {
        Connection connection = JdbcUtils.getSMSConnection();
        try {
            connection.setAutoCommit(false);
            QueryRunner queryRunner = new QueryRunner();
            String[][] a = new String[smss.size()][3];
            for (int i = 0; i < smss.size(); i++) {
                SMS sms = smss.get(i);
                a[i][0] = sms.getUser();
                a[i][1] = sms.getPhone();
                a[i][2] = sms.getContent();
            }
            queryRunner.batch(connection, SQLSMSINSERT, a);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * @param sms 发送单条信息
     */
    public static void SendSMS(SMS sms) {
        Connection connection = JdbcUtils.getSMSConnection();
        try {
            QueryRunner queryRunner = new QueryRunner();
            int i = queryRunner.update(connection, SQLSMSINSERT, sms.getUser(), sms.getPhone(), sms.getContent());
            if (i == 0)
                logger.debug("向用" + sms.getUser() + "户发送信息，发送失败!信息内容为：" + sms.getContent());
            else
                logger.info("向用" + sms.getUser() + "户发送信息，发送成功!信息内容为：" + sms.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
    }

    /**
     * 将userId或邮箱格式的Id转为截掉@gxfy.com的字符串
     *
     * @param user
     * @return
     */
    public static String transfer(String user) {
        String name = null;
        try {
            Integer.parseInt(user);
            Connection connection = JdbcUtils.getUserConnection();
            try {
                QueryRunner queryRunner = new QueryRunner();
                name = queryRunner.query(connection, SQLUSERSELECTBYID, new ScalarHandler("yx"), user).toString();
                name = name.substring(0, name.lastIndexOf("@gxfy.com"));
            } catch (Exception e) {
            } finally {
                JdbcUtils.close(connection);
            }
        } catch (java.lang.NumberFormatException f) {
            if (user.indexOf("@gxfy.com") > -1) {
                name = user.substring(0, user.lastIndexOf("@gxfy.com"));
            } else {
                name = user;
            }
        }
        return name;
    }
}
