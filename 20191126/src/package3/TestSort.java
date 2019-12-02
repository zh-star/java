package package3;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 12:31
 */
public class TestSort {
    public static void main(String[] args){
        int[] array = {5,9,20,89,8,34};
        int[] array2 = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    //直接插入排序
    public static void insertSort(int[] array) {

    }

    //快排
    public static void quickSort(int[] array,int low,int high) {
        int par = partition(array,low,high);
        if(par > low + 1) {
            partition(array,low,par-1);
        }
        if(par < high + 1) {
            partition(array,par+1,high);
        }
    }
    public static int partition(int[] array,int low,int high) {
        int temp = array[low];
        while(low < high) {
            while(low < high && array[high] > temp) {
                high --;
            }
            array[low] = array[high];
            while(low < high && array[low] < temp) {
                low ++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }


    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length-1;
        int par = 0;
        stack.push(low);
        stack.push(high);
        while(!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            par = partition(array,low,high);
            if(par > low + 1) {
                stack.push(low);
                stack.push(par - 1);
            }
            if(par < high + 1) {
                stack.push(par+1);
                stack.push(high);
            }
        }
    }
    //归并排序
    public static void mergeSort(int[] array,int low,int high) {
        if(low == high) {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        merge(array,low,mid,high);
    }
    public static void merge(int[] array,int low,int mid,int high){
        int s1 = low;
        int s2 = mid+1;
        int len = high - low + 1;

        int[] tmp = new int[len];
        int i = 0;

        while(s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmp[i++] = array[s1++];
            } else {
                tmp[i++] = array[s2++];
            }
        }
        while(s1 <= mid) {
            tmp[i++] = array[s1++];
        }
        while(s2 <= high) {
            tmp[i++] = array[s2++];
        }

        for (int j = 0; j < tmp.length; j++) {
            array[low+j] = tmp[j];
        }
    }
}
