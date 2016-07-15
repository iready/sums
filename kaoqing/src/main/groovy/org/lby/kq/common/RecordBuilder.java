package org.lby.kq.common;

import com.jfinal.plugin.activerecord.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 邹宇泉 on 2016/7/13.
 */
public class RecordBuilder {
    public static final List<Record> build(ResultSet rs) throws SQLException {
        ArrayList result = new ArrayList();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] labelNames = new String[columnCount + 1];
        int[] types = new int[columnCount + 1];
        buildLabelNamesAndTypes(rsmd, labelNames, types);

        while (rs.next()) {
            Record record = new Record();
//            record.setColumnsMap(config.containerFactory.getColumnsMap());
            Map columns = record.getColumns();

            for (int i = 1; i <= columnCount; ++i) {
                Object value;
                if (types[i] < 2004) {
                    value = rs.getObject(i);
                } else if (types[i] == 2005) {
                    value = ModelBuilder.handleClob(rs.getClob(i));
                } else if (types[i] == 2011) {
                    value = ModelBuilder.handleClob(rs.getNClob(i));
                } else if (types[i] == 2004) {
                    value = ModelBuilder.handleBlob(rs.getBlob(i));
                } else {
                    value = rs.getObject(i);
                }

                columns.put(labelNames[i], value);
            }

            result.add(record);
        }

        return result;
    }

    private static final void buildLabelNamesAndTypes(ResultSetMetaData rsmd, String[] labelNames, int[] types) throws SQLException {
        for (int i = 1; i < labelNames.length; ++i) {
            labelNames[i] = rsmd.getColumnLabel(i);
            types[i] = rsmd.getColumnType(i);
        }

    }
}
