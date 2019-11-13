package package1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 9:09
 */
public class TestDemo1 {
    public static void main(String[] args){
       // System.out.println(searchNotRepeateChar("welcome to bit","come"));
        System.out.println(generate(5));
    }

    public static List<Character> searchNotRepeateChar(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        //String[] value2 = str2.split("");
        for (int i = 0; i < str1.length(); i++) {
            //contains（） 返回置为boolean 检查 左字符串中 是否包含 右字符串
           if(!str2.contains("" + str1.charAt(i)) ) {
              // charAt（）根据下表获取字符串的的某个字符
                list.add(str1.charAt(i));
           }
        }
        return list;
    }

    public static List<List<Integer>> generate( int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> listPrev = triangle.get(i - 1);
            curRow.add(1);
            for (int j = 1; j < i; j++) {
                curRow.add(listPrev.get(j - 1) + listPrev.get(j));
            }
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }
}
