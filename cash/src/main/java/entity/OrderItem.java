package entity;

import common.OrderStatus;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 20:34
 */
public class OrderItem {
    private Integer id;
    private String orderId;//用户id
    private Integer goodsId;
    private String goodsName;//用户名
    private String goodsIntroduce;
    private Integer goodsNum;
    private String goodsUnit;//单位
    private Integer goodsPrice;//存入数据库为整数
    private Integer goodsDiscount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }
    //单位：元
    public double getGoodsPrice() {
        return goodsPrice*1.0/100;
    }
    //单位：分
    public int getGoodsPriceInt() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsDiscount() {
        return goodsDiscount;
    }

    public void setGoodsDiscount(Integer goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }
}
