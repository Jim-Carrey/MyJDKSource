/*
双链表类（实现思路） ：
    成员变量：
        transient int size;     链表size
        transient Node<E> first;    头结点
        transient Node<E> last;     尾结点
        private static final long serialVersionUID = 876323262645176354L;       序列化编号

    构造方法：
    public LinkedList() {
    }

    Node类：
    private static class Node<E> {
        E item;     节点数据（值）
        Node<E> next;   下一个节点
        Node<E> prev;   上一个节点

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    LinkedList主要方法：
    ①尾部插入数据：
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    ②指定索引插入数据
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }
    ③






 */


public class MyLinkedList {
}
