package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 16:40
 */
public class DBUtil5 {
    private static DataSource DATA_SOURCE;

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DBUtil5() {

    }

    public static DataSource getDataSource() {
        if(DATA_SOURCE == null) {
            DATA_SOURCE = new MysqlDataSource();
            ((MysqlDataSource)DATA_SOURCE).setURL(URL);
            ((MysqlDataSource)DATA_SOURCE).setUser(USERNAME);
            ((MysqlDataSource)DATA_SOURCE).setPassword(PASSWORD);

        }
        return DATA_SOURCE;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
