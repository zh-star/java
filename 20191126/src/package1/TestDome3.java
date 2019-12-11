package package1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 15:32
 */
public class TestDome3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        //System.out.println(str1);
        String str2 = sc.nextLine();
        //System.out.println(str2);
        int ret = count(str1,str2);
        System.out.println(ret);
    }
    public static int count(String str1, String str2){
        StringBuffer s = new StringBuffer(str1);
        int count = 0;
        int length = str2.length();
        for(int i = 0; i <= s.length(); i ++) {
            //public StringBuffer insert(int offset,String str)
            // offset(最小值为1) 为str1位置的偏移量 str 为要插入的字符串
            s.insert(0,str2);
            //System.out.println(s);
//            int left = 0;
//            int right = s.length()-1;
//            while(left < right && s.charAt(left) == s.charAt(right)) {
//                left ++;
//                right --;
//            }
//            if(left >= right) {
//                // 是回文
//                count ++;
//

            String s1 = s.toString();
            if (s1.equals(s.reverse().toString())) {
                count++;
            }
            s.reverse();
            s.delete(i, i+length);
        }
        return count;
    }
    public static void main1(String[] args){
        //0,4,7,22,55,77
        //{5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        int[] array = {1,3,5,2,2};
        System.out.println(findKth(array, 5, 3));
        System.out.println(Arrays.toString(array));
    }
    public static int findKth(int[] a, int n, int K) {
        // write code here
        int par = partition(a,0,n-1);
        int low = 0;
        int high = n-1;
        if(par > low +1) {
            par = partition(a,low,par-1);
        }
        if(par < high-1) {
            par = partition(a,par+1,high);
        }
        return a[K-1];
    }
    // 排一次，求得一个有序的值位置
    public static int partition(int[] a, int low, int high) {
        int temp = a[low];
        while(low < high) {
            while(low < high && a[high] < temp) {
                high--;
            }
            a[low] = a[high];
            while(low < high && a[low] > temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }
}
