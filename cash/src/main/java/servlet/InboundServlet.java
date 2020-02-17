package servlet;

import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * Description: 商品上架
 * User: STAR
 * Date: 2020 -02
 * Time: 22:45
 */
@WebServlet("/inbound")
public class InboundServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 指定http响应的编码，就是http的响应头，是告诉浏览器此响应的编码格式

        resp.setContentType("test/html, character=UTF-8"); // 指定http响应的编码，同时指定浏览器显示时的编码，也就是响应数据的编码格式
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String introduce = req.getParameter("introduce");
        String stock =  req.getParameter("stock");
        String unit = req.getParameter("unit");
        String price =  req.getParameter("price");
        Double doublePrice = Double.valueOf(price);//12.5
        int realPrice = new Double(doublePrice*100).intValue(); // double类型转int
        String discount =  req.getParameter("discount");
        System.out.println(discount);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into goods(name,introduce,stock,unit,price,discount) values(?,?,?,?,?,?)";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,introduce);
            preparedStatement.setInt(3,Integer.valueOf(stock));
            preparedStatement.setString(4,unit);
            preparedStatement.setInt(5,realPrice);
            preparedStatement.setInt(6,Integer.valueOf(discount));


            int ret = preparedStatement.executeUpdate();//执行sql语句，返回0/1

            if(ret == 1) {
               // resp.sendRedirect("<h1>" + "上架完成" + "</h1>"); // 插入数据库之后，重定向到这个页面
                resp.sendRedirect("/index.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }
}
