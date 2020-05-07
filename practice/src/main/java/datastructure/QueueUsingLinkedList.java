package datastructure;

public class QueueUsingLinkedList<E> implements Queue<E> {

    private QueueUsingLinkedList.Node<E> head;
    private QueueUsingLinkedList.Node<E> tail;

    public QueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean empty() {
        return this.head == null;
    }

    @Override
    public void enqueue(E value) {
        if (this.head == null) {
            this.head = new Node<>(value, null);
            this.tail = this.head;
        } else {
            this.tail.next = new Node<>(value, null);
            this.tail = this.tail.next;
        }
    }

    public E dequeue() {
        if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("Queue Empty");
        } else if (this.head == this.tail) {
            Node<E> temp = this.head;
            this.head = this.head.next;
            this.tail = this.tail.next;
            return temp.val;
        } else {
            Node<E> temp = this.head;
            this.head = this.head.next;
            return temp.val;
        }
    }


    private static class Node<E> {
        E val;
        QueueUsingLinkedList.Node<E> next;

        Node(E val, QueueUsingLinkedList.Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

}
