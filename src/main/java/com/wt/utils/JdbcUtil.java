package com.wt.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * 获取dbutils工具类对象QueryRunner
 */
public class JdbcUtil {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    private static QueryRunner qr = new QueryRunner(ds);

    // 获取QueryRunner对象
    public static QueryRunner getQueryRunner() {
        return qr;
    }
}
