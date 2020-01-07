package p20200107;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2020 -01
 * Time: 20:55
 */
public class p20200103 {
    public static void main(String[] args){

        第二题链表的相加 ma = new 第二题链表的相加();
        ListNode head = null;
        head = ma.addLater(1,head);
        head = ma.addLater(2,head);
        head = ma.addLater(3,head);
        ma.display(head);
        System.out.println();
        ListNode head2 = null;
        head2 = ma.addLater(7,head2);
        head2 = ma.addLater(2,head2);
        head2 = ma.addLater(1,head2);
        ma.display(head2);
        System.out.println();

        ListNode head3 = ma.plusAB2(head,head2);
        ma.display(head3);

    }
}
