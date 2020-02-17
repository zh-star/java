package servlet;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 10:31
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 指定http响应的编码，就是http的响应头，是告诉浏览器此响应的编码格式

        resp.setContentType("test/html, character=UTF-8"); // 指定http响应的编码，同时指定浏览器显示时的编码，也就是响应数据的编码格式
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "insert into account(username,password) values(?,?)";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            System.out.println("username" + username);
            System.out.println("password" + password);

            preparedStatement.executeUpdate();//执行sql语句，返回0/1

            resp.sendRedirect("login.html"); // 插入数据库之后，重定向到这个页面
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }
}
