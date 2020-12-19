package datastructure;

import java.util.Objects;

public class LinkedList<E> {
    private LinkedList.Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public E value_at(int index) {
        LinkedList.Node<E> pointer = head;
        for (int i = 0; i < index; i++) {
            if (Objects.isNull(pointer)) {
                throw new ArrayIndexOutOfBoundsException("Index is out of bounds, index : " + index + " size : " + this.size);
            }
            pointer = pointer.next;
        }
        return pointer.val;
    }

    public void push_front(E value) {
        LinkedList.Node<E> first = this.head;
        this.head = new Node<>(value, first);
        this.size++;
    }

    public E pop_front() {
        if (Objects.isNull(this.head)) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        } else {
            E val = this.head.val;
            this.head = this.head.next;
            this.size--;
            return val;
        }
    }

    public void push_back(E value) {
        if (this.head == null) {
            push_front(value);
        } else {
            LinkedList.Node<E> pointer = this.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node<>(value, null);
        }
        this.size++;
    }

    public E pop_back() {
        if (Objects.isNull(this.head)) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        } else if (Objects.isNull(this.head.next)) {
            E val = this.head.val;
            this.head = null;
            size--;
            return val;
        } else {
            Node<E> pointer = this.head;
            while (pointer.next.next != null) {
                pointer = pointer.next;
            }
            E val = pointer.next.val;
            pointer.next = null;
            size--;
            return val;
        }
    }

    public E front() {
        if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        } else {
            return this.head.val;
        }
    }

    public E back() {
        if (this.head == null) {
            throw new ArrayIndexOutOfBoundsException("List is empty");
        } else {
            Node<E> pointer = this.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            return pointer.val;
        }
    }

    public void insert(int index, E value) {
        Node<E> pointer = this.head;
        if (index == 0) {
            push_front(value);
        } else {
            for (int i = 1; i < index; i++) {
                if (pointer == null) {
                    throw new ArrayIndexOutOfBoundsException("Index is out of bounds, index : " + index + " size : " + this.size);
                }
                pointer = pointer.next;
            }
            Node<E> temp = pointer.next;
            pointer.next = new Node<>(value, temp);
            this.size++;
        }
    }

    public void erase(int index) {
        Node<E> pointer = this.head;
        if (index == 0) {
            this.head = pointer.next;
        } else {
            for (int i = 1; i < index; i++) {
                if (pointer == null || pointer.next == null) {
                    throw new ArrayIndexOutOfBoundsException("Index is out of bounds, index : " + index + " size : " + this.size);
                }
                pointer = pointer.next;
            }
            Node<E> temp = pointer.next;
            pointer.next = temp.next;
        }
        this.size--;
    }

    public E value_n_from_end(int index) {
        Node<E> pointer1 = this.head;
        Node<E> pointer2 = this.head;

        for (int i = 1; i < index; i++) {
            if (pointer1 == null) {
                throw new ArrayIndexOutOfBoundsException("Index is out of bounds, index : " + i + " size : " + this.size);
            }
            pointer1 = pointer1.next;
        }

        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2.val;
    }

    public void reverse() {
        Node<E> pointer = this.head;
        Node<E> modified = new Node<>(this.head.val, null);

        while (pointer.next != null) {
            Node<E> temp = modified;
            modified = new Node<>(pointer.next.val, temp);
            pointer = pointer.next;
        }

        this.head = modified;
    }

    public void remove_value(E value) {
        Node<E> pointer = this.head;
        if (Objects.nonNull(pointer)) {
            if (pointer.val.equals(value)) {
                this.head = pointer.next;
                this.size--;
            } else {
                while (pointer.next != null) {
                    if (pointer.next.val.equals(value)) {
                        pointer.next = pointer.next.next;
                        this.size--;
                        break;
                    }
                    pointer = pointer.next;
                }
            }
        }
    }

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val, Node<E> next) {
            this.val = val;
            this.next = next;
        }
    }

}
