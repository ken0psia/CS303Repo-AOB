package Assignment3;
import java.util.Objects;

public class Queue<T extends Comparable<T>> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;
        
    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = node;
        size++;
    }

    public T dequeue() {
        if (head == null) throw new IllegalStateException("Queue is empty");
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return head == null ? null : head.data;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public T poll() {
        if (head == null) return null;
        return head.data;
    }

    public boolean offer(T data) {
        enqueue (data); 
        return true;
    }

    public void moveToEnd() {
        if (peek() == null || poll() == null) return; // empty or single element
        Node<T> oldHead = head;
        
        offer(oldHead.data);
        head = head.next;
    }

    private int search(Node<T> current, T key, int index) { //private method
        if (current == null) return -1;
        int lastIndex = search(current.next, key, index + 1);
        if (lastIndex != -1) return lastIndex;
        if (current.data.equals(key)) return index;
        return Objects.equals(current.data, key) ? index : -1;
    }
    public int contains (T target) {
        return search(head, target, 0);
    }

    public Node<T> insertionSort() {
        if (head == null || head.next == null) return head;
        Node<T> off = new Node<>(null);
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            Node<T> prev = off;
            while (prev.next != null && prev.next.data.compareTo(current.data) < 0) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        head = off.next;
        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
