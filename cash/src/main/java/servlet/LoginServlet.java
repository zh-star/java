package servlet;

import entity.Account;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 21:10
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("test/html, character=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username" + username);
        System.out.println("password" + password);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select id,username,password from account where username=? and password=?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            resultSet = preparedStatement.executeQuery();//在数据库中查询

            // 在这里需要保存当前用户，所以实例一个用户对象
            Account account = new Account();

            if(resultSet.next()) {
                //找到了
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
            }
           Writer writer = resp.getWriter();
            if(account.getId() == null) {
                //System.out.println("用户名或密码错误");
                writer.write("<h2>用户名或密码错误" + username+ "</h2>");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user",account);
                resp.sendRedirect("index.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
}
