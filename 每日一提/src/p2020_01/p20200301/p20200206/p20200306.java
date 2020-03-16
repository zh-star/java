package p2020_01.p20200301.p20200206;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -03
 * Time: 18:25
 */
public class p20200306 {
    public static void main(String[] args){
//        int[] array = new int[] {2, 4,6,-1,3,6,7,9};
//        System.out.println(findSum(array));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxSum = 0;
        int cimAaxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += arr[i];
        }
        for (int i = 1; i < n; i++) {
            cimAaxSum += arr[i];
        }
        if(maxSum < cimAaxSum) {
            int temp = findSum(arr,0,arr.length-1);
            if(temp != 0) {

            }
        } else {
            System.out.println(maxSum);
        }

    }

    // 找负数的位置
    private static int findSum(int[] array, int left ,int right) {
        for (int i = left; i < right ; i++) {
            //System.out.println("for");
            int temp = array[i];

            if (temp < 0) {
                return i;
            }
        }
        return 0;
    }

}
