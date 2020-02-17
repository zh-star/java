package p2019_12.p20191215;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 每日一题 12-13
 * User: STAR
 * Date: 2019 -12
 * Time: 16:57
 */
class myStack {
    int[] val;
    int top;

    public myStack(int[] val,int top) {
        this.val = val;
        this.top = top;
    }
}
public class TestDemo2 {
    private static myStack mystack = null;
    public void push(int date) {
        mystack.val[mystack.top] = date;
        mystack.top++;
    }
    public int pop() {
        return mystack.val[mystack.top];
    }
}
public class TestDemo2 {


    //1. 读入一个字符串str，输出字符串str中的连续最长的数字串
    //输入
    //abcd12345ed125ss123456789
    //输出
    //123456789

    // 读入一个字符串 ，求得字符串中 连续数字最长的数字串
    // 创建两个StringBuffer类型字符串， temp  ret
    //1.遍历原字符串，若出现数组，开始循环将其放入 temp
    //2. 判断 如果 ret 字符串的长度 >  temp 字符串的长度，将temp 复制给 ret 记住 不是直接拷地址
    //3. 打印ret
    // 自己写的
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
    // 答案 给的
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int max = 0,count=0,end=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    if(max<count){
                        max= count;
                        end = i;
                    }
                }else{
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
    }

    //2.对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
    //
    //给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串
    //测试样例：
    //"(()())",6
    //返回：true
    //测试样例：
    //        "()a()()",7
    //返回：false
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> lefts = new Stack<Character>();
        if(A == null || A.length() != n){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(A.charAt(i) == '('){
                lefts.push(A.charAt(i));
            }else if(A.charAt(i) == ')'){
                if(lefts.empty()){
                    return false;
                }else{
                    lefts.pop();
                }
            }else{
                return false;
            }
        }
        if(!lefts.empty()){
            return false;
        }else{
            return true;
        }
    }
}
