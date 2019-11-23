package com.bit.util;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:40
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =
                    DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select id,name,chinese,math,english" + " from stu";
            resultSet = statement.executeQuery(sql);
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
