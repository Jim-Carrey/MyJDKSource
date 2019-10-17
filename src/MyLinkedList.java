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
    ③返回指定索引的节点
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    ④get方法 根据索引获取链表中对应节点的值
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
    ⑤remove方法
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
    unlink:
    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }
*/


import java.io.Serializable;

public class MyLinkedList<E> implements Serializable {

        transient int size;

        transient Node<E> first;

        transient Node<E> last;

        private  static final long serialVersionUID = 876323262645176354L;

        public MyLinkedList(){

        }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //尾部插入数据
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    private void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l,e,null);
            if (l==null)
                first = newNode;
            else
                l.next = newNode;
            size++;
    }

    //指定索引插入数据
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size)
            linkLast(element);
        else
            linkBefore(element, node(index));
    }

    private void linkBefore(E element, Node<E> node) {
        final Node<E> pred = node.prev;
        final Node<E> newNode = new Node<>(pred, element, node);
        node.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    //根据索引遍历返回对应节点
    private Node<E> node(int index) {
            // assert isElementIndex(index);
            if (index < (size >> 1)) { //右移一位除以2，左移一位乘以2
                Node<E> x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x;
            } else {
                Node<E> x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x;
            }
    }

    //根据索引取到对应节点的值
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
            return "Index: "+index+", Size: "+size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


}
