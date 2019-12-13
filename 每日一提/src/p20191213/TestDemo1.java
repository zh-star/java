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
    // 创建两个StringBuffer类型字符串， temp  ret
    //1.遍历原字符串，若出现数组，开始循环将其放入 temp
    //2. 判断 如果 ret 字符串的长度 >  temp 字符串的长度，将temp 复制给 ret 记住 不是直接拷地址
    //3. 打印ret
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
