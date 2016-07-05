package org.lby.kq.common

import com.jfinal.kit.PropKit
import com.jfinal.plugin.activerecord.generator.Generator
import com.jfinal.plugin.druid.DruidPlugin

import javax.sql.DataSource

class ModelFactory {
    public static DataSource getDataSource() {
        PropKit.use("db.properties");
        DruidPlugin plugin = Config.getKaoQingPlugin();
        plugin.start();
        return plugin.getDataSource();
    }
    public static DataSource getBaseSource() {
        PropKit.use("db.properties");
        DruidPlugin plugin = Config.getBasePlugin();
        plugin.start();
        return plugin.getDataSource();
    }
    /*public static void main(String[] args) {
        String path = new ModelFactory().rootPath() + "src/org/lby";
        DataSource dataSource = getDataSource();
        Generator gernerator = new Generator(dataSource, "org.lby.kq.model.base", "D:\\JAVA\\workspace\\mine\\sums\\kaoqing\\src\\main\\groovy\\org\\lby\\kq\\model\\base", "org.lby.kq.model", "D:\\JAVA\\workspace\\mine\\sums\\kaoqing\\src\\main\\groovy\\org\\lby\\kq\\model");
        // 设置是否在 Model 中生成 dao 对象
        gernerator.setGenerateDaoInModel(true);
        gernerator.setChoose_parts("^kq_.*\$");
        // gernerator.setChoose_parts("^gysfaj_(case|ask|sb)$");
        // 设置是否生成字典文件   gernerator.setGenerateDataDictionary(false);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为
        // "User"而非 OscUser
        gernerator.setRemovedTableNamePrefixes("kq_");
        // 生成
        gernerator.generate();
    }*/

    public static void main(String[] args) {
        String path = new ModelFactory().rootPath() + "src/org/lby";
        DataSource dataSource = getBaseSource();
        Generator gernerator = new Generator(dataSource, "org.lby.kq.model.common.base", "D:\\JAVA\\workspace\\mine\\sums\\kaoqing\\src\\main\\groovy\\org\\lby\\kq\\model\\common\\base", "org.lby.kq.model.common", "D:\\JAVA\\workspace\\mine\\sums\\kaoqing\\src\\main\\groovy\\org\\lby\\kq\\model\\common");
        // 设置是否在 Model 中生成 dao 对象
        gernerator.setGenerateDaoInModel(true);
        gernerator.setChoose_parts("^qxgl_.*\$");
        // gernerator.setChoose_parts("^gysfaj_(case|ask|sb)$");
        // 设置是否生成字典文件   gernerator.setGenerateDataDictionary(false);
        // 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为
        // "User"而非 OscUser
        gernerator.setRemovedTableNamePrefixes("qxgl_");
        // 生成
        gernerator.generate();
    }
    public String rootPath() {
        // 取得根目录路径
        String rootPath = this.getClass().getResource("/").getPath();
        if (rootPath != null && rootPath.length() > 1 && rootPath.contains("WebRoot/WEB-INF/classes/"))
            rootPath = rootPath.substring(1, rootPath.indexOf("WebRoot/WEB-INF/classes/"));
        return rootPath;
    }
}
