package org.zyq.conver_web.webservice.conver;

import org.zyq.conver.ConverConfig;
import org.zyq.conver.ConverUtils;
import org.zyq.conver_web.config.Config;
import org.zyq.core.lang.FUtils;
import org.zyq.core.lang.Str;

import javax.jws.WebService;
import java.io.File;

@WebService(endpointInterface = "org.zyq.conver_web.webservice.conver.IConver", targetNamespace = "http://webservice.conver.com")
public class IConverImpl implements IConver {

    static {
//        ConverUtils.setConfig(new ConverConfig("d:/temps").setPath_printer2swf("C:\\Program Files (x86)\\Print2Flash4"));
        ConverUtils.setConfig(new ConverConfig("d:/temps").setPath_printer2swf("D:\\Print2Flash3"));
    }


    public void toPdf(final String file_name, final String base64file, final String mdd) {
        Config.fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("接收调用");
                    File source = FUtils.format_file_name(FUtils.writeFileByBase64(base64file, file_name), true);
                    File tagetDir = FUtils.getTempDir();
                    ConverUtils.office_2013_toPDF(tagetDir, source);
                    File file = new File(tagetDir, Str.getPrefix(source) + ".pdf");
                    if (file.exists()) {
                        file.renameTo(new File(mdd, Str.getPrefix(file_name) + ".pdf"));
                    } else {
                        System.out.println("转换失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void toSwf(final String file_name, final String base64file, final String mdd) {
        Config.fixedThreadPool.execute(new Runnable() {
            public void run() {
                System.out.println("接收调用");
                File source = FUtils.format_file_name(FUtils.writeFileByBase64(base64file, file_name), true);
                File tagetDir = FUtils.getTempDir();
                ConverUtils.cmd_print2swf(tagetDir, source);
                File file = new File(tagetDir, Str.getPrefix(source) + ".swf");
                if (file.exists()) {
                    file.renameTo(new File(mdd, Str.getPrefix(file_name) + ".swf"));
                } else {
                    System.out.println("转换失败");
                }
            }
        });
    }
}
