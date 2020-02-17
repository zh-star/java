package entity;

import com.sun.org.apache.xpath.internal.operations.Or;
import common.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 20:34
 */
public class Order {
    private String id;//订单id
    private Integer account_id;//用户id
    private String account_name;//用户名
    private String create_time;//创建时间
    private String finish_time;//完成时间
    private String actual_amount;//
    private Integer total_money;//总金额

    private OrderStatus order_status; // 状态陈述，

    //订单项（此订单中购买的商品）的内容也需要存储到当前订单内

    public List<OrderItem> orderItemsList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(String actual_amount) {
        this.actual_amount = actual_amount;
    }

    public Integer getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Integer total_money) {
        this.total_money = total_money;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }
}
