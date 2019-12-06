package package7;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 11:19
 */

public class HashBuck<K,V> {
    static class Node<K,V> {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V>[] array;
    private int usedSize;

    public HashBuck() {
        this.array = (Node<K,V>[])new Node[10];
    }

    public void push(K key, V value) {
        //1. 先找到key对应的唯一的hash值
        int hash = key.hashCode();
        int index = hash%array.length;
        //遍历当前下表对应数组位置 中的节点
        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if(cur.key.equals(key)) {
                // 若 插入的key和 已存在 将value直接覆盖
                cur.value = value;
                return;
            }
        }
        //循环结束，就说明该位置桶中不存在该元素，直接头插法放在桶中
        Node<K,V> node = new Node<>(key,value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        //扩容
        if(this.usedSize*0.1/array.length >= 0.75) {
            resize();
        }

    }
    private void resize() {
        //1.新建一个长度为原数组二倍的数组
        Node<K,V>[] newArray = (Node<K,V>[])new Node[2*array.length];
        //2.遍历原数组，并遍历数组中的每个桶
        for (int i = 0; i < array.length; i++) {
            Node<K,V> curNext;
            for (Node<K,V> cur = array[i]; cur != null; cur = curNext) {
                curNext = cur.next;
                // 找到当前节点的key值在newArray中的小标位置
                int newIndex = cur.key.hashCode() % newArray.length;

                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
            }
        }
        this.array = newArray;
    }

    public V get(K key) {
        int index = key.hashCode()%array.length;
        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
        }
        return null;
    }
}
