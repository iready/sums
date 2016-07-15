package org.lby.kq.service

import com.jfinal.core.Controller
import com.jfinal.plugin.activerecord.Db
import com.jfinal.plugin.activerecord.ICallback
import com.jfinal.plugin.activerecord.Record
import org.apache.log4j.Logger
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.joda.time.DateTime
import org.lby.kq.common.RecordBuilder
import org.zyq.core.lang.FUtils
import org.zyq.core.lang.NumberUtils
import org.zyq.core.lang.Str
import tools.excel.POIUtils

import java.sql.CallableStatement
import java.sql.Connection
import java.sql.SQLException

/**
 * Created by 邹宇泉 on 2016/7/8.
 */
class ServiceOfSta {
    private static Logger logger = Logger.getLogger(ServiceOfSta.class);

    static void for_sure_tj(Integer year, Integer month, String unit, Integer type, String days, Controller controller) {
        try {
            if (type == 0) {
                controller.renderJson('result', call_fy(year, month, days, unit));
            } else if (type == 1) {
                controller.renderJson('result', call_dept(year, month, days, unit as int));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static synchronized List<Record> call_dept(Integer year, Integer month, String days, int deptId) {
        return (List<Record>) Db.execute(new ICallback() {
            Object call(Connection connection) throws SQLException {
                CallableStatement callableStatement = null;
                try {
                    callableStatement = connection.prepareCall('{call tj_dept(?,?,?,?)}');
                    callableStatement.setInt(1, year);
                    callableStatement.setInt(2, month);
                    callableStatement.setString(3, days);
                    callableStatement.setInt(4, deptId);
                    return RecordBuilder.build(callableStatement.executeQuery());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e, e);
                    return new ArrayList<Record>();
                }
            }
        });
    }

    static synchronized List<Record> call_fy(Integer year, Integer month, String days, String fy) {
        return (List<Record>) Db.execute(new ICallback() {
            Object call(Connection connection) throws SQLException {
                CallableStatement callableStatement = null;
                try {
                    callableStatement = connection.prepareCall('{call tj_fy(?,?,?,?)}');
                    callableStatement.setInt(1, year);
                    callableStatement.setInt(2, month);
                    callableStatement.setString(3, days);
                    callableStatement.setString(4, fy);
                    return RecordBuilder.build(callableStatement.executeQuery());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e, e);
                    return new ArrayList<Record>();
                }
            }
        });
    }

    static void for_execl_dc(Integer year, Integer month, String unit, Integer type, String days, Controller controller) {
        try {
            Workbook workbook = POIUtils.getMB(new File(controller.getRequest().getServletContext().getRealPath("/mb/导出模板.xls")));
            Sheet sheet = workbook.getSheetAt(0);
            List<Record> records = null;
            if (type == 0) {
                records = call_fy(year, month, days, unit);
            } else if (type == 1) {
                records = call_dept(year, month, days, unit as int);
            }
            if (records != null) {
                println records
                for (int i = 0; i < records.size(); i++) {
                    Row row = sheet.createRow(i + 1);
                    Record record = records.get(i);
                    POIUtils.batchSetView(row, 0, record.getStr("dept_name"), record.getStr("XM"), NumberUtils.toInt(record.get('cd1')) + NumberUtils.toInt(record.get("cd3")),
                            NumberUtils.toInt(record.get('zt2')) + NumberUtils.toInt(record.get('zt4')), record.get('kg'), record.get('wc') == null ? '0' : record.get('wc'), record.get('qj') == null ? '0' : record.get('qj'), record.get('cc') == null ? '0' : record.get('cc')
                    );
                }
                File dest = new File(FUtils.getTempDir(), new DateTime().toString('yyyy-MM-dd') + '考勤记录导出.xls');
                POIUtils.saveFile(workbook, dest);
                controller.renderFile(dest);
            }
        } catch (Exception e) {
            controller.renderNull();
            e.printStackTrace();
        }
    }
}
