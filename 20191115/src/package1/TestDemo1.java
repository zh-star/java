package package1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 18:49
 */
public class TestDemo1 {

    //415. 字符串相加
    //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和
    public static void main(String[] args){
        String num1 = "6187";
        String num2 = "123";//246
        System.out.println(addStrings(num1,num2));
    }

    public static String addStrings(String num1, String num2) {
        //1.可以用 num1.charAt(int index)来取index位置的字符
        StringBuilder sum = new StringBuilder();
        //2.将最短的字符数组 从后向前，取出每个字符，将其 -48 进行计算
        //System.out.println(num1.charAt(0));
        //int steps = num1.length() < num2.length() ? num1.length() : num2.length();
        //System.out.println(steps);
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0;
            //System.out.println(value1[i] + value2[i] - 96);
            int sum1 = carry + a + b;
            System.out.println(sum1);
            sum.append(sum1 % 10);
            carry = sum1 / 10;
        }
        if(carry > 0) {
            sum.append(1);
        }
        return sum.reverse().toString();
        //3.定义一个变量记录进位；

    }



    // leetcode : 只交换字符串的元音字母
    public static void main1(String[] args){
        String ret = (String) reverseVowels("hello");
        System.out.println(ret);
    }

    public static String reverseVowels(String s) {
        String str = "aoeiuAOEIU";
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));
        int left = 0;
        int right = ch.length - 1;
        while(left < right) {
            while(str.indexOf(ch[left]) == -1 && left < right) {
                left ++;
            }
            while(str.indexOf(ch[left]) == -1  && left < right) {
                right --;
            }
            //System.out.println(left);
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left ++;
            right --;
            System.out.println(Arrays.toString(ch));
        }

        return String.copyValueOf(ch);
    }

    public static int  find1(char ch) {
        char[] value = {'a','o','e','i','u','A','O','E','U'};
        for(int i = 0; i < value.length; i++) {
            if(ch == value[i]) {
                return 1;
            }
        }
        return 0;
    }
}
