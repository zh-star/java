import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 15:07
 */
public class TestDemo4 {
    public static void main(String[] args){
        System.out.println(remove23("welcome to bit","come"));
    }
    public static void main1(String[] args){
        List<List<Integer>> lists = generate(5);
//        for (List<Integer> list : lists ){
//            System.out.println(list);
//        }
        System.out.println(lists);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0) {
            return lists;
        }
        lists.add(new ArrayList<>());
        lists.get(0).add(1);
        //System.out.println(lists);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> listprev = lists.get(i - 1);
            //System.out.println(listprev);
            list.add(1);
            //System.out.println(list);
            for (int j = 1; j < i; j++) {
                list.add(listprev.get(j-1) + listprev.get(j));
            }
            //System.out.println(list);
            list.add(1);
            lists.add(list);
        }


        return lists;
    }


    public static StringBuffer remove23(String str1, String str2) {
        char[] value1 = str1.toCharArray();
        char[] value2 = str2.toCharArray();
        StringBuffer ret = new StringBuffer();
        //System.out.println(Arrays.toString(value2));
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < value1.length; i++) {

            for (int j = 0; j < value2.length; j++) {
                arrayList.add(value1[i]);
                if(arrayList.get(i) != (value2[j])) {
                    ret.append(arrayList.get(i));

                }
            }

        }
        return ret;
    }
}
