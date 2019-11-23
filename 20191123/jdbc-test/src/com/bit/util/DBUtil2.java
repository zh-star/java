package com.bit.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:40
 */
public class DBUtil2 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args)  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setURL(URL);
            ((MysqlDataSource) ds).setUser(USERNAME);
            ((MysqlDataSource) ds).setPassword(PASSWORD);
            connection = ds.getConnection();
            System.out.println(connection);

            String sql = "select id,name,chinese,math,english" +
                    " from stu where name= ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, "孙悟空");
            System.out.println(sql);

            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id = %s,name = %s,chinese = %s,math = %s,english = %s",
                        id,name,chinese,math,english);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(resultSet != null) {
                    resultSet.close();
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
