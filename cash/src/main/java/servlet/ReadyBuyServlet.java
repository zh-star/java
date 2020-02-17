package servlet;

import common.OrderStatus;
import entity.Account;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 20:36
 */
@WebServlet("/pay")
public class ReadyBuyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String goodsIdAndNumber = req.getParameter("goodsIdAndNum");
        //12-2,15-3
        String[] strings =  goodsIdAndNumber.split(",");
        // 12-2  15-3
        List<Goods> goodsList = new ArrayList<>();
        for (String s : strings) {
            String[] strings1 = s.split("-");
            //12:id 2:需要购买商品的数量
            // 得到goodsId之后，先进行查找此货区是否存在
            Goods goods = this.getGoods(Integer.valueOf(strings1[0]));
            if(goods != null) {
                //说明存在此货物，因为买的不是一个，所以每次查到将其放入list
                goodsList.add(goods);
                goods.setBuyGoodsNum(Integer.valueOf(strings1[1]));
            }

        }
        //System.out.println("当前需要购买的商品：" + goodsList );

        //货物数据准备好了，进行  生成订单
        HttpSession session = req.getSession();
        Account account =(Account)session.getAttribute("user");
        // 开始设置订单
        Order order = new Order();
        order.setId(String.valueOf(System.currentTimeMillis()));// 根据当前时间生成点歌单id
        order.setAccount_id(account.getId());//用户id
        order.setAccount_name(account.getUsername());//用户姓名

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        order.setCreate_time(LocalDateTime.now().format(formatter)); // 设置订单生成时间

        // 设置订单中的货物，并放在list中
        int totalMoney = 0;
        int actualMoney = 0;
        for (Goods goods : goodsList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setGoodsId(goods.getId());
            orderItem.setGoodsName(goods.getName());
            orderItem.setGoodsIntroduce(goods.getIntroduce());
            orderItem.setGoodsNum(goods.getBuyGoodsNum());
            orderItem.setGoodsUnit(goods.getUnit());
            orderItem.setGoodsPrice(goods.getPriceInt());
            orderItem.setGoodsDiscount(goods.getDiscount());

            order.orderItemsList.add(orderItem);

            int currentMoney = goods.getBuyGoodsNum()*goods.getPriceInt();
            totalMoney += currentMoney;
            actualMoney += currentMoney * goods.getDiscount() / 100;
        }

        order.setTotal_money(totalMoney);
        order.setActual_amount(actualMoney);
        order.setOrder_status(OrderStatus.PLAYING);
        resp.getWriter().println("<html>");
        resp.getWriter().println("<p>" + "【用户名称】" + order.getAccount_name() + "</p>");
        resp.getWriter().println("<p>" + "【订单编号】" + order.getId());
        resp.getWriter().println("<p>" + "【订单状态】" + order.getOrder_status().getDesc() + "</p>");
        resp.getWriter().println("<p>" + "【创建时间】" + order.getCreate_time() + "</p>");
        resp.getWriter().println("<p>" + "编号 " + "名称 " + "数量 " + "单位 " + "单价(元)  " + "</p>" );
        resp.getWriter().println("<o1>");
        for (OrderItem orderItem : order.orderItemsList) {
//            System.out.println("id");
            resp.getWriter().println("<li>" + orderItem.getGoodsName() + " " + orderItem.getGoodsNum() + " " + orderItem.getGoodsUnit() + " " + orderItem.getGoodsPrice() + "</li>");
//            System.out.println("id2");
        }
        resp.getWriter().println("</o1>");
        resp.getWriter().println("<p>" + "【总金额】： " + order.getTotal_money() + "</p>" );
        resp.getWriter().println("<p>" + "【优惠金额】： " + order.getDiscount() + "</p>");
        resp.getWriter().println("<p>" + "【应支付金额】： " + order.getActual_amount() + "</p>");
        resp.getWriter().println("<a href=\"buyGoodServlet\">确认</a>");
        resp.getWriter().println("<a href=\"index.html\">取消</a>");
        resp.getWriter().println("</html>");
        session.setAttribute("order",order);
        session.setAttribute("goodsList", goodsList);
    }

    // 根据goodId查询当前goods是否存在 若存在，返回此物品
    private Goods getGoods(int goodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Goods goods = null;
        try {
            String sql = "select *from goods where id=?";
            connection = DBUtil.getConnection(true);
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1,goodId);

            resultSet = preparedStatement.executeQuery();


            if(resultSet.next()) {
                goods = this.extractGoods(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return goods;
    }

    //解析resultSet当中的商品信息，组装从一个商品的对象goods
    public Goods extractGoods(ResultSet resultSet) throws SQLException {
        Goods goods = new Goods();
        goods.setId(resultSet.getInt("id"));
        goods.setName(resultSet.getString("name"));
        goods.setIntroduce(resultSet.getString("introduce"));
        goods.setStock(resultSet.getInt("stock"));
        goods.setUnit(resultSet.getString("unit"));
        goods.setPrice(resultSet.getInt("price"));
        goods.setDiscount(resultSet.getInt("discount"));
        return goods;
    }
}
