package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:40
 */
public class DBUtil4 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "update stu set chinese = ?,math = ?,english = ? while id = ?";
            statement = connection.prepareStatement(sql);
            //statement.setInt(1, 1);
            //statement.setString(2, "ABC");
            statement.setBigDecimal(2, new BigDecimal(12));
            statement.setBigDecimal(3, new BigDecimal(13));
            statement.setBigDecimal(4, new BigDecimal(15));

            System.out.println(sql);

            int num = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
