package datastructure;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    boolean empty();
}
