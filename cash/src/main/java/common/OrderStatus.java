package common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -02
 * Time: 21:06
 */
public enum OrderStatus {
    PLAYING(1,"待支付"),OK(2,"支付完成");
    private int flg;
    private String desc;

    OrderStatus(int flg,String desc){
        this.flg = flg;
        this.desc = desc;
    }

    public int getFlg() {
        return flg;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "flg=" + flg +
                ", desc='" + desc + '\'' +
                '}';
    }

    //浏览订单的时，拿到的是一个数字； 根据这个数字获取对应的对象
    public static OrderStatus valueOf(int flg) {
        //OrderStatus.values() 将枚举类中的对象变为数组
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.flg == flg) {
                return orderStatus;
            }
        }
        throw new RuntimeException("OrderStatus is not fount");
    }
}
