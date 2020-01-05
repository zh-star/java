package p20191231;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 19:22
 */
public class p20191231 {

    // 1. 富翁
    public static void main(String[] args) {

        int richManSum = 10;
        double strangerSum = 0.0;
        double temp = 0.01;
        for (int i = 1; i <= 30; i++) {
            strangerSum += temp;
            temp = temp * 2;
        }
        System.out.println(richManSum * 30 + " " + String.format("%.0f", strangerSum * 100));



        // 自行练习  float double 小时点后保留几位
        float f = 13.14f;
        double d = 13.14;
        System.out.println(String.format("%.5f", f));
        System.out.println(String.format("%.2f", d));
        System.out.println(String.format("%.5f", d));


        // 小数点左移  右移
        System.out.println(f / 100);
        System.out.println(f * (100));
    }
}
