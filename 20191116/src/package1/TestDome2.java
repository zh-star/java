package package1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 17:08
 */
public class TestDome2 {
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("ksjj");
        str.reverse();
    }
    //leetcode 557. 反转字符串中的单词 III
    //示例 1:
    //输入: "Let's take LeetCode contest"
    //输出: "s'teL ekat edoCteeL tsetnoc"
    public static String reverseWords(String s) {
        String[] value = s.split(" ");
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < value.length; i++) {
            str.append(new StringBuffer(value[i]).reverse().toString() + " ");
        }
        return str.toString().trim();
    }
}
}
