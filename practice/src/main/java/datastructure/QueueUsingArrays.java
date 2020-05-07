package datastructure;

public class QueueUsingArrays<E> implements Queue<E> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] elementData;
    private int head;
    private int tail;

    public QueueUsingArrays() {
        this(DEFAULT_SIZE);
    }

    public QueueUsingArrays(int size) {
        this.elementData = new Object[size];
        this.head = -1;
        this.tail = -1;
    }

    @Override
    public void enqueue(E value) {
        if (this.empty()) {
            this.head = 0;
            this.tail = 0;
            this.elementData[0] = value;
        } else if (this.full()) {
            throw new ArrayIndexOutOfBoundsException("Queue Full");
        } else {
            this.tail = this.getNext(this.tail, this.elementData.length);
            this.elementData[this.tail] = value;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (this.empty()) {
            throw new ArrayIndexOutOfBoundsException("Queue Empty");
        } else {
            Object val = this.elementData[this.head];
            this.elementData[this.head] = null;
            this.head = this.getNext(this.head, this.elementData.length);
            return (E) val;
        }
    }

    private int getNext(int pos, int length) {
        return pos == length - 1 ? 0 : pos + 1;
    }

    @Override
    public boolean empty() {
        return this.head == -1 || this.tail == -1 || this.head == getNext(this.tail, this.elementData.length);
    }

    public boolean full() {
        return getNext(getNext(this.tail, this.elementData.length), this.elementData.length) == this.head;
    }
}
