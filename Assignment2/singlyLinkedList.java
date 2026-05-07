package Assignment2;
import java.util.NoSuchElementException;
//NoSuchElementException will be thrown following every error due to the datatype being generic

public class singlyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    Node<T> head = null;
    Node<T> tail = null;
    int size = 0;

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }
    
    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException(); // if empty
        if (head == tail) { //if there is only one element, remove last make remaining element head and tail
            T data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next != tail) { //finds last element and makes the element before it the new tail
            current = current.next;
        }
        T data = tail.data;
        tail = current;
        tail.next = null;
        size--;
        return data;
    }

    public T getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    public T getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException(); //boundary check - will not use NoSuchElementException
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> node = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {//sets current before target for insertion to be placed in its next
                current = current.next; 
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {//sets current before target for removal
            current = current.next;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public int find(T item) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item)) return i; //returns index of the first occurrence of item
            current = current.next;
        }
        return -1; //otherwise item was not found
    }
}
