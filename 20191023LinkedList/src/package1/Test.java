package package1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -11
 * Time: 17:22
 */
public class Test {
    public static void main(String[] args){
        LinkedList node1 = new LinkedList();
        LinkedList node2 = new LinkedList();
        LinkedList node3 = new LinkedList();
        node1.addAtTail(1);
        node1.addAtTail(2);
        node1.addAtTail(3);
        node2.addAtTail(1);
        node2.addAtTail(2);
        node2.addAtTail(3);
        System.out.println();
        ListNode ret = node3.addTwoNumbers(node1,node2);
    }

}
