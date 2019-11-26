package package1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 19:33
 */
public class TestDemo1 {
    public static void main(String[] args){

        int[] array = {13,8,2,7,10,9,11,15,12,6};
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.display();
        testHeap.pushHeap(14);
        testHeap.display();
        testHeap.popHeap();
        testHeap.display();

        testHeap.heapSort();
        testHeap.display();



    }
}
