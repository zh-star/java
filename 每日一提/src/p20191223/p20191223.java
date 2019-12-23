package p20191223;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 14:17
 */
public class p20191223 {

    //1. 五缓存交换  函数内不能有局部变量的交换
    //  private int temp = 0;
    public int[] exchangeAB(int[] AB) {
        // write code here
        //    temp = AB[0];
        //    AB[0] = AB[1];
        //   AB[1] = temp;


        //  AB[0] = AB[0] + AB[1];
        //  AB[1] = AB[0] - AB[1];
        //  AB[0] = AB[0] - AB[1];

        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }

    // 2. 生成格雷码
    public static void main(String[] args){
        String[] ret = getGray(3);
        System.out.println(Arrays.toString(ret));
    }
    public static String[] getGray(int n) {
        // write code here
        // 格林码数 是指 一个整数 n（例 ：2） 的二进制编码 （例：00 01 10 11） 排放顺序是
        // 按照 两个相邻的编码 之间 只有一位 不同（例： 00 01 11 10）


        // 代码实现 就是 递归法
        // 1. 若需要 n 的格雷码 就需要 先求 n-1 的格林码
        // 2. 将 每次得到的n-1的格林码，放入新的字符串数组并在每一位的最左边添上“0”，
        // 3. 再 将其 倒放在 这个新数组的后面 并在最左边添上1 就是 n 的格雷码
        //例如： 求2 的格雷码   先求 1 的格雷码 是 ["0","1"]
        // 将其放入进的数组,并在最左边加0   ["00","01"]
        // 再将其倒放连接在新数组后并最左边添加1    ["00","01","11","10"]

        if(n == 1) {
            String[] result = new String[2]; // 1的格雷码 固定长度 2
            result[0] = "0";
            result[1] = "1";
            return result;
        }
        String[] temp = getGray(n-1);
        String[] result = new String[2*temp.length]; // n每增大1 格雷码的个数增大2倍
        for(int i = 0; i < temp.length; i++) {
            result[i] ="0" + temp[i];
        }
        for(int i = 0; i < temp.length; i++) {
            result[i + temp.length] = "1" + temp[temp.length-1-i];
        }
        return result;
    }
}
