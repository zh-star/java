package p20191213;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 19:26
 */
public class TestDemo1 {
    // 读入一个字符串 ，求得字符串中 连续数字最长的数字串
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String  str = sc.next();
        StringBuffer temp = new StringBuffer();
        StringBuffer ret = new StringBuffer();
        int i = 0;
        while(i < str.length()) {
            while(i < str.length() && str.charAt(i) <= '9') {
                temp.append(str.charAt(i));
                i++;
            }
            if(ret.length() < temp.length()) {
                ret.delete(0,ret.length());
                for (int j = 0; j < temp.length(); j++) {
                    ret.append(temp.charAt(j));
                }
            }
            temp.delete(0,temp.length());
            i++;
        }
        System.out.println(ret);
    }
}
