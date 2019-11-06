import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 15:53
 */
public class TestDemo2 {


    //String 变为StringBuffer
    //利用StringBuffer的构造函数，或者append()方法
    public static void main(String[] args){
        String str = "abcdef";
        StringBuffer buf = new StringBuffer(str);
        System.out.println(buf);
        buf.append(str);
        System.out.println(buf);

        StringBuffer buf1 = new StringBuffer();
        buf1.append("hello world");
        String str1 = new String(buf1);
        System.out.println(str);
    }
    public static void main1(String[] args){
        //字符串的创建
        String str11 = "abcdef";
//        String str2 = new String("abcdef");
//        char[] array = {'a','b','c','d'};
//        int len = array.length;
//        String str3 = new String(array);
//        String str4 = new String();
//        System.out.println(str4);
//        System.out.println(str3);
//        int len = str1.length();

//        String str6 = "ab";
//        System.out.println(Integer.toHexString(str6.hashCode()));
//        String str7 = "cdef";
//        System.out.println(Integer.toHexString(str7.hashCode()));
//        String str8 = str6+str7;
//        System.out.println(Integer.toHexString(str8.hashCode()));
//        System.out.println(str11 == str8);// false
//        System.out.println(str11.equals(str8));
//
//        String str1 = "abcdef";
//        String str2 = "abfdef";
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equalsIgnoreCase(str2));
        /**
         * 如果对应位置相同一直往后走
         * 找到不一样的字符 进行比较
         * str1和str2
         * str1 > str2  >0
         * str1 < str2  <0
         * str1 == str2 =0
         */
 //       System.out.println(str1.compareTo(str2));
//        System.out.println(Integer.toHexString(str11.hashCode()));
//
//        String string = str11.replace('f','a');
//        System.out.println(Integer.toHexString(string.hashCode()));
//
//        System.out.println(string);

        String str = "helloworld" ;
        System.out.println(str.substring(5));
        System.out.println(str.substring(0, 5));


    }
}
