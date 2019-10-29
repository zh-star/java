/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -10
 * Time: 19:15
 */
public class Test {
    public static void main(String[] args){
        DlinkedList dlinkedList = new DlinkedList();
        dlinkedList.addFirst(1);
        dlinkedList.addFirst(2);
        dlinkedList.addFirst(3);
        dlinkedList.addFirst(4);
        dlinkedList.display();

    }
    public static void main1(String[] args){
        DoubleList doubleList = new DoubleList();
//        doubleList.addFirst(1);
//        doubleList.addFirst(2);
//        doubleList.addFirst(3);
//        doubleList.addFirst(4);
//        doubleList.display();
        doubleList.addLast(1);
        doubleList.addLast(1);
        doubleList.addLast(3);
        doubleList.addLast(4);
//        doubleList.display();
//        System.out.println(doubleList.size());
//        doubleList.addIndex(5,10);

//        doubleList.display();
//        //System.out.println(doubleList.remove(4));
//        doubleList.display();
//        doubleList.removeAllKey(1);
        //doubleList.clear();
        doubleList.display();
        doubleList.clear();
        System.out.println("=============");
    }

}
