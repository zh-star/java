package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Account;
import entity.Order;
import entity.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 9:26
 */
@WebServlet("")
public class BrowseOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Account account =(Account)session.getAttribute("user");
        // 1根据当前用户的ID，进行订单的查找，携程一个函数
        List<Order> orderList = QueryOorder(account.getId());
        //2. 查询结果可能是多个个订单list<Order>
        //3.判断查询的结果，如果是空，说明没有订单
        if(orderList == null) {
            System.out.println("没有订单");
        }
        //如果不是空，那么list将转为json,发给前端
        ObjectMapper mapper = new ObjectMapper();
        //将响应包推送给浏览器
        PrintWriter pw = resp.getWriter();
        //将list转换为字符串，并将json字符串填充到PrintWriter当中
        mapper.writeValue(pw,orderList);
        Writer writer = resp.getWriter();
        //把流响应给前端页面
        writer.write(pw.toString());


    }
//    private Order extractOrder(Order order, ResultSet resultSet) {
//        order.setId(resultset getstring( columnLabel: "order id"));
//        order.setAccount_id();resultset getInt( columnLabel:"account id")):
//        order. setAccount name(resultset getstring( columnLabel: "account name"))
//        order. setCreate time(String valueof(resultset getTimestamp( columnLabel: "create time"). toLocall
//        Timestamp finishTime- resultSet getTimestamp( columnLabel: "finish time")
//        order. setActual amount(resultset getInt( columnLabel: "actual amount")
//        order. setTotal money (resultSet getInt( columnLabel:"total money"))
//        order setorder status(orderstatus. valueof(resultSet getInt( columnLabel: "order status"))
//    }

//    private OrderItem extractOrderItem(ResultSet resultSet) {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setOrderId(resultSet());
//        orderItem.setGoodsId(goods.getId());
//        orderItem.setGoodsName(goods.getName());
//        orderItem.setGoodsIntroduce(goods.getIntroduce());
//        orderItem.setGoodsNum(goods.getBuyGoodsNum());
//        orderItem.setGoodsUnit(goods.getUnit());
//        orderItem.setGoodsPrice(goods.getPriceInt());
//        orderItem.setGoodsDiscount(goods.getDiscount());
//    }

    /**
     * 生成一条sql语句
     * @param id
     * @return
     */
    private List<Order> QueryOorder(Integer id) {
        List<Order> orderList = new ArrayList<>();

        return orderList;
    }
}
