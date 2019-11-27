package package1;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:19
 */
public class TestSort {
    public static void main(String[] args){
        //int[] array = {6,8,2,7,10};
        int[] array = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
       // insertSort(array);
        //partion(array,0,4);
        //shellSort(array);
        quickSort2(array);
        System.out.println(Arrays.toString(array));
//        selectSort(array);
//        heapSort(array);
//        System.out.println(Arrays.toString(array));
    }
    //直接插入排序 ：从数组中第二个元素开始与前面的分别进行比较，前面的大，交换，反之不交换
    //时间复杂度：O(n*2) 空间复杂度: O(1)  稳定
    public static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i ++) {
            int j = i-1;
            int temp = array[i];
            for (; j >= 0 ; j--) {
                if(array[j] > temp) {
                    array[j + 1] = array[j];
                } else {

                    break;
                }
            }
            array[j + 1] = temp;

        }
    }

    //希尔排序 ： 将无序数组分为按照每次素数大小进行分组，再进行直接插入排序，
    // 但最后一定要看成一组，进行直接插入排序
    //时间复杂度: O(n^2) 空间复杂度：O(1) 不稳定
    public static void shell(int[] array,int gap) {

        for(int i = gap; i < array.length; i ++) {
            int j = i-gap;
            int temp = array[i];
            for (; j >= 0 ; j-= gap) {
                if(temp < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = temp;
        }

    }
    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }



    //选择排序 :第一个与后面的进行比较，第二个与后面的进行比较
    //时间复杂度 ：O(n*2) 空间复杂度 ：O(1)   不稳定
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //堆排序 （小 -》大）：建的是大根堆  让数组的第一个元素与最后一个元素进行交换
    // 就是将最大元素放在了最后位置，视为有序，再去向下调整除最后元素的其它元素
    //   时间复杂度O(n*log(n))   空间复杂度;O(1)      不稳定
    public static void heapSort(int[] array) {
        //先将堆调整为大根堆
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
        //之后再将最后一个元素与根节点元素进行交换，再进行调整除最后一个元素的所有元素
        //因为对顶一定是最大的元素，
        int end = array.length-1;
        while(end > 0) {
            //交换
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            adjustDown(array,0,end);
            end--;

        }
    }
    public static void adjustDown(int[] array,int root,int len) {
        int parent = root;
        int child = 2*parent + 1;
        while(child < len) {
            if((child + 1) < len) {
                child = (array[child] > array[child+1]) ? child : child+1;
            }
            if(array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                parent = child;
                child = 2*parent + 1;
            } else {
                break;
            }
        }
    }


    //快速排序 O(N*log(N)) 空间复杂度：O(log(n))  不稳定
    public static int partition(int[] array,int low,int high) {

        int temp = array[low];
        while(low < high) {
            //从后面找比基准值小的值
            while (low < high && array[high] >= temp) {
                high--;
            }
            if(low >= high) {
                array[low] = temp;
                break;
            } else {
                array[low] = array[high];
            }
            //从后面找比基准值大的值
            while (low < high && array[low] < temp) {
                low++;
            }
            if(low >= high) {
                array[low] = temp;
                break;
            } else {
                array[high] = array[low];
            }

        }
        return low;
    }
    public static void quickSort(int[] array,int low,int high) {
        int par = partition(array,low,high);
        if(par > low + 1) {
            quickSort(array,low,par-1);
        }
        if(par < high - 1) {
            quickSort(array,par+1,high);
        }
    }

    public static void threeNumMid(int[] array,int low,int high) {
        int mid = (high + low)/2;
        int ret = array[low] < array[mid] ? array[low] : array[mid];
        ret = array[ret] < array[high] ? array[ret] : array[high];

    }
    public static void quickSort2(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        int par = 0;
        stack.push(low);
        stack.push(high);
        while(!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            par = partition(array,low,high);
            if(par > low+1) {
                stack.push(low);
                stack.push(par-1);
            }
            if(par < high-1) {
                stack.push(par+1);
                stack.push(high);
            }
        }
    }

}
