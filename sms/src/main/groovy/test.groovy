import dao.MessageApi
import entity.SMS

/**
 * Created by Administrator on 2016/6/22.
 */
class test {
    public static void main(String[] args) {
        MessageApi.SendSMS(new SMS('zyq', '18172328353', '测试，收到请回复'))
    }
}