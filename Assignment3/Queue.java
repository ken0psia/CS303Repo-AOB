package Assignment3;
import java.util.Objects;

public class Queue<T extends Comparable<? super T>> {
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
    
    public void enqueue(T data) { //adds to the rear
        Node<T> node = new Node<>(data);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = node;
        size++;
    }

    public T dequeue() { //removes from the front
        if (head == null) throw new IllegalStateException("Queue is empty");
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public boolean isEmpty() { //checks if the queue is empty
        return size == 0;
    }

    public int size() { //returns # of elements
        return size;
    }

    public T peek() { //returns front element without removing
        return head == null ? null : head.data;
    }

    public void clear() {//clears queue
        head = tail = null;
        size = 0;
    }

    public T poll() {//returns front element or null if empty
        if (head == null) return null;
        return head.data;
    }

    public boolean offer(T data) {//enqueue wrapper returning true
        enqueue (data); 
        return true;
    }

    public void moveToEnd() {//moves front element to the end
        if (head == null || head.next == null) return; // empty or single element
        Node<T> oldHead = head;
        head = head.next;
        oldHead.next = null;
        tail.next = oldHead;
        tail = oldHead;
    }

    private int search(Node<T> current, T key, int index) { //private search method
        if (current == null) return -1;
        int lastIndex = search(current.next, key, index + 1);
        if (lastIndex != -1) return lastIndex;
        return Objects.equals(current.data, key) ? index : -1;
    }
    public int contains (T target) { //wrapper for search method
        return search(head, target, 0);
    }

    public Node<T> insertionSort() {
        if (head == null || head.next == null) return head;
        Node<T> off = new Node<>(null);
        Node<T> current = head;
        //traverses list and inserts each node into the sorted part
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
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        return head;
    }

    public String toString() { //queue print method
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
