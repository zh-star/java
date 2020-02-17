package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description: // 通过jdbc来连接数据库
 * User: STAR
 * Date: 2020 -02
 * Time: 10:31
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/cash"; // database中配置的url

    private static final String USERNAME = "root"; // 数据库的用户名

    private static final String PASSWORD = "root"; // 数据库的密码

    private static volatile DataSource DATASOURCE;

    /**
     * 单例模式，DataSource的获取方法
     * @return
     */
    private static DataSource getDATASOURCE() {
        if(DATASOURCE == null) {
            synchronized (DBUtil.class) {
                if(DATASOURCE == null) {
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource)DATASOURCE).setURL(URL);
                    ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
                    ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATASOURCE;
    }

    // 获取连接池
    //项目当中会出现事物的回滚，
    public static Connection getConnection(boolean autoCommit) {
        try{
            Connection connection = getDATASOURCE().getConnection();
            connection.setAutoCommit(autoCommit);//设置事物是否要进行
            return connection;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取连接失败");
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement,
                             ResultSet resultSet) {
        try {
            //先开的后关
            if(resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
