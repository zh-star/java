import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 10:19
 */
public class TestSort {
    public static void main(String[] args){
        //int[] array = {13,8,2,7,10};
        int[] array = {5,9,12,6,8,34,33,56,89,0,4,7,22,55,77};
        //insertSort(array);
        shellSort(array);
        System.out.println(Arrays.toString(array));
//        selectSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    //直接插入排序 ：从数组中第二个元素开始与前面的分别进行比较，前面的大，交换，反之不交换
    //时间复杂度：O(n*2) 空间复杂度: O(1)  稳定
    public static void insertSort(int[] array) {
        for(int i = 1; i < array.length; i ++) {
            int j = i-1;
            int temp = array[i];
            for (; j >= 0 ; j--) {
                if(temp < array[j]) {
                    array[j + 1] = array[j];
                } else {

                    break;
                }
            }
            array[j + 1] = temp;

        }
    }

    //希尔排序 ： 将无序数组分为按照每次素数大小进行分组，再进行直接插入排序
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
        //创建堆，而且创建的是大根堆
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
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
}
