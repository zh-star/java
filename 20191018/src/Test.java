import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 10:38
 */
public class Test {
    //1.数组中的最大值
    public static int maxArray(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //2.逆置数组
    public static int[] func1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
        return arr;
    }
    //3.二分查找
    public static int binarySearch1(int[] array,int key) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(key < array[mid]) {
                right = mid - 1;
            }
            if(key > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    //递归版本二叉树
    public static int binarySearch(int[] array, int left, int right, int key) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right)/ 2;
        if(array[mid] == key) {
            return mid;
        } else if(array[mid] > key) {

            return binarySearch(array, left, mid - 1, key);

        } else {
            return binarySearch(array, mid + 1, right,key);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arrary) {
        boolean flag = false;
        for(int i = 0; i < arrary.length - 1; i++) {
            flag = false;
            for(int j = 0; j < arrary.length - 1 - i; j++) {
                if(arrary[j] > arrary[j+1]) {
                    int temp = arrary[j];
                    arrary[j] = arrary[j+ 1];
                    arrary[j + 1] = temp;
                    flag = true;
                }
            }
            //这一趟没有发生交换，就说明已经有序了
            if(!flag) {
                return;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {8,4,5,2,6};
//        int ret = maxArray(arr);
//        System.out.println("最大值是：" + ret);

//        int[] ret = func1(array);
//        System.out.println(Arrays.toString(ret));

//        int ret = binarySearch(array,0,array.length -1,2);
//        System.out.println(ret);

        Arrays.copyOfRange(array,2,5);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
